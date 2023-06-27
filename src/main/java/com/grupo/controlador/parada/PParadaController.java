package com.grupo.controlador.parada;

import com.grupo.dao.VueltaDAO;
import com.grupo.dao.VueltaDAOimp;
import com.grupo.modelo.Control_ruta;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.Vuelta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PParadaController", urlPatterns = {"/PParadaController"})
public class PParadaController extends HttpServlet {

    VueltaDAO dao = new VueltaDAOimp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Salida.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("formulario");
        Mensaje men = new Mensaje();
        if (accion.equals("buscar")) {
            int ci = Integer.parseInt(request.getParameter("ci"));
            System.out.println("LLenar");

        } else if (accion.equals("llenar")) {

            String Observa = request.getParameter("observacion");
            String nom = request.getParameter("nom");
            if (!nom.equals("")) {
                int r = Integer.parseInt(request.getParameter("n_vuelta"));
                HttpSession session = request.getSession();
                Control_ruta usuario = new Control_ruta();
                usuario = (Control_ruta) session.getAttribute("usuario");
                int cr = usuario.getCi();
                Vuelta vuelta = new Vuelta();
                vuelta.setN_vueta(r);
                vuelta.setObservaciones(Observa);
                vuelta.setCi_control(cr);
                System.out.println(vuelta.getN_vueta());
                try {
                    dao.update(vuelta);
                    System.out.println("Registro Exitoso");
                } catch (Exception ex) {
                    System.out.println("Error al llamar al dao" + ex);
                }
                request.getRequestDispatcher("TodosRegistrosController").forward(request, response);
            } else {
                men.setMensaje("Por favor busque al chofer por el CI");
                request.setAttribute("mensaje", men);
                request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Salida.jsp").forward(request, response);
            }

        }
    }

}
