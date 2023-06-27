package com.grupo.controlador.administrador;

import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.dao.ControlAccidentesDAO;
import com.grupo.dao.ControlAccidentesDAOimpl;
import com.grupo.dao.ControlAportesDAO;
import com.grupo.dao.ControlAportesDAOimpl;
import com.grupo.dao.ControlRutaDAO;
import com.grupo.dao.ControlRutaDAOimpl;
import com.grupo.modelo.Accidentes;
import com.grupo.modelo.Aportes;
import com.grupo.modelo.Chofer;
import com.grupo.modelo.Control_accidentes;
import com.grupo.modelo.Control_aportes;
import com.grupo.modelo.Control_ruta;
import com.grupo.modelo.Ruta;
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

/**
 *
 * @author juans
 */
@WebServlet(name = "AdminRegistroController", urlPatterns = {"/AdminRegistroController"})
public class AdminRegistroController extends HttpServlet {

    ControlAportesDAO daoAp = new ControlAportesDAOimpl();
    ChoferDAO daoCh = new ChoferDAOimpl();
    ControlAccidentesDAO daoAcc = new ControlAccidentesDAOimpl();
    ControlRutaDAO daoRu = new ControlRutaDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Chofer> chofer = new ArrayList<Chofer>();
        List<Control_aportes> aportes = new ArrayList<Control_aportes>();
        List<Control_accidentes> accidentes = new ArrayList<Control_accidentes>();
        List<Control_ruta> ruta = new ArrayList<Control_ruta>();
        try {
            chofer = daoCh.findAllUsuarios();
        } catch (Exception ex) {
            System.out.println("Error al buscar chofer" + ex);
        }
        try {
            aportes = daoAp.getAll();
        } catch (Exception ex1) {
            System.out.println("Error al buscar Aportes" + ex1);;
        }
        try {
            accidentes = daoAcc.getAll();
        } catch (Exception ex2) {
            System.out.println("Error al buscar Accidetnes" + ex2);
        }
        try {
            ruta = daoRu.getAll();
        } catch (Exception ex3) {
            System.out.println("Error al buscar Rutas" + ex3);
        }

        request.setAttribute("ch", chofer);
        request.setAttribute("ap", aportes);
        request.setAttribute("acc", accidentes);
        request.setAttribute("ru", ruta);
        request.getRequestDispatcher("admin/Vista_Admin_Registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Chofer> chofer = new ArrayList<Chofer>();
        List<Control_aportes> aportes = new ArrayList<Control_aportes>();
        List<Control_accidentes> accidentes = new ArrayList<Control_accidentes>();
        List<Control_ruta> ruta = new ArrayList<Control_ruta>();
        try {
            chofer = daoCh.findAllUsuarios();
        } catch (Exception ex) {
            System.out.println("Error al buscar chofer" + ex);
        }
        try {
            aportes = daoAp.getAll();
        } catch (Exception ex1) {
            System.out.println("Error al buscar Aportes" + ex1);;
        }
        try {
            accidentes = daoAcc.getAll();
        } catch (Exception ex2) {
            System.out.println("Error al buscar Accidetnes" + ex2);
        }
        try {
            ruta = daoRu.getAll();
        } catch (Exception ex3) {
            System.out.println("Error al buscar Rutas" + ex3);
        }

        request.setAttribute("ch", chofer);
        request.setAttribute("ap", aportes);
        request.setAttribute("acc", accidentes);
        request.setAttribute("ru", ruta);
        request.getRequestDispatcher("admin/Vista_Admin_Registro.jsp").forward(request, response);
    }

}
