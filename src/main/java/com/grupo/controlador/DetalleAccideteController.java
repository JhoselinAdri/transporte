/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grupo.controlador;

import com.grupo.dao.vista.VACDAOimpl;
import com.grupo.dao.vista.VACDDAO;
import com.grupo.dao.vista.VACDDAOimpl;
import com.grupo.modelo.vistas.VistaACD;
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
@WebServlet(name = "DetalleAccideteController", urlPatterns = {"/DetalleAccideteController"})
public class DetalleAccideteController extends HttpServlet {
    
    VACDDAO dao = new VACDDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VistaDCV usuario= new VistaDCV();
        HttpSession session = request.getSession();
        usuario = (VistaDCV) session.getAttribute("usuario");
        List<VistaACD> lista = new ArrayList<VistaACD>();
        
        try {
            lista= dao.ViewAccidentesChofer(usuario);
        } catch (Exception ex) {
            System.out.println("Error en el controlador de detalles de accidentes"+ex);
        }
        request.setAttribute("ac", lista);
        request.getRequestDispatcher("UsuarioChofer/Vista_Det_accidente.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VistaDCV usuario= new VistaDCV();
        HttpSession session = request.getSession();
        usuario = (VistaDCV) session.getAttribute("usuario");
        List<VistaACD> lista = new ArrayList<VistaACD>();
        
        try {
            lista= dao.ViewAccidentesChofer(usuario);
        } catch (Exception ex) {
            System.out.println("Error en el controlador de detalles de accidentes"+ex);
        }
        request.setAttribute("ac", lista);
        request.getRequestDispatcher("UsuarioChofer/Vista_Det_accidente.jsp").forward(request, response);

    }
}
