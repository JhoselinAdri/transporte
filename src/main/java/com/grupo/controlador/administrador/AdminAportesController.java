package com.grupo.controlador.administrador;

import com.grupo.dao.vista.VACDAOimpl;
import com.grupo.dao.vista.VCADAO;
import com.grupo.modelo.vistas.VistaAC;
import com.grupo.modelo.vistas.VistaDCV;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminAportesController", urlPatterns = {"/AdminAportesController"})
public class AdminAportesController extends HttpServlet {

    VCADAO dao = new VACDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VistaDCV chofer = new VistaDCV();
        VistaAC aporte = new VistaAC();
        List<VistaAC> lista = new ArrayList<VistaAC>();
        try {
            lista = dao.ViewApoptes();
        } catch (Exception ex) {
            System.out.println("Error al llamar los datos" + ex);
        }
        request.setAttribute("ap", lista);
        request.setAttribute("datos", chofer);
        request.getRequestDispatcher("admin/Vista_Admin_Aportes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("formulario");
        if (accion.equals("buscar")) {
            VistaDCV chofer = new VistaDCV();
            int ci = Integer.parseInt(request.getParameter("ci"));
            chofer.setCi(ci);
            VistaAC aporte = new VistaAC();
            List<VistaAC> lista = new ArrayList<VistaAC>();
            try {
                lista = dao.ViewApoptesChofer(chofer);
            } catch (Exception ex) {
                System.out.println("Error al llamar los datos" + ex);
            }
            request.setAttribute("ap", lista);
            request.setAttribute("datos", chofer);
            request.getRequestDispatcher("admin/Vista_Admin_Aportes.jsp").forward(request, response);
        }

    }

}
