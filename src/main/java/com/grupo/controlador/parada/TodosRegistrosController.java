package com.grupo.controlador.parada;

import com.grupo.dao.RutaDAO;
import com.grupo.dao.RutaDAOimp;
import com.grupo.modelo.Ruta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TodosRegistrosController", urlPatterns = {"/TodosRegistrosController"})
public class TodosRegistrosController extends HttpServlet {

    RutaDAO dao = new RutaDAOimp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Ruta> rutas = null;
        rutas = new ArrayList<Ruta>();
        try {
            rutas = dao.getAll();
        } catch (Exception e) {
            System.out.println("Error al llamar al dao" + e);
        }
        request.setAttribute("ruta", rutas);
        request.getRequestDispatcher("Usuario_Parada/Parada_Registro_Entrada_Salida.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Ruta> rutas = null;
        rutas = new ArrayList<Ruta>();
        try {
            rutas = dao.getAll();
        } catch (Exception e) {
            System.out.println("Error al llamar al dao" + e);
        }
        request.setAttribute("ruta", rutas);
        request.getRequestDispatcher("Usuario_Parada/Parada_Registro_Entrada_Salida.jsp").forward(request, response);

    }

}
