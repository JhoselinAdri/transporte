package com.grupo.controlador;

import com.grupo.dao.AccidentesDAO;
import com.grupo.dao.AccidentesDAOimpl;
import com.grupo.dao.VehiculoDAO;
import com.grupo.dao.VehiculoDAOimpl;
import com.grupo.dao.vista.VDCVDAO;
import com.grupo.dao.vista.VDCVDAOimpl;
import com.grupo.modelo.Accidentes;
import com.grupo.modelo.Detalle_accidente;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.vistas.VistaDCV;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AccidenteController", urlPatterns = {"/AccidenteController"})
public class AccidenteController extends HttpServlet {

    AccidentesDAO dao = new AccidentesDAOimpl();
    VDCVDAO daov = new VDCVDAOimpl();
    VehiculoDAO daove = new VehiculoDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        VistaDCV usuario = new VistaDCV();
        if (session.getAttribute("loged") != "Chofer") {
            response.sendRedirect("login_chofer.jsp");
        } else {

            request.getRequestDispatcher("UsuarioChofer/Vista_Accidentes.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mensaje men = new Mensaje();
        String[] conceptosSeleccionados = request.getParameterValues("concepto");
        String placa = request.getParameter("placa");
        System.out.println(placa);
        VistaDCV datos = new VistaDCV();
        datos.setPlaca(request.getParameter("placa"));
        System.out.println(datos.getPlaca());
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
            System.out.println(placa1);
            String detalle = request.getParameter("detalle");
            String ubicacion = request.getParameter("ubicacion");
            System.out.println(ubicacion);

            VistaDCV usuario = new VistaDCV();
            HttpSession session = request.getSession();
            usuario = (VistaDCV) session.getAttribute("usuario");

            String conceptosTexto = String.join(", ", conceptosSeleccionados);
            Accidentes accidente = new Accidentes();
            Detalle_accidente det = new Detalle_accidente();
            accidente.setPlaca(placa1);
            accidente.setCi(c1);
            accidente.setDireccion(ubicacion);
            accidente.setObservaciones(conceptosTexto);
            det.setDetalle(detalle);
            accidente.setCi_reg(ci_reg);
            System.out.println(accidente.getCi_reg());
            try {
                dao.insert(accidente, det);
                System.out.println("Se registro el mensaje");
                men.setMensaje("Se registro el Accidentes");
                request.setAttribute("men", men);
                request.getRequestDispatcher("DetalleAccideteController").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Error al insertar desde el controlador: " + ex.getMessage());
            }
        } else {
            men.setMensaje("No existe la placa en la base de datos");
            request.setAttribute("men", men);
            request.getRequestDispatcher("UsuarioChofer/Vista_Accidentes.jsp").forward(request, response);
        }

    }
}
