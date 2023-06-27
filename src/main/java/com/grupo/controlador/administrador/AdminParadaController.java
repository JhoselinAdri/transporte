package com.grupo.controlador.administrador;

import com.grupo.dao.vista.VCVDAO;
import com.grupo.dao.vista.VCVDAOimp;
import com.grupo.modelo.vistas.VCV;
import com.grupo.modelo.vistas.VueltasContar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminParadaController", urlPatterns = {"/AdminParadaController"})
public class AdminParadaController extends HttpServlet {

    VCVDAO dao = new VCVDAOimp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<VCV> registros = new ArrayList<VCV>();
        try {
            registros = dao.ViewAll();

        } catch (Exception ex) {
            System.out.println("Error al llamar al dao rutas" + ex);
        }
        List<VueltasContar> v = new ArrayList<VueltasContar>();
        try {
            v = dao.ViewGrafico();
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao" + ex);
        }

        int[] vectorNumerico = new int[10];
        Arrays.fill(vectorNumerico, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < v.size(); j++) {
                VueltasContar g = v.get(j);
                int datoNumerico = 0;
                if (g.getN() == i + 1) {
                    datoNumerico = g.getCuanto();
                    sb.append(datoNumerico);
                }

                vectorNumerico[i] = datoNumerico;
                
            }
            if (i < 10 - 1) {
                    sb.append(", ");
                }

        }
        String cadenaSeparadaPorComas = sb.toString();
        request.setAttribute("cadenaSeparadaPorComas", cadenaSeparadaPorComas);
        request.setAttribute("registro", registros);
        request.getRequestDispatcher("admin/Vista_Admin_Parada.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ci = Integer.parseInt(request.getParameter("ci"));
        List<VCV> registros = new ArrayList<VCV>();
        try {
            registros = dao.ViewChoferAll(ci);
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao rutas" + ex);
        }
        List<VueltasContar> v = new ArrayList<VueltasContar>();
        try {
            v = dao.ViewChofer(ci);
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao" + ex);
        }

        int[] vectorNumerico = new int[10];
        Arrays.fill(vectorNumerico, 0);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int datoNumerico = 0; // Mover la declaración fuera del bucle interno

            for (int j = 0; j < v.size(); j++) {
                VueltasContar g = v.get(j);

                if (g.getN() == i + 1) {
                    datoNumerico = g.getCuanto();
                    sb.append(datoNumerico);

                } 

                vectorNumerico[i] = datoNumerico;


            }
            if (i < 10 - 1) {
                sb.append(", ");
            }
        }

        String cadenaSeparadaPorComas = sb.toString();
        System.out.println(cadenaSeparadaPorComas);
        request.setAttribute("cadenaSeparadaPorComas", cadenaSeparadaPorComas);
        request.setAttribute("registro", registros);
        request.getRequestDispatcher("admin/Vista_Admin_Parada.jsp").forward(request, response);
    }

}
