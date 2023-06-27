package com.grupo.dao.vista;

import com.grupo.modelo.vistas.VistaAC;
import com.grupo.modelo.vistas.VistaDCV;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class VACDAOimpl extends ConexionDB implements VCADAO {

    @Override
    public VistaAC getById(int i) throws Exception {
        VistaAC aportes = new VistaAC();
        String sql = "SELECT * FROM vista_chofer_aportes where n_aporte=?";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                aportes.setApm(rs.getString("apm"));
                aportes.setApm_aportes(rs.getString("apm_aportes"));
                aportes.setApp(rs.getString("app"));
                aportes.setApp_aportes(rs.getString("app_aportes"));
                aportes.setCi(rs.getInt("ci"));
                aportes.setCi_a(rs.getInt("ci_a"));
                aportes.setCi_aportes(rs.getInt("ci_aportes"));
                aportes.setCi_chofer(rs.getInt("ci_chofer"));
                aportes.setConcepto(rs.getString("concepto"));
                aportes.setFecha(rs.getDate("fecha"));
                aportes.setGrupo(rs.getInt("grupo"));
                aportes.setMonto(rs.getDouble("monto"));
                aportes.setN_celular(rs.getString("n_celular"));
                aportes.setNombre(rs.getString("nombre"));
                aportes.setNombre_aporte(rs.getString("nombre_aportes"));
                aportes.setN_aporte(rs.getInt("n_aporte"));
                aportes.setPlaca(rs.getString("placa"));
                aportes.setSector(rs.getString("sector"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());
            
        } 
        return aportes;
    }

    @Override
    public List<VistaAC> ViewApoptesChofer(VistaDCV aporte) throws Exception {
        List<VistaAC> lista = null;
        lista = new ArrayList<VistaAC>();

        String sql = "SELECT * FROM vista_chofer_aportes where ci=?";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, aporte.getCi());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<VistaAC>();
            while (rs.next()) {
                VistaAC aportes = new VistaAC();
                aportes.setApm(rs.getString("apm"));
                aportes.setApm_aportes(rs.getString("apm_aportes"));
                aportes.setApp(rs.getString("app"));
                aportes.setApp_aportes(rs.getString("apm_aportes"));
                aportes.setCi(rs.getInt("ci"));
                aportes.setCi_a(rs.getInt("ci_a"));
                aportes.setCi_aportes(rs.getInt("ci_aportes"));
                aportes.setCi_chofer(rs.getInt("ci_chofer"));
                aportes.setConcepto(rs.getString("concepto"));
                aportes.setFecha(rs.getDate("fecha"));
                aportes.setGrupo(rs.getInt("grupo"));
                aportes.setMonto(rs.getDouble("monto"));
                aportes.setN_celular(rs.getString("n_celular"));
                aportes.setNombre(rs.getString("nombre"));
                aportes.setNombre_aporte(rs.getString("nombre_aportes"));
                aportes.setN_aporte(rs.getInt("n_aporte"));
                aportes.setPlaca(rs.getString("placa"));
                aportes.setSector(rs.getString("sector"));
                lista.add(aportes);

            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());

        }
        return lista;
    }

    @Override
    public List<VistaAC> ViewApoptes() throws Exception {
        List<VistaAC> lista = null;
        lista = new ArrayList<VistaAC>();

        String sql = "SELECT * FROM vista_chofer_aportes";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<VistaAC>();
            while (rs.next()) {
                VistaAC aportes = new VistaAC();
                aportes.setApm(rs.getString("apm"));
                aportes.setApm_aportes(rs.getString("apm_aportes"));
                aportes.setApp(rs.getString("app"));
                aportes.setApp_aportes(rs.getString("apm_aportes"));
                aportes.setCi(rs.getInt("ci"));
                aportes.setCi_a(rs.getInt("ci_a"));
                aportes.setCi_aportes(rs.getInt("ci_aportes"));
                aportes.setCi_chofer(rs.getInt("ci_chofer"));
                aportes.setConcepto(rs.getString("concepto"));
                aportes.setFecha(rs.getDate("fecha"));
                aportes.setGrupo(rs.getInt("grupo"));
                aportes.setMonto(rs.getDouble("monto"));
                aportes.setN_celular(rs.getString("n_celular"));
                aportes.setNombre(rs.getString("nombre"));
                aportes.setNombre_aporte(rs.getString("nombre_aportes"));
                aportes.setN_aporte(rs.getInt("n_aporte"));
                aportes.setPlaca(rs.getString("placa"));
                aportes.setSector(rs.getString("sector"));
                lista.add(aportes);

            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());

        }
        return lista;
   }


}
