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

@WebServlet(name = "AdminEditAporte", urlPatterns = {"/AdminEditAporte"})
public class AdminEditAporte extends HttpServlet {

    VCADAO dao=new VACDAOimpl();
    AportesDAO daoa=new AportesDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        VistaAC aporte=new VistaAC();
        try {
            aporte=dao.getById(id);
        } catch (Exception ex) {
            System.out.println("Eror desde el dao "+ex);
        }
        request.setAttribute("aportes", aporte);
        request.getRequestDispatcher("admin/Vista_Editar_Aportes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double monto= Double.parseDouble(request.getParameter("monto"));
        Aportes ap=new Aportes();
        Mensaje men = new Mensaje();
        int n=Integer.parseInt(request.getParameter("n"));
        ap.setN(n);
        ap.setMonto(monto);
        String mensaje="";
        try {
                daoa.update(ap);
                mensaje="Actualizacion de aporte realizado con exito";
         
            } catch (Exception ex) {
                System.out.println("Error al insertar Aportes al dao"+ex);
                mensaje="Error al actualizar";
            }
        men.setMensaje(mensaje);
        request.setAttribute("men",men );
        request.getRequestDispatcher("admin/Vista_Admin_Inicio.jsp").forward(request, response);

    }

}
