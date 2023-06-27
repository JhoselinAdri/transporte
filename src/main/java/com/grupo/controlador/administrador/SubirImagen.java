package com.grupo.controlador.administrador;

import com.grupo.dao.AvisosDAO;
import com.grupo.dao.AvisosDAOimpl;
import com.grupo.modelo.Admin;
import com.grupo.modelo.Avisos;
import com.grupo.modelo.Mensaje;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "SubirImagen", urlPatterns = {"/SubirImagen"})
public class SubirImagen extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AvisosDAO dao = new AvisosDAOimpl();
    private String ruta = "C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\transporte\\src\\main\\webapp\\comunicados\\";
    private File subir = new File(ruta);
    private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                saveCustomer(request, response);

                break;
            default:
                break;
        }

    }

    private void saveCustomer(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Admin usuario = (Admin) session.getAttribute("usuario");
            if (usuario == null) {
                res.sendRedirect("LoginAdmin.jsp");
                return;
            }
            req.setCharacterEncoding("UTF-8");
            Part archivo = req.getPart("comunicado");
            String nombre = archivo.getSubmittedFileName();
            InputStream datos = archivo.getInputStream();
            int tipo = Integer.parseInt(req.getParameter("tipo"));
            String desc = req.getParameter("detalle");
            System.out.println(desc);
            int ci = usuario.getCi();
            String destino = req.getParameter("rol");
            if (archivo == null) {
                System.out.println("No se seleciono un archivo");
                return;
            }
            if (is(archivo.getSubmittedFileName(), extens)) {
                String image = saveFile(archivo, subir);
                Avisos av = new Avisos();
                av.setCi_emisor(ci);
                av.setDato(image);
                System.out.println(av.getDato());
                av.setDescripcion(desc);
                System.out.println(av.getDescripcion());
                av.setDestino(destino);
                av.setNombre(nombre);
                av.setTipo(tipo);
                try {
                    dao.insert(av);
                    System.out.println("Se inserto la imagen");
                } catch (Exception ex) {
                    System.out.println("Error al llamar al dao " + ex);
                }

            }

        } catch (Exception e) {
            System.out.println("Error en el customer" + e);
        }
        Avisos av= new Avisos();
        Mensaje men =  new Mensaje();
        List <Avisos> lista = new ArrayList();
        try {
            lista=dao.getAll();
        } catch (Exception ex) {
            men.setMensaje("Error al listar");
            System.out.println("Error al llamar" +ex);
        }
        req.setAttribute("com", lista);
        req.getRequestDispatcher("admin/Vista_Comunicados.jsp").forward(req, res);

    }

    private String saveFile(Part part, File pathUploads) {
        String pathAbsolute = "";
        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String filename = path.getFileName().toString();
            InputStream input = part.getInputStream();
            if (input != null) {
                File file = new File(pathUploads, filename);
                pathAbsolute= file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }
        } catch (Exception e) {
            System.out.println("Error al subir la imagen" + e);
        }
        return pathAbsolute;
    }

    private boolean is(String filename, String[] extencions) {
        for (String et : extencions) {
            if (filename.toLowerCase().endsWith(et)) {
                return true;
            }
        }
        return false;
    }

}
