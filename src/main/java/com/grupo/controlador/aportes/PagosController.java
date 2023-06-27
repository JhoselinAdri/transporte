package com.grupo.controlador.aportes;

import com.grupo.dao.AportesDAO;
import com.grupo.dao.AportesDAOimpl;
import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.dao.vista.VDCVDAO;
import com.grupo.dao.vista.VDCVDAOimpl;
import com.grupo.modelo.Aportes;
import com.grupo.modelo.Chofer;
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

@WebServlet(name = "PagosController", urlPatterns = {"/PagosController"})
public class PagosController extends HttpServlet {

    VDCVDAO daoch = new VDCVDAOimpl();
    AportesDAO daoa = new AportesDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VistaDCV chofer = new VistaDCV();
        request.setAttribute("datos", chofer);
        request.getRequestDispatcher("Usuario_Aportes/Vista_Aportes_Pagos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("formulario");
        VistaDCV ch = new VistaDCV();
        Mensaje men = new Mensaje();
        if (accion.equals("buscar")) {
            int ci = Integer.parseInt(request.getParameter("ci"));
            VistaDCV dato = new VistaDCV();
            dato.setCi(ci);
            try {
                ch = daoch.idChofer(dato);
            } catch (Exception ex) {
                System.out.println("Error al buscar desde e ¿l dao" + ex);
            }
            if (ch.getNombre() != null) {
                request.setAttribute("datos", ch);
                System.out.println(ch.getNombre());
                men.setMensaje("El Conductor fue encontrado ¿Esta listo para completar el aporte?");
                request.setAttribute("men", men);
                request.getRequestDispatcher("Usuario_Aportes/Vista_Aportes_Pagos.jsp").forward(request, response);
            } else {
                men.setMensaje("El CI no esta registrado");
                VistaDCV chofer = new VistaDCV();
                request.setAttribute("datos", chofer);
                request.setAttribute("men", men);
                request.getRequestDispatcher("Usuario_Aportes/Vista_Aportes_Pagos.jsp").forward(request, response);
            }

        } else if (accion.equals("registrar")) {
            Aportes ap = new Aportes();
            int ci_chofer = Integer.parseInt(request.getParameter("ci"));
            int ci_aporte = Integer.parseInt(request.getParameter("ci_aporte"));
            String concepto = request.getParameter("concepto");
            String grupo = request.getParameter("grupo");
            Double monto = Double.parseDouble(request.getParameter("monto"));
            String placa = request.getParameter("placa");
            String sector = request.getParameter("sector");
            ap.setCi_aportes(ci_aporte);
            ap.setCi_chofer(ci_chofer);
            ap.setConcepto(concepto);
            ap.setGrupo(grupo);
            ap.setMonto(monto);
            ap.setPlaca_vehiculo(placa);
            ap.setSector(sector);
            try {
                daoa.insert(ap);
            } catch (Exception ex) {
                System.out.println("Error al insertar Aportes al dao" + ex);
            }
            request.getRequestDispatcher("RegistrosController").forward(request, response);

        }
    }
}
