
package com.grupo.controlador.administrador;

import com.grupo.dao.ChoferDAO;
import com.grupo.dao.ChoferDAOimpl;
import com.grupo.dao.vista.VDCVDAO;
import com.grupo.dao.vista.VDCVDAOimpl;
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

@WebServlet(name = "AdminDetalleUsuario", urlPatterns = {"/AdminDetalleUsuario"})
public class AdminDetalleUsuario extends HttpServlet {


    VDCVDAO dao= new VDCVDAOimpl();
    ChoferDAO daoch= new ChoferDAOimpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Chofer ch = new Chofer();
        String action=request.getParameter("action");
        switch (action) {
            case "edit":
                int ci =  Integer.parseInt(request.getParameter("ci"));
                VistaDCV chofer= new VistaDCV();
                chofer.setCi(ci);
                System.out.println(chofer.getCi());
                VistaDCV datos= new VistaDCV();
            {
                try {
                    datos =dao.idChofer(chofer);
                } catch (Exception ex) {
                    System.out.println("Error al traer los datos "+ex);
                }
                System.out.println(datos.getCi());
                Mensaje men = new Mensaje();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("admin/Vista_Editar_Usuario.jsp").forward(request, response);
            }
                break;

            case "delete":
                ch.setCi(Integer.parseInt(request.getParameter("ci")));
                System.out.println("Eliminar");
            {
                try {
                    daoch.updatedelete(ch);
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
                    
                    daoch.updatehabil(ch);
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
