package com.grupo.controlador;

import com.grupo.dao.RutaDAO;
import com.grupo.dao.RutaDAOimp;
import com.grupo.dao.VueltaDAO;
import com.grupo.dao.VueltaDAOimp;
import com.grupo.dao.vista.VDCVDAO;
import com.grupo.dao.vista.VDCVDAOimpl;
import com.grupo.modelo.Ruta;
import com.grupo.modelo.Vuelta;
import com.grupo.modelo.vistas.VistaDCV;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ParadaController", urlPatterns = {"/ParadaController"})
public class ParadaController extends HttpServlet {

    RutaDAO dao = new RutaDAOimp();
    VDCVDAO daoC = new VDCVDAOimpl();
    VueltaDAO daoV = new VueltaDAOimp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        VistaDCV usuario = new VistaDCV();
        usuario = (VistaDCV) session.getAttribute("usuario");
        int ci = usuario.getCi();
        System.out.println(ci+" ci");
        if (session.getAttribute("loged") != "Chofer") {
            response.sendRedirect("login_chofer.jsp");
        } else {
            
            List<Ruta> rutas = null;
            rutas = new ArrayList<Ruta>();
            try {
                rutas = dao.getAllCi(ci);
            } catch (Exception e) {
                System.out.println("Error al llamar al dao" + e);
            }

            request.setAttribute("ruta", rutas);
            request.getRequestDispatcher("UsuarioChofer/Vista_Parada.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
