
package com.grupo.dao.vista;

import com.grupo.modelo.vistas.VistaDCV;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author juans
 */
public class VDCVDAOimpl extends ConexionDB implements VDCVDAO{

    @Override
    public VistaDCV loginChofer(VistaDCV chofer) throws Exception {
        VistaDCV choferr = new VistaDCV();
        String sql = "SELECT * FROM datos_chofer_vehiculo WHERE username = ? AND password = PASSWORD(?);";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, chofer.getUsername());
            ps.setString(2, chofer.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                choferr.setCi(rs.getInt("ci"));
                choferr.setNombre(rs.getString("nombre"));
                choferr.setApp(rs.getString("app"));
                choferr.setApm(rs.getString("apm"));
                choferr.setN_celular(rs.getString("n_celular"));
                choferr.setLicencia_id(rs.getInt("licencia_id"));
                choferr.setPassword(rs.getString("password"));
                choferr.setUsername(rs.getString("username"));
                choferr.setPlaca(rs.getString("placa"));
                choferr.setModelo(rs.getInt("modelo"));
                choferr.setMarca(rs.getString("marca"));
                choferr.setEstado(rs.getString("estado"));
                choferr.setTipo(rs.getString("tipo"));
                choferr.setCapacidad(rs.getInt("capacidad"));
                choferr.setCi_conductor(rs.getInt("ci_conductor"));
                choferr.setCategoria(rs.getString("categoria"));
                choferr.setFecha_exp(rs.getDate("fecha_exp"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());
            
        } 
        return choferr;
    }

    @Override
    public VistaDCV idChofer(VistaDCV chofer) throws Exception {
        VistaDCV choferr = new VistaDCV();
        System.out.println(chofer.getCi());
        String sql = "SELECT * FROM datos_chofer_vehiculo WHERE ci = ?";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, chofer.getCi());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                choferr.setCi(rs.getInt("ci"));
                choferr.setNombre(rs.getString("nombre"));
                choferr.setApp(rs.getString("app"));
                choferr.setApm(rs.getString("apm"));
                choferr.setN_celular(rs.getString("n_celular"));
                choferr.setLicencia_id(rs.getInt("licencia_id"));
                choferr.setUsername(rs.getString("username"));
                choferr.setPlaca(rs.getString("placa"));
                choferr.setModelo(rs.getInt("modelo"));
                choferr.setMarca(rs.getString("marca"));
                choferr.setEstado(rs.getString("estado"));
                choferr.setTipo(rs.getString("tipo"));
                choferr.setCapacidad(rs.getInt("capacidad"));
                choferr.setCi_conductor(rs.getInt("ci_conductor"));
                choferr.setCategoria(rs.getString("categoria"));
                choferr.setFecha_exp(rs.getDate("fecha_exp"));
                System.out.println(choferr.getNombre());
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());
            
        } 
        return choferr;
    }

    @Override
    public VistaDCV idPlaca(VistaDCV chofer) throws Exception {
        VistaDCV choferr = new VistaDCV();
        String sql = "SELECT * FROM datos_chofer_vehiculo WHERE placa = ?";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, chofer.getPlaca());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                choferr.setCi(rs.getInt("ci"));
                choferr.setNombre(rs.getString("nombre"));
                choferr.setApp(rs.getString("app"));
                choferr.setApm(rs.getString("apm"));
                choferr.setN_celular(rs.getString("n_celular"));
                choferr.setLicencia_id(rs.getInt("licencia_id"));
                choferr.setUsername(rs.getString("username"));
                choferr.setPlaca(rs.getString("placa"));
                choferr.setModelo(rs.getInt("modelo"));
                choferr.setMarca(rs.getString("marca"));
                choferr.setEstado(rs.getString("estado"));
                choferr.setTipo(rs.getString("tipo"));
                choferr.setCapacidad(rs.getInt("capacidad"));
                choferr.setCi_conductor(rs.getInt("ci_conductor"));
                choferr.setCategoria(rs.getString("categoria"));
                choferr.setFecha_exp(rs.getDate("fecha_exp"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());
            
        } 
        return choferr;
    }
    
}
