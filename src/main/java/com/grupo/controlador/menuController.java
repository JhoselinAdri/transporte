/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grupo.controlador;

import com.grupo.dao.AvisosDAO;
import com.grupo.dao.AvisosDAOimpl;
import com.grupo.modelo.Avisos;
import com.grupo.modelo.vistas.VistaDCV;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "menuController", urlPatterns = {"/menuController"})
public class menuController extends HttpServlet {

    AvisosDAO dao = new AvisosDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        VistaDCV usuario = new VistaDCV();
        if (session.getAttribute("loged") != "Chofer") {
            response.sendRedirect("login_chofer.jsp");
        } else {
            List<Avisos> avisos = new ArrayList<Avisos>();
            try {
                avisos=dao.getAllChofer();
            } catch (Exception ex) {
                System.out.println("Error al buscar "+ex);
            }
            request.setAttribute("av", avisos);
            request.getRequestDispatcher("UsuarioChofer/Menu.jsp").forward(request, response);
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session = request.getSession();
        VistaDCV usuario = new VistaDCV();
        if (session.getAttribute("loged") != "Chofer") {
            response.sendRedirect("login_chofer.jsp");
        } else {
            List<Avisos> avisos = new ArrayList<Avisos>();
            try {
                avisos=dao.getAllChofer();
            } catch (Exception ex) {
                System.out.println("Error al buscar "+ex);
            }
            request.setAttribute("av", avisos);
            request.getRequestDispatcher("UsuarioChofer/Menu.jsp").forward(request, response);
        }
        
    }

}
