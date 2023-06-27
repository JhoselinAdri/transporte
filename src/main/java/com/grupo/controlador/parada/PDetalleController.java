package com.grupo.controlador.parada;

import com.grupo.dao.VueltaDAO;
import com.grupo.dao.VueltaDAOimp;
import com.grupo.dao.vista.VDCVDAO;
import com.grupo.dao.vista.VDCVDAOimpl;
import com.grupo.modelo.Vuelta;
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

@WebServlet(name = "PDetalleController", urlPatterns = {"/PDetalleController"})
public class PDetalleController extends HttpServlet {

    VDCVDAO daoC = new VDCVDAOimpl();
    VueltaDAO daoV = new VueltaDAOimp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ci = Integer.parseInt(request.getParameter("ci"));
        int n = Integer.parseInt(request.getParameter("n"));
        int linea= Integer.parseInt(request.getParameter("linea"));
        System.out.println(ci + " " + n);
        VistaDCV chofer = new VistaDCV();
        chofer.setCi(ci);
        VistaDCV v = new VistaDCV();
        List<Vuelta> vuelt = new ArrayList<Vuelta>();
        try {
            v = daoC.idChofer(chofer);
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao" + ex);
        }
        Vuelta vuelta = new Vuelta();
        vuelta.setN_ruta(n);
        try {
            vuelt = daoV.getAllByid(vuelta);
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao desde vuelta" + ex);
        }
        request.setAttribute("n_ruta", n);
        request.setAttribute("linea", linea);
        request.setAttribute("lista", vuelt);
        request.setAttribute("datos", v);
        request.getRequestDispatcher("Usuario_Parada/Vista_Detalles_Parada.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
