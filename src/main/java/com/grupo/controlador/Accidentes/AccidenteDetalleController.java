package com.grupo.controlador.Accidentes;

import com.grupo.dao.AccidentesDAO;
import com.grupo.dao.AccidentesDAOimpl;
import com.grupo.dao.DetalleAccidenteDAO;
import com.grupo.dao.DetalleAccidenteDAOimpl;
import com.grupo.modelo.Accidentes;
import com.grupo.modelo.Control_accidentes;
import com.grupo.modelo.Detalle_accidente;
import com.grupo.modelo.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AccidenteDetalleController", urlPatterns = {"/AccidenteDetalleController"})
public class AccidenteDetalleController extends HttpServlet {

    DetalleAccidenteDAO dao = new DetalleAccidenteDAOimpl();
    AccidentesDAO dao1 = new AccidentesDAOimpl();
    int id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ac= Integer.parseInt(request.getParameter("action"));
        id = Integer.parseInt(request.getParameter("id"));
        Detalle_accidente det= new Detalle_accidente();
        List<Detalle_accidente> lista= new ArrayList<Detalle_accidente>();
        det.setN_acc(id);
        if(ac==1){
            try {
                System.out.println("mostrar");
                lista= dao.getdetalleRegistro(det);
                request.setAttribute("tabla", lista);
            } catch (Exception ex) {
                System.out.println("Error al llamar al dao "+ex);
            }
        }else{
            int n = Integer.parseInt(request.getParameter("n"));
            try {
                det = dao.getById(n);
                System.out.println(det.getDetalle());
                request.setAttribute("datos", det);
            } catch (Exception ex) {
                System.out.println("Error en el detalle del detalle" +ex);
            }
            try {
                lista= dao.getdetalleRegistro(det);
                request.setAttribute("tabla", lista);
            } catch (Exception ex) {
                System.out.println("Error al llamar al dao "+ex);
            }
            
            System.out.println("nada");
        }
        request.getRequestDispatcher("Accidentes/Accidentes_Vista_Det_lista.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numero = request.getParameter("numero");
        System.out.println(id);
        if(numero == null || numero.isEmpty()){
            Control_accidentes usuario = new Control_accidentes();
            String detalle = request.getParameter("detalle");
            double costo=Double.parseDouble(request.getParameter("costo"));
            HttpSession session = request.getSession();
            usuario = (Control_accidentes) session.getAttribute("usuario");
            int ci=usuario.getCi();
            Detalle_accidente det = new Detalle_accidente();
            det.setCi(ci);
            det.setCosto(costo);
            det.setDetalle(detalle);
            det.setN_acc(id);
            try {
                dao.insert(det);
            } catch (Exception ex) {
                System.out.println("Error al inseertar datos "+ex);
            }
            System.out.println("Trabajo");
            
        }else{
            Control_accidentes usuario = new Control_accidentes();
            int n =Integer.parseInt(request.getParameter("numero"));
            String detalle = request.getParameter("detalle");
            double costo=Double.parseDouble(request.getParameter("costo"));
            HttpSession session = request.getSession();
            usuario = (Control_accidentes) session.getAttribute("usuario");
            int ci=usuario.getCi();
            Detalle_accidente det = new Detalle_accidente();
            det.setCi(ci);
            det.setCosto(costo);
            det.setDetalle(detalle);
            det.setN_acc(id);
            det.setN(n);
            try {
                dao.update(det);
            } catch (Exception ex) {
                System.out.println("Error al inseertar datos "+ex);
            }
            System.out.println("No trabajo");
            
        }
        List<Accidentes> lista = null;
        try {
            lista = dao1.getAll();
        } catch (Exception ex) {
            System.out.println("Error al llamar al dao" +ex);
        }
        Mensaje men = new Mensaje();
        men.setMensaje("Se actualizo con exito");
        request.setAttribute("men", men);
        request.setAttribute("acc", lista);
        request.getRequestDispatcher("Accidentes/Accidentes_Vista_Lista_Notificaciones.jsp").forward(request, response);
    }

}
