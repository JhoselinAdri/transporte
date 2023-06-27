package com.grupo.controlador.administrador;

import com.grupo.dao.AvisosDAO;
import com.grupo.dao.AvisosDAOimpl;
import com.grupo.modelo.Avisos;
import com.grupo.modelo.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminVerImage", urlPatterns = {"/AdminVerImage"})
public class AdminVerImage extends HttpServlet {
    AvisosDAO dao= new AvisosDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int n= Integer.parseInt(request.getParameter("n"));
        Mensaje men =  new Mensaje();
        Avisos av= new Avisos();
        try {
            av= dao.getById(n);
        } catch (Exception ex) {
            System.out.println("Error al llamar uno "+ex);
        }
        System.out.println(av.getDescripcion());
        request.setAttribute("com", av);
        request.getRequestDispatcher("admin/Vista_Edit_Comunicado.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
