package com.grupo.controlador.administrador;

import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.modelo.Chofer;
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


@WebServlet(name = "AdminEditUsuario", urlPatterns = {"/AdminEditUsuario"})
public class AdminEditUsuario extends HttpServlet {


    ChoferDAO dao = new ChoferDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("admin/Vista_Editar_Usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int lic = Integer.parseInt(request.getParameter("licencia"));
        String cat = request.getParameter("categoria");
        String fechaStr = request.getParameter("fecha");

        Date fecha = null;
        SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("yyyy-MM-dd");

        try {
            fecha = formatoFecha.parse(fechaStr);
        } catch (java.text.ParseException e) {
            System.out.println("Error con la fecha" + e);
        }

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
        Chofer ch = new Chofer();
        Licencia lice = new Licencia();
        Vehiculo ve = new Vehiculo();
        ch.setApm(apm);
        ch.setApp(app);
        ch.setCi(ci);
        ch.setN_celular(numero);
        ch.setNombre(nombre);

        lice.setCategoria(cat);
        lice.setFecha_exp(fecha);
        lice.setId_licencia(lic);
        
        ve.setCapacidad(Integer.parseInt(request.getParameter("capacidad")));
        ve.setEstado(request.getParameter("estado"));
        ve.setMarca(request.getParameter("marca"));
        ve.setModelo(request.getParameter("modelo"));
        ve.setPlaca(request.getParameter("placa"));
        ve.setTipo(request.getParameter("tipo"));
        try {
            dao.updateUsuario(ch, lice, ve);
            System.out.println("Se actializo con exito");
        } catch (Exception ex) {
            System.out.println("Error en el dao actualizar chofer" + ex);
        }
        request.getRequestDispatcher("admin/Vista_Admin_Inicio.jsp").forward(request, response);

    
    }

}
