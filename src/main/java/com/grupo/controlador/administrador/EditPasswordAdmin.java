package com.grupo.controlador.administrador;
import com.grupo.dao.AdminDAO;
import com.grupo.dao.AdminDAOimpl;
import com.grupo.modelo.Admin;
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

@WebServlet(name = "EditPasswordAdmin", urlPatterns = {"/EditPasswordAdmin"})
public class EditPasswordAdmin extends HttpServlet {

    AdminDAO dao = new AdminDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Admin datos = new Admin();
        int ci = Integer.parseInt(request.getParameter("ci"));
        Admin c = new Admin();
        c.setCi(ci);
        try {
            datos = dao.getById(ci);
        } catch (Exception ex) {
            System.out.println("Error al llamar los datos del aprtes" + ex);
        }
        request.setAttribute("datos", datos);
        request.getRequestDispatcher("admin/Vista_Admin_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ci = Integer.parseInt(request.getParameter("ci"));
        String pass = request.getParameter("pass");
        String npass = request.getParameter("npass");
        String rpass = request.getParameter("rpass");
        Admin datos = new Admin();
        Admin da = new Admin();
        Admin password = new Admin();
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
                        Admin pas = new Admin();
                        pas.setPassword(npass);
                        pas.setCi(ci);
                        dao.updatePass(pas);
                        Mensaje men = new Mensaje();
                        men.setMensaje("La contraseña se actualizo con exito");
                        request.setAttribute("men", men);
                        request.getRequestDispatcher("admin/Vista_Admin_edit.jsp").forward(request, response);
                    } catch (Exception ex) {
                        System.out.println("Error al actualizar dap" + ex);
                    }
                } else {
                    Mensaje men = new Mensaje();
                    men.setMensaje("Las contraseñas nuevas no son iguales ");
                    request.setAttribute("men", men);
                    request.getRequestDispatcher("admin/Vista_Admin_edit.jsp").forward(request, response);
                }
            } else {
                Mensaje men = new Mensaje();
                men.setMensaje("Tu contraseña es incorrecta vuelva a intentar ");
                request.setAttribute("men", men);
                request.getRequestDispatcher("admin/Vista_Admin_edit.jsp").forward(request, response);
            }
        } else {
            Mensaje men = new Mensaje();
            men.setMensaje("Algo fallo ");
            request.setAttribute("men", men);
            request.getRequestDispatcher("admin/Vista_Admin_edit.jsp").forward(request, response);

        }
        System.out.println("Tddo correcto");

    }

}
