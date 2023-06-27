package com.grupo.dao.vista;

import com.grupo.modelo.vistas.VistaACD;
import com.grupo.modelo.vistas.VistaDCV;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VACDDAOimpl extends ConexionDB implements VACDDAO{


    @Override
    public VistaACD getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VistaACD> ViewAccidentesChofer(VistaDCV acidente) throws Exception {
                List<VistaACD> lista = null;
        lista = new ArrayList<VistaACD>();

        String sql = "SELECT * FROM `vistaaccidentes` where ci=? ORDER BY `numero` DESC";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, acidente.getCi());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<VistaACD>();
            while (rs.next()) {
                VistaACD accide = new VistaACD();
                accide.setCi(rs.getInt("ci"));
                accide.setConcepto(rs.getString("concepto"));
                accide.setDetalle(rs.getString("detalle"));
                accide.setFecha(rs.getDate("fecha"));
                accide.setNumero(rs.getInt("numero"));
                accide.setPlaca(rs.getString("placa"));
                accide.setUbicacion(rs.getString("ubicacion"));
                lista.add(accide);

            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR accidentes:  " + e.getMessage());

        }
        return lista;
    }
    
    
}
