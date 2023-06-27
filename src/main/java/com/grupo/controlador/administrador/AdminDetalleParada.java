
package com.grupo.controlador.administrador;

import com.grupo.dao.ControlAportesDAO;
import com.grupo.dao.ControlAportesDAOimpl;
import com.grupo.dao.ControlRutaDAO;
import com.grupo.dao.ControlRutaDAOimpl;
import com.grupo.dao.vista.VACDAOimpl;
import com.grupo.dao.vista.VCADAO;
import com.grupo.modelo.Control_aportes;
import com.grupo.modelo.Control_ruta;
import com.grupo.modelo.Mensaje;
import com.grupo.modelo.vistas.VistaAC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminDetalleParada", urlPatterns = {"/AdminDetalleParada"})
public class AdminDetalleParada extends HttpServlet {

    ControlRutaDAO dao=new ControlRutaDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        Control_ruta ch= new Control_ruta();
        switch (action) {
            case "edit":
                int ci =  Integer.parseInt(request.getParameter("ci"));

                Control_ruta datos= new Control_ruta();
            {
                try {
                    datos =dao.getById(ci);
                } catch (Exception ex) {
                    System.out.println("Error al traer los datos "+ex);
                }
                System.out.println(datos.getCi());
                Mensaje men = new Mensaje();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("admin/Vista_Editar_Parada.jsp").forward(request, response);
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
