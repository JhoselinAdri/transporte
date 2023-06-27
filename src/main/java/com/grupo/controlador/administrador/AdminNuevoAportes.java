package com.grupo.controlador.administrador;

import com.grupo.dao.ControlAportesDAO;
import com.grupo.dao.ControlAportesDAOimpl;
import com.grupo.modelo.Control_aportes;
import com.grupo.modelo.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminNuevoAportes", urlPatterns = {"/AdminNuevoAportes"})
public class AdminNuevoAportes extends HttpServlet {

    ControlAportesDAO dao = new ControlAportesDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admin/Vista_Nuevo_Aporte.jsp").forward(request, response);
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

        Control_aportes ca = new Control_aportes();

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
