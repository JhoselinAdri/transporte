package com.grupo.controlador.Accidentes;

import com.grupo.dao.AccidentesDAO;
import com.grupo.dao.AccidentesDAOimpl;
import com.grupo.dao.vista.VDCVDAO;
import com.grupo.dao.vista.VDCVDAOimpl;
import com.grupo.modelo.Accidentes;
import com.grupo.modelo.Control_accidentes;
import com.grupo.modelo.Detalle_accidente;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.vistas.VistaDCV;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AccidenteRegistroController", urlPatterns = {"/AccidenteRegistroController"})
public class AccidenteRegistroController extends HttpServlet {

    AccidentesDAO dao = new AccidentesDAOimpl();
    VDCVDAO daov = new VDCVDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("Accidentes/Accidentes_Vista_Mens_Alerta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mensaje men = new Mensaje();
        String[] conceptosSeleccionados = request.getParameterValues("concepto");
        String placa = request.getParameter("placa");
        VistaDCV datos = new VistaDCV();
        System.out.println(placa);
        datos.setPlaca(request.getParameter("placa"));

        VistaDCV chofer = new VistaDCV();
        try {
            chofer = daov.idPlaca(datos);
        } catch (Exception ex) {
            System.out.println("Error al buscar la placa" + ex);
        }

        if (chofer.getUsername() != null) {
            String placa1 = chofer.getPlaca();
            int c1 = chofer.getCi();
            System.out.println(c1 + " " + placa1);
            int ci_reg = Integer.parseInt(request.getParameter("ci_registro"));
            String detalle = request.getParameter("detalle");
            String ubicacion = request.getParameter("ubicacion");

            Control_accidentes usuario = new Control_accidentes();
            HttpSession session = request.getSession();
            usuario = (Control_accidentes) session.getAttribute("usuario");

            String conceptosTexto = String.join(", ", conceptosSeleccionados);
            Accidentes accidente = new Accidentes();
            Detalle_accidente det = new Detalle_accidente();
            accidente.setPlaca(placa1);
            accidente.setCi(c1);
            accidente.setDireccion(ubicacion);
            accidente.setObservaciones(conceptosTexto);
            det.setDetalle(detalle);
            accidente.setCi_reg(ci_reg);
            try {
                dao.insertcontrol(accidente, det);
                request.getRequestDispatcher("AccidenteListaController").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Error al insertar desde el controlador: " + ex.getMessage());
            }
        }else{
            men.setMensaje("No existe la placa en la base de datos");
            request.setAttribute("men", men);
            request.getRequestDispatcher("Accidentes/Accidentes_Vista_Mens_Alerta.jsp").forward(request, response);
        }

    }

}
