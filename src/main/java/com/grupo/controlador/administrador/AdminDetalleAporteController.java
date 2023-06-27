
package com.grupo.controlador.administrador;

import com.grupo.dao.vista.VACDAOimpl;
import com.grupo.dao.vista.VCADAO;
import com.grupo.modelo.vistas.VistaAC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminDetalleAporteController", urlPatterns = {"/AdminDetalleAporteController"})
public class AdminDetalleAporteController extends HttpServlet {


    VCADAO dao=new VACDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int n= Integer.parseInt(request.getParameter("id"));
        VistaAC aporte=new VistaAC();
        try {
            aporte=dao.getById(n);
            
        } catch (Exception ex) {
            System.out.println("Eror desde el dao "+ex);
        }
        System.out.println(aporte.getNombre_aporte());
        request.setAttribute("aportes", aporte);
        request.getRequestDispatcher("admin/AdminDetaAporte.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
