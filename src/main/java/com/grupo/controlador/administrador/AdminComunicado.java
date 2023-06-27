
package com.grupo.controlador.administrador;

import com.grupo.dao.AvisosDAO;
import com.grupo.dao.AvisosDAOimpl;
import com.grupo.modelo.Avisos;
import com.grupo.modelo.Mensaje;
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

@WebServlet(name = "AdminComunicado", urlPatterns = {"/AdminComunicado"})
public class AdminComunicado extends HttpServlet {


    AvisosDAO dao= new AvisosDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Avisos av= new Avisos();
        Mensaje men =  new Mensaje();
        List <Avisos> lista = new ArrayList();
        try {
            lista=dao.getAll();
        } catch (Exception ex) {
            men.setMensaje("Error al listar");
            System.out.println("Error al llamar" +ex);
        }
        request.setAttribute("com", lista);
        request.getRequestDispatcher("admin/Vista_Comunicados.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
