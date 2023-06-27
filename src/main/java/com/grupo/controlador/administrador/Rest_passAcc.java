/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grupo.controlador.administrador;

import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.dao.ControlAccidentesDAO;
import com.grupo.dao.ControlAccidentesDAOimpl;
import com.grupo.modelo.Chofer;
import com.grupo.modelo.Control_accidentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juans
 */
@WebServlet(name = "Rest_passAcc", urlPatterns = {"/Rest_passAcc"})
public class Rest_passAcc extends HttpServlet {

    ControlAccidentesDAO dao = new ControlAccidentesDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Control_accidentes ch= new Control_accidentes();
        String pass=request.getParameter("ci");
        System.out.println(pass);
        int ci=Integer.parseInt(request.getParameter("ci"));
        System.out.println(ci);
        ch.setCi(ci);
        ch.setPassword(pass);
        try {
            dao.updatePass(ch);
            System.out.println("Actualizado con exito");
        } catch (Exception ex) {
            System.out.println("Error al Llamar al dao" +ex);
        }
        request.getRequestDispatcher("admin/Vista_Admin_Inicio.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
