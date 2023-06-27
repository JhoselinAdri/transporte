/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Ruta;
import com.grupo.modelo.vistas.VRChofer;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class RutaDAOimp extends ConexionDB implements RutaDAO {

    @Override
    public void insert(Ruta ruta) throws Exception {
        String sql = "INSERT INTO `ruta` (`fecha`, `linea`, `ci_chofer`) VALUES (CURDATE(), ?, ?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ruta.getLinea());
            ps.setInt(2, ruta.getCi_chofer());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al llenar " + e);
        }

    }

    @Override
    public void update(Ruta ruta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VRChofer getById(int id, int linea) throws Exception {
        VRChofer ruta = new VRChofer();
        String sql = "select * from vista_ruta_chofer where fecha=CURDATE() and ci_chofer=? and linea=?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, linea);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ruta.setCi_chofer(rs.getInt("ci_chofer"));
                ruta.setFecha(rs.getDate("fecha"));
                ruta.setLinea(rs.getInt("linea"));
                ruta.setN_ruta(rs.getInt("n_ruta"));
                ruta.setApm(rs.getString("apm"));
                ruta.setApp(rs.getString("app"));
                ruta.setCi(rs.getInt("ci"));
                ruta.setLicencia(rs.getInt("licencia_id"));
                ruta.setNombre(rs.getString("nombre"));
                ruta.setCelular(rs.getString("n_celular"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar" + e);
        }
        return ruta;
    }

    @Override
    public List<Ruta> getAll() throws Exception {
        List <Ruta> r = null;
              r=  new ArrayList<Ruta>();
        
        String sql = "SELECT  * from ruta ORDER BY fecha DESC;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruta ru= new Ruta();
                ru.setCi_chofer(rs.getInt("ci_chofer"));
                ru.setFecha(rs.getDate("fecha"));
                ru.setLinea(rs.getInt("linea"));
                ru.setN_ruta(rs.getInt("n_ruta"));
                r.add(ru);
            }
        } catch (Exception e) {
            System.out.println("Error al llamar a la base de datos"+e);
        }
        return r;
        }

    @Override
    public List<Ruta> getAllCi(int i) throws Exception {
        List <Ruta> r = null;
              r=  new ArrayList<Ruta>();
        
        String sql = "SELECT  * from ruta where ci_chofer=? ORDER BY fecha DESC ;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruta ru= new Ruta();
                ru.setCi_chofer(rs.getInt("ci_chofer"));
                ru.setFecha(rs.getDate("fecha"));
                ru.setLinea(rs.getInt("linea"));
                ru.setN_ruta(rs.getInt("n_ruta"));
                r.add(ru);
            }
        } catch (Exception e) {
            System.out.println("Error al llamar a la base de datos"+e);
        }
        return r;
    }

}
