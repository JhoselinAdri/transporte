package com.grupo.controlador.parada;

import com.grupo.dao.AvisosDAO;
import com.grupo.dao.AvisosDAOimpl;
import com.grupo.modelo.Avisos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PInicioController", urlPatterns = {"/PInicioController"})
public class PInicioController extends HttpServlet {

    AvisosDAO dao = new AvisosDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Avisos> avisos = new ArrayList<Avisos>();
        try {
            avisos = dao.getAllParada();
        } catch (Exception ex) {
            System.out.println("Error al buscar " + ex);
        }
        request.setAttribute("av", avisos);
        request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Inicio.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Avisos> avisos = new ArrayList<Avisos>();
        try {
            avisos = dao.getAllParada();
        } catch (Exception ex) {
            System.out.println("Error al buscar " + ex);
        }
        request.setAttribute("av", avisos);
        request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Inicio.jsp").forward(request, response);
    }

}
