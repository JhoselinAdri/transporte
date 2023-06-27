package com.grupo.controlador.parada;

import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.dao.RutaDAO;
import com.grupo.dao.RutaDAOimp;
import com.grupo.dao.VehiculoDAO;
import com.grupo.dao.VehiculoDAOimpl;
import com.grupo.modelo.Chofer;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.Ruta;
import com.grupo.modelo.Vehiculo;
import com.grupo.modelo.vistas.VRChofer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NuevoController", urlPatterns = {"/NuevoController"})
public class NuevoController extends HttpServlet {

    RutaDAO dao = new RutaDAOimp();
    VehiculoDAO daov = new VehiculoDAOimpl();
    ChoferDAO daoc = new ChoferDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Entrada.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ci = Integer.parseInt(request.getParameter("ci"));
        int linea = Integer.parseInt(request.getParameter("linea"));

        VRChofer ruta = new VRChofer();
        Chofer ch = new Chofer();
        Chofer ch1 = new Chofer();
        ch.setCi(ci);
        try {
            ch1 = daoc.findUsuarioById(ch);
        } catch (Exception ex) {
            System.out.println("Error al traer datos" + ex);
        }
        System.out.println(ch1.getUsername());
        if (ch1.getUsername() != null) {
            try {
                ruta = dao.getById(ci, linea);
            } catch (Exception ex) {
                System.out.println("Error al llamar al dao" + ex);
            }
            if (ruta.getCi_chofer() == 0) {
                Ruta rut = new Ruta();
                rut.setCi_chofer(ci);
                rut.setLinea(linea);
                try {
                    dao.insert(rut);
                } catch (Exception ex) {
                    System.out.println("Error al insertar en el dao" + ex);
                }
                Mensaje men = new Mensaje();
                men.setMensaje("El chofer a sido registrado correctamente");
                
                request.setAttribute("mensaje", men);
                request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Entrada.jsp").forward(request, response);
            } else {
                Mensaje men = new Mensaje();
                men.setMensaje("El usuario ya se ha registrado en esta linea el dia de hoy");
                request.setAttribute("dato", ruta);
                request.setAttribute("mensaje", men);
                request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Entrada.jsp").forward(request, response);
            }
        }else{
            Mensaje men = new Mensaje();
                men.setMensaje("El CI no esta registrado");
                request.setAttribute("dato", ruta);
                request.setAttribute("mensaje", men);
                request.getRequestDispatcher("Usuario_Parada/Vista_Parada_Entrada.jsp").forward(request, response);
        }

    }

}
