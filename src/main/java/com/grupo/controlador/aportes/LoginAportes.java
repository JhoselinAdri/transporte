/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grupo.controlador.aportes;

import com.grupo.dao.ControlAportesDAO;
import com.grupo.dao.ControlAportesDAOimpl;
import com.grupo.modelo.Control_aportes;
import com.grupo.modelo.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "LoginAportes", urlPatterns = {"/LoginAportes"})
public class LoginAportes extends HttpServlet {
    ControlAportesDAO dao=new ControlAportesDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Control_aportes usuario = new Control_aportes();
        if (session.getAttribute("loged") != "Aportes") {

            response.sendRedirect("login_aportes.jsp");
        } else {
            request.getRequestDispatcher("Usuario_Aportes/Vista_Aportes_Inicio.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Control_aportes ca = new Control_aportes();
        String username =request.getParameter("username");
        String password = request.getParameter("password");
        
        ca.setUsername(username);
        ca.setPassword(password);
        Control_aportes datos = new Control_aportes();
        Control_aportes ver = new Control_aportes();
        try {
            datos=dao.login(ca);
            ver=dao.loginver(ca);
            if(datos.getUsername()==null){
                Mensaje men = new Mensaje();
                men.setMensaje("Usuario o Contraseña incorrecto");
                request.setAttribute("men", men);
                request.getRequestDispatcher("login_aportes.jsp").forward(request, response);
                System.out.println("Error al ingresar");
            }else{
                if (ver.getUsername()!=null) {
                    HttpSession session = request.getSession();
                session.setAttribute("loged", "Aportes");
                session.setAttribute("usuario", datos);
                request.getRequestDispatcher("InicioController").forward(request, response);
                    
                }else{
                    Mensaje men = new Mensaje();
                men.setMensaje("Usted se encuentra bloqueado. Contactese con el administrador");
                request.setAttribute("men", men);
                request.getRequestDispatcher("login_aportes.jsp").forward(request, response);
                System.out.println("Error al ingresar");
                }
                
            }
        } catch (Exception ex) {
            System.out.println("Error al traer los datos del dao"+ex);
        }
    }

}
