package com.grupo.controlador.Accidentes;

import com.grupo.dao.AccidentesDAO;
import com.grupo.dao.AccidentesDAOimpl;
import com.grupo.modelo.Accidentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AccidenteListaController", urlPatterns = {"/AccidenteListaController"})
public class AccidenteListaController extends HttpServlet {

    AccidentesDAO dao = new AccidentesDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Accidentes> lista = null;
        try {
            lista = dao.getAll();
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao" +ex);
        }
        request.setAttribute("acc", lista);
        request.getRequestDispatcher("Accidentes/Accidentes_Vista_Lista_Notificaciones.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               List<Accidentes> lista = null;
        try {
            lista = dao.getAll();
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao" + ex);
        }
        request.setAttribute("acc", lista);
        request.getRequestDispatcher("Accidentes/Accidentes_Vista_Lista_Notificaciones.jsp").forward(request, response);
    }


}
