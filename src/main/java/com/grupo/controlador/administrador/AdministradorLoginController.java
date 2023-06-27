
package com.grupo.controlador.administrador;

import com.grupo.dao.AdminDAO;
import com.grupo.dao.AdminDAOimpl;
import com.grupo.modelo.Admin;
import com.grupo.modelo.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdministradorLoginController", urlPatterns = {"/AdministradorLoginController"})
public class AdministradorLoginController extends HttpServlet {

    AdminDAO dao = new AdminDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin usuario = new Admin();
        if (session.getAttribute("loged") != "Admin") {
            request.getRequestDispatcher("LoginAdmin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("admin/Vista_Admin_Inicio.jsp").forward(request, response);
        }
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mensaje men = new Mensaje();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Admin login = new Admin();

        try {
            login = dao.Login(admin);

            if (login.getUsername() == null) {
                men.setMensaje("Usuario o contraseña invalido");
                request.setAttribute("men", men);
                request.getRequestDispatcher("LoginAdmin.jsp").forward(request, response);
                System.out.println("Error al ingresar");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("loged", "Admin");
                session.setAttribute("usuario", login);
                request.getRequestDispatcher("admin/Vista_Admin_Inicio.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            System.out.println("Error al buscarrr " + ex.getMessage());

        }
        
    }

}
