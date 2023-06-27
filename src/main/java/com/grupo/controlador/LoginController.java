package com.grupo.controlador;

import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.dao.vista.VDCVDAO;
import com.grupo.dao.vista.VDCVDAOimpl;
import com.grupo.modelo.Chofer;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.vistas.VistaDCV;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    VDCVDAO dao = new VDCVDAOimpl();
    ChoferDAO daoc = new ChoferDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        VistaDCV usuario = new VistaDCV();
        if (session.getAttribute("loged") != "Chofer") {
            response.sendRedirect("login_chofer.jsp");
        } else {
            request.getRequestDispatcher("UsuarioChofer/Menu.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VistaDCV chr = new VistaDCV();
        Chofer ch = new Chofer();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        chr.setUsername(username);
        chr.setPassword(password);
        ch.setUsername(username);
        ch.setPassword(password);
        VistaDCV chofer = new VistaDCV();
        Chofer val = new Chofer();
        Mensaje men = new Mensaje();
        try {
            val = daoc.loginChofer(ch);
            chofer = dao.loginChofer(chr);
            if (chofer.getUsername() == null) {

                men.setMensaje("Usuario o contraseña invalido");
                request.setAttribute("men", men);
                request.getRequestDispatcher("login_chofer.jsp").forward(request, response);
                System.out.println("Error al ingresar");
            } else {
                if (val.getUsername() == null) {
                    men.setMensaje("Usted esta bloqueado temporalmente!!!comuniquese con el administrador");
                    request.setAttribute("men", men);
                    request.getRequestDispatcher("login_chofer.jsp").forward(request, response);
                    System.out.println("Error al ingresar");
                    System.out.println("El usuario no esta activo");
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("loged", "Chofer");
                    session.setAttribute("usuario", chofer);
                    request.getRequestDispatcher("menuController").forward(request, response);
                }

            }

        } catch (Exception ex) {
            System.out.println("Error al buscarrr " + ex.getMessage());

        }

    }
}
