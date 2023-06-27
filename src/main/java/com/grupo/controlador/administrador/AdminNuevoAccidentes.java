package com.grupo.controlador.administrador;

import com.grupo.dao.ControlAccidentesDAO;
import com.grupo.dao.ControlAccidentesDAOimpl;
import com.grupo.modelo.Control_accidentes;
import com.grupo.modelo.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminNuevoAccidentes", urlPatterns = {"/AdminNuevoAccidentes"})
public class AdminNuevoAccidentes extends HttpServlet {

    ControlAccidentesDAO dao = new ControlAccidentesDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admin/Vista_Nuevo_Accidentes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String app = request.getParameter("app");
        String apm = request.getParameter("apm");
        int ci = Integer.parseInt(request.getParameter("ci"));
        String numero = request.getParameter("celular");
        String direccion = request.getParameter("direccion");
        String[] nombres = nombre.split(" ");
        String primerNombre = nombres[0];
        String usuario = primerNombre + "_" + ci;
        String user = usuario;
        String pass = request.getParameter("ci");

        Control_accidentes ca = new Control_accidentes();

        ca.setApm(apm);
        ca.setApp(app);
        ca.setCi(ci);
        ca.setDireccion(direccion);
        ca.setNombre(nombre);
        ca.setPassword(pass);
        ca.setTelefono(numero);
        ca.setUsername(user);
        Mensaje men = new Mensaje();
        try {

            
            dao.insert(ca);
            men.setMensaje("Se registro el usuario ");
        } catch (Exception ex) {
            System.out.println("Error al insertar al dao" + ex);
        }
        request.getRequestDispatcher("AdminRegistroController").forward(request, response);
    }

}
