package com.grupo.controlador;

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

@WebServlet(name = "IndexController", urlPatterns = {"/IndexController"})
public class IndexController extends HttpServlet {

    AvisosDAO dao = new AvisosDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Avisos> comunicados = new ArrayList<Avisos>();
        try {
            comunicados = dao.getAllTodos();
        } catch (Exception e) {
            System.out.println("Error al llamar al dao inicio " + e);
        }
        System.out.println("Todo Correcto");
        request.setAttribute("av", comunicados);
        request.getRequestDispatcher("Index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Avisos> comunicados = new ArrayList<Avisos>();
        try {
            comunicados = dao.getAllTodos();
        } catch (Exception e) {
            System.out.println("Error al llamar al dao inicio " + e);
        }
        System.out.println("Todo Correcto");
        request.setAttribute("av", comunicados);
        request.getRequestDispatcher("Index.jsp").forward(request, response);
    }

}
