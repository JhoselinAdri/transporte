/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grupo.controlador.parada;

import com.grupo.dao.ControlRutaDAO;
import com.grupo.dao.ControlRutaDAOimpl;
import com.grupo.modelo.Control_ruta;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.Ruta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginParada", urlPatterns = {"/LoginParada"})
public class LoginParada extends HttpServlet {

    ControlRutaDAO dao = new ControlRutaDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Ruta usuario = new Ruta();
        if (session.getAttribute("loged") != "OK") {

            response.sendRedirect("login_parada.jsp");
        } else {
            request.getRequestDispatcher("PInicioController").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Control_ruta ca = new Control_ruta();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ca.setUsername(username);
        ca.setPassword(password);
        Control_ruta datos = new Control_ruta();
        Control_ruta ver = new Control_ruta();
        try {
            datos = dao.login(ca);
            if (datos.getUsername() == null) {
                Mensaje men = new Mensaje();
                men.setMensaje("Usuario o Contraseña incorrecto");
                request.setAttribute("men", men);
                request.getRequestDispatcher("login_parada.jsp").forward(request, response);
                System.out.println("Error al ingresar");
            } else {
                ver = dao.loginver(ca);
                if (ver.getUsername() != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("loged", "Parada");
                    session.setAttribute("usuario", datos);
                    request.getRequestDispatcher("PInicioController").forward(request, response);
                } else {
                    Mensaje men = new Mensaje();
                    men.setMensaje("Usted se encuentra bloqueado. Contactese con el administrador");
                    request.setAttribute("men", men);
                    request.getRequestDispatcher("login_parada.jsp").forward(request, response);
                    System.out.println("Error al ingresar");
                }

            }
        } catch (Exception ex) {
            System.out.println("Error al traer los datos del dao" + ex);
        }
    }

}
