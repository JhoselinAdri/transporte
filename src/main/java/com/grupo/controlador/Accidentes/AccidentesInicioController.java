package com.grupo.controlador.Accidentes;

import com.grupo.dao.AvisosDAO;
import com.grupo.dao.AvisosDAOimpl;
import com.grupo.modelo.Avisos;
import com.grupo.modelo.Control_accidentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AccidentesInicioController", urlPatterns = {"/AccidentesInicioController"})
public class AccidentesInicioController extends HttpServlet {


    AvisosDAO dao = new AvisosDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Control_accidentes usuario = new Control_accidentes();
        if (session.getAttribute("loged") != "Accidente") {
            response.sendRedirect("AccidentesLogin.jsp");
        } else {
            List<Avisos> avisos = new ArrayList<Avisos>();
        try {
            avisos = dao.getAllAccidentes();
        } catch (Exception ex) {
            System.out.println("Error al buscar " + ex);
        }
        request.setAttribute("av", avisos);
            request.getRequestDispatcher("Accidentes/Accidentes_Vista_Inicio.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Control_accidentes usuario = new Control_accidentes();
        if (session.getAttribute("loged") != "Accidente") {
            response.sendRedirect("AccidentesLogin.jsp");
        } else {
            List<Avisos> avisos = new ArrayList<Avisos>();
        try {
            avisos = dao.getAllAccidentes();
        } catch (Exception ex) {
            System.out.println("Error al buscar " + ex);
        }
        request.setAttribute("av", avisos);
            request.getRequestDispatcher("Accidentes/Accidentes_Vista_Inicio.jsp").forward(request, response);
        }
    }

}
