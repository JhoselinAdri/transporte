
package com.grupo.controlador.administrador;

import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.dao.ControlAccidentesDAO;
import com.grupo.dao.ControlAccidentesDAOimpl;
import com.grupo.dao.vista.VDCVDAO;
import com.grupo.dao.vista.VDCVDAOimpl;
import com.grupo.modelo.Chofer;
import com.grupo.modelo.Control_accidentes;
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

@WebServlet(name = "AdminDetalleAccidente", urlPatterns = {"/AdminDetalleAccidente"})
public class AdminDetalleAccidente extends HttpServlet {


    ControlAccidentesDAO dao= new ControlAccidentesDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        Control_accidentes ch= new Control_accidentes();
        switch (action) {
            case "edit":
                int ci =  Integer.parseInt(request.getParameter("ci"));

                Control_accidentes datos= new Control_accidentes();
            {
                try {
                    datos =dao.getById(ci);
                } catch (Exception ex) {
                    System.out.println("Error al traer los datos "+ex);
                }
                System.out.println(datos.getCi());
                Mensaje men = new Mensaje();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("admin/Vista_Editar_Accidente.jsp").forward(request, response);
            }
                break;
            case "delete":
                ch.setCi(Integer.parseInt(request.getParameter("ci")));
                System.out.println("Eliminar");
            {
                try {
                    dao.updatedelete(ch);
                    request.getRequestDispatcher("AdminRegistroController").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Error al actualizar"+ex);
                }
            }
                break;

            case "habil":  
                ch.setCi(Integer.parseInt(request.getParameter("ci")));
            {
                try {
                    
                    dao.updatehabil(ch);
                    request.getRequestDispatcher("AdminRegistroController").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Error al habilitar"+ex);
                }
            }
                System.out.println("habilitar");
                break;

            
            default:
                throw new AssertionError();
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
