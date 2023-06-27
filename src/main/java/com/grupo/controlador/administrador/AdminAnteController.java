package com.grupo.controlador.administrador;

import com.grupo.dao.AccidentesDAO;
import com.grupo.dao.AccidentesDAOimpl;
import com.grupo.modelo.Accidentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juans
 */
@WebServlet(name = "AdminAnteController", urlPatterns = {"/AdminAnteController"})
public class AdminAnteController extends HttpServlet {

    AccidentesDAO dao = new AccidentesDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Accidentes> lista = null;
        try {
            lista = dao.getAll();
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao" + ex);
        }
        request.setAttribute("acc", lista);
        request.getRequestDispatcher("admin/Vista_Antecedentes.jsp").forward(request, response);
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
        request.getRequestDispatcher("admin/Vista_Antecedentes.jsp").forward(request, response);
    }

}
