/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grupo.controlador;

import com.grupo.dao.vista.VACDAOimpl;
import com.grupo.dao.vista.VCADAO;
import com.grupo.modelo.vistas.VistaAC;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DetallesController", urlPatterns = {"/DetallesController"})
public class DetallesController extends HttpServlet {
    VCADAO dao=new VACDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id_aporte"));
        VistaAC aporte=new VistaAC();
        try {
            aporte=dao.getById(id);
            
        } catch (Exception ex) {
            System.out.println("Eror desde el dao "+ex);
        }
        System.out.println(aporte.getNombre_aporte());
        request.setAttribute("aportes", aporte);
        request.getRequestDispatcher("UsuarioChofer/Vista_Detalles.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
