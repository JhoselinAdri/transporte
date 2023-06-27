
package com.grupo.controlador.administrador;

import com.grupo.dao.AportesDAO;
import com.grupo.dao.AportesDAOimpl;
import com.grupo.dao.vista.VACDAOimpl;
import com.grupo.dao.vista.VCADAO;
import com.grupo.modelo.Aportes;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.vistas.VistaAC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminDetalleEditarController", urlPatterns = {"/AdminEditarAporteController"})
public class AdminEditarAporteController extends HttpServlet {


    VCADAO dao=new VACDAOimpl();
    AportesDAO daoa =new AportesDAOimpl(); 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int n= Integer.parseInt(request.getParameter("id"));
        VistaAC aporte=new VistaAC();
        try {
            aporte=dao.getById(n);
            
        } catch (Exception ex) {
            System.out.println("Eror desde el dao "+ex);
        }
        System.out.println(aporte.getNombre_aporte());
        request.setAttribute("aportes", aporte);
        request.getRequestDispatcher("admin/AdminEditAporte.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mensaje men= new Mensaje();
        int n= Integer.parseInt(request.getParameter("id"));
        double monto=Double.parseDouble(request.getParameter("monto"));
        Aportes ap= new Aportes();
        ap.setN(n);
        ap.setMonto(monto);
        VistaAC aporte=new VistaAC();
        try {
            daoa.update(ap);
            men.setMensaje("Actualizado el monto con exito");
        } catch (Exception ex) {
            men.setMensaje("Error al actualizar");
            System.out.println("Eror desde el actualizar "+ex);
            
        }
        try {
            
            aporte=dao.getById(n);
            
        } catch (Exception ex) {
            men.setMensaje("Error al buscar");
            System.out.println("Eror desde el dao "+ex);
        }
        
        System.out.println(aporte.getNombre_aporte());
        request.setAttribute("men", men);
        request.setAttribute("aportes", aporte);
        request.getRequestDispatcher("admin/AdminEditAporte.jsp").forward(request, response);
    }


}
