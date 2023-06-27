package com.grupo.controlador.administrador;

import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.dao.ControlAccidentesDAO;
import com.grupo.dao.ControlAccidentesDAOimpl;
import com.grupo.dao.ControlAportesDAO;
import com.grupo.dao.ControlAportesDAOimpl;
import com.grupo.dao.ControlRutaDAO;
import com.grupo.dao.ControlRutaDAOimpl;
import com.grupo.modelo.Chofer;
import com.grupo.modelo.Control_accidentes;
import com.grupo.modelo.Control_aportes;
import com.grupo.modelo.Control_ruta;
import com.grupo.modelo.Licencia;
import com.grupo.modelo.Vehiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminEditParada", urlPatterns = {"/AdminEditParada"})
public class AdminEditParada extends HttpServlet {


    ControlRutaDAO dao = new ControlRutaDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("admin/Vista_Editar_Parada.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String app = request.getParameter("app");
        String apm = request.getParameter("apm");
        int ci = Integer.parseInt(request.getParameter("ci"));
        String numero = request.getParameter("celular");
        String[] nombres = nombre.split(" ");
        String primerNombre = nombres[0];
        System.out.println(primerNombre);
        String usuario=primerNombre+"_"+ci;
        String user=usuario;
        String pass =request.getParameter("ci");
        System.out.println(pass);
        Control_ruta ctl = new Control_ruta();

        ctl.setApm(apm);
        ctl.setApp(app);
        ctl.setCi(ci);
        ctl.setTelefono(numero);
        ctl.setNombre(nombre);
        try {
            dao.update(ctl);
            System.out.println("Se actializo con exito ruta");
        } catch (Exception ex) {
            System.out.println("Error en el dao actualizar Accidetne" + ex);
        }
        request.getRequestDispatcher("admin/Vista_Admin_Inicio.jsp").forward(request, response);

    
    }

}
