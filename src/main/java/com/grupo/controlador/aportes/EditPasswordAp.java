package com.grupo.controlador.aportes;



import com.grupo.dao.ControlAportesDAO;
import com.grupo.dao.ControlAportesDAOimpl;
import com.grupo.modelo.Control_accidentes;
import com.grupo.modelo.Control_aportes;
import com.grupo.modelo.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditPasswordAp", urlPatterns = {"/EditPasswordAp"})
public class EditPasswordAp extends HttpServlet {

    ControlAportesDAO dao = new ControlAportesDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Control_aportes datos = new Control_aportes();
        int ci = Integer.parseInt(request.getParameter("ci"));
        Control_aportes c = new Control_aportes();
        c.setCi(ci);
        try {
            datos = dao.getById(ci);
        } catch (Exception ex) {
            System.out.println("Error al llamar los datos del aprtes" + ex);
        }
        request.setAttribute("datos", datos);
        request.getRequestDispatcher("Usuario_Aportes/Vista_AportesEdit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ci = Integer.parseInt(request.getParameter("ci"));
        String pass = request.getParameter("pass");
        String npass = request.getParameter("npass");
        String rpass = request.getParameter("rpass");
        Control_aportes datos = new Control_aportes();
        Control_aportes da = new Control_aportes();
        Control_aportes password = new Control_aportes();
        datos.setCi(ci);
        datos.setPassword(pass);
        System.out.println(datos.getCi());
        try {
            da = dao.getById(ci);
        } catch (Exception e) {
            System.out.println("Error al traer los datos" + e);
        }
        System.out.println(da.getUsername());
        if (da.getUsername() != null) {
            try {
                password = dao.veripass(datos);
            } catch (Exception ex1) {
                System.out.println("Error al llamar" + ex1);
            }
            if (password.getUsername() != null) {
                if (npass.equals(rpass)) {
                    try {
                        Control_aportes pas = new Control_aportes();
                        pas.setPassword(npass);
                        pas.setCi(ci);
                        dao.updatePass(pas);
                        Mensaje men = new Mensaje();
                        men.setMensaje("La contraseña se actualizo con exito");
                        request.setAttribute("men", men);
                        request.getRequestDispatcher("Usuario_Aportes/Vista_AportesEdit.jsp").forward(request, response);
                    } catch (Exception ex) {
                        System.out.println("Error al actualizar dap" + ex);
                    }
                } else {
                    Mensaje men = new Mensaje();
                    men.setMensaje("Las contraseñas nuevas no son iguales ");
                    request.setAttribute("men", men);
                    request.getRequestDispatcher("Usuario_Aportes/Vista_AportesEdit.jsp").forward(request, response);
                }
            } else {
                Mensaje men = new Mensaje();
                men.setMensaje("Tu contraseña es incorrecta vuelva a intentar ");
                request.setAttribute("men", men);
                request.getRequestDispatcher("Usuario_Aportes/Vista_AportesEdit.jsp").forward(request, response);
            }
        } else {
            Mensaje men = new Mensaje();
            men.setMensaje("Algo fallo ");
            request.setAttribute("men", men);
            request.getRequestDispatcher("Usuario_Aportes/Vista_AportesEdit.jsp").forward(request, response);

        }
        System.out.println("Tddo correcto");

    }

}
