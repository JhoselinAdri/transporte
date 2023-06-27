package com.grupo.controlador.parada;

import com.grupo.dao.RutaDAO;
import com.grupo.dao.RutaDAOimp;
import com.grupo.dao.VueltaDAO;
import com.grupo.dao.VueltaDAOimp;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.Ruta;
import com.grupo.modelo.Vuelta;
import com.grupo.modelo.vistas.VRChofer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroSalidaController", urlPatterns = {"/RegistroSalidaController"})
public class RegistroSalidaController extends HttpServlet {

    RutaDAO dao = new RutaDAOimp();
    VueltaDAO daov = new VueltaDAOimp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ci = Integer.parseInt(request.getParameter("ci"));
        int linea = Integer.parseInt(request.getParameter("linea"));
        RutaDAO dao = new RutaDAOimp();
        VRChofer ruta = new VRChofer();
        try {
            ruta = dao.getById(ci, linea);
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao" + ex);
        }
        if (ruta.getCi_chofer() == 0) {

            Mensaje men = new Mensaje();
            men.setMensaje("El usuario no inicio su hoja de ruta el dia de hoy  !!!Por favor registrelo en Entrada");
            request.setAttribute("mensaje", men);
            request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Salida.jsp").forward(request, response);
        } else {
            Vuelta vu = new Vuelta();
            try {
                vu = daov.getById(ci, linea);
            } catch (Exception e) {
                System.out.println("Error al llamar al dato0 +0" + e);
            }
            if (vu.getN_vueta() == 0) {
                Mensaje men = new Mensaje();
                men.setMensaje("El usuario no se Encuentra en espera para salir porfavor registrelo ");
                request.setAttribute("dato", ruta);
                request.setAttribute("mensaje", men);
                request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Salida.jsp").forward(request, response);
            } else {
                Mensaje men = new Mensaje();
                men.setMensaje(" Se encontro el usuario, esta listo para salir?");
                request.setAttribute("vuelta", vu);
                request.setAttribute("dato", ruta);
                request.setAttribute("mensaje", men);
                request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Salida.jsp").forward(request, response);
            }

        }

    }

}
