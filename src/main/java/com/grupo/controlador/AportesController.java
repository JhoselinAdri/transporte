/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grupo.controlador;

import com.grupo.dao.vista.VACDAOimpl;
import com.grupo.dao.vista.VCADAO;
import com.grupo.modelo.vistas.VistaAC;
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
@WebServlet(name = "AportesController", urlPatterns = {"/AportesController"})
public class AportesController extends HttpServlet {
    VCADAO dao = new VACDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VistaDCV usuario= new VistaDCV();
        VistaAC aporte=new VistaAC();
        HttpSession session = request.getSession();
        usuario = (VistaDCV) session.getAttribute("usuario");
        
        
        List<VistaAC> lista = new ArrayList<VistaAC>();
        try {
            
            lista = dao.ViewApoptesChofer(usuario);
            
            System.out.println(lista);
            System.out.println("Salio bien");
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao "+ ex);
        }
        
        
        request.setAttribute("aportes", lista);
        request.getRequestDispatcher("UsuarioChofer/Vista_Aportes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
