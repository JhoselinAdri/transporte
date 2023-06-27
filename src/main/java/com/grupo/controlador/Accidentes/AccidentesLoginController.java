/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grupo.controlador.Accidentes;

import com.grupo.dao.CAccidenteDAO;
import com.grupo.dao.CAccidentesDAOimpl;
import com.grupo.modelo.Control_accidentes;
import com.grupo.modelo.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juans
 */
@WebServlet(name = "AccidentesLoginController", urlPatterns = {"/AccidentesLoginController"})
public class AccidentesLoginController extends HttpServlet {

    CAccidenteDAO dao = new CAccidentesDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Control_accidentes usuario = new Control_accidentes();
        if (session.getAttribute("loged") != "Accidente") {
            response.sendRedirect("AccidentesLogin.jsp");
        } else {
            request.getRequestDispatcher("AccidentesInicioController").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Control_accidentes lg = new Control_accidentes();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        lg.setUsername(username);
        lg.setPassword(password);
        Control_accidentes login = new Control_accidentes();
        Control_accidentes ver = new Control_accidentes();
        try {

            login = dao.loginChofer(lg);

            if (login.getUsername() == null) {
                Mensaje men = new Mensaje();
                men.setMensaje("Usuario o contraseña incorrecto");
                request.setAttribute("men", men);
                request.getRequestDispatcher("AccidentesLogin.jsp").forward(request, response);
                System.out.println("Error al ingresar");
            } else {
                ver = dao.loginChoferVer(lg);
                if (ver.getUsername() != null) {
                    System.out.println("Todo correcto");
                    HttpSession session = request.getSession();
                    session.setAttribute("loged", "Accidente");
                    session.setAttribute("usuario", login);
                    request.getRequestDispatcher("AccidentesInicioController").forward(request, response);
                }else{
                    Mensaje men = new Mensaje();
                men.setMensaje("Usted esta Bloqueado, Contactese con el Administrador");
                request.setAttribute("men", men);
                request.getRequestDispatcher("AccidentesLogin.jsp").forward(request, response);
                System.out.println("Error al ingresar");
                }

            }

        } catch (Exception ex) {
            System.out.println("Error al buscarrr " + ex.getMessage());

        }

    }

}
