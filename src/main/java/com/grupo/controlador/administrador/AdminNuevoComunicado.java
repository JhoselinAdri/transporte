package com.grupo.controlador.administrador;

import com.grupo.dao.AvisosDAO;
import com.grupo.dao.AvisosDAOimpl;
import com.grupo.modelo.Admin;
import com.grupo.modelo.Avisos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "AdminNuevoComunicado", urlPatterns = {"/AdminNuevoComunicado"})
@MultipartConfig
public class AdminNuevoComunicado extends HttpServlet {

    AvisosDAO dao = new AvisosDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin usuario = (Admin) session.getAttribute("usuario");
        if (usuario == null ) {
            response.sendRedirect("LoginAdmin.jsp");
        } else {
            request.getRequestDispatcher("admin/Vista_Nuevo_Comunicado.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    private String saveFile(Part part, File pathUploads){
        String pathAbsolute="";
        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String filename = path.getFileName().toString();
            InputStream input = part.getInputStream();
            if(input!= null){
                File file = new File(pathUploads,filename);
                Files.copy(input, file.toPath());
            }
        } catch (Exception e) {
            System.out.println("Error al subir la imagen"+e);
        }
        return pathAbsolute;
    }
    private boolean is(String filename,String[] extencions){
        for(String et: extencions){
            if(filename.toLowerCase().endsWith(et)){
                return true;
            }
        }
        return false;
    }



}
