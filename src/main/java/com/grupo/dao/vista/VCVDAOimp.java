/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao.vista;

import com.grupo.modelo.vistas.VCV;
import com.grupo.modelo.vistas.VueltasContar;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class VCVDAOimp extends ConexionDB implements VCVDAO {

    @Override
    public List<VCV> ViewAll() throws Exception {
        List<VCV> lista = null;
        String sql = "SELECT * FROM `vista_registro_vueltas`  ORDER BY fecha DESC";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<VCV>();
            while (rs.next()) {
                VCV vista = new VCV();
                vista.setApm(rs.getString("apm"));
                vista.setApp(rs.getString("app"));
                vista.setApm_control(rs.getString("apm_control"));
                vista.setApp_control(rs.getString("app_control"));
                vista.setCi_chofer(rs.getInt("ci_chofer"));
                vista.setCi_control(rs.getInt("ci_control"));
                vista.setFecha(rs.getDate("fecha"));
                vista.setLinea(rs.getInt("linea"));
                vista.setN(rs.getInt("n"));
                vista.setNombre(rs.getString("nombre"));
                vista.setNombre_control(rs.getString("nombre_control"));
                vista.setVueltas(rs.getInt("vueltas"));
                lista.add(vista);
            }

        } catch (Exception e) {
            System.out.println("Error al llamar a la base de datos" + e);
        }
        return lista;
    }

    @Override
    public List<VCV> ViewChoferAll(int ci) throws Exception {
        List<VCV> lista = null;
        String sql = "SELECT * FROM `vista_registro_vueltas` WHERE ci_chofer=?  ORDER BY fecha DESC;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ci);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<VCV>();
            while (rs.next()) {
                VCV vista = new VCV();
                vista.setApm(rs.getString("apm"));
                vista.setApp(rs.getString("app"));
                vista.setApm_control(rs.getString("apm_control"));
                vista.setApp_control(rs.getString("app_control"));
                vista.setCi_chofer(rs.getInt("ci_chofer"));
                vista.setCi_control(rs.getInt("ci_control"));
                vista.setFecha(rs.getDate("fecha"));
                vista.setLinea(rs.getInt("linea"));
                vista.setN(rs.getInt("n"));
                vista.setNombre(rs.getString("nombre"));
                vista.setNombre_control(rs.getString("nombre_control"));
                vista.setVueltas(rs.getInt("vueltas"));
                lista.add(vista);
            }

        } catch (Exception e) {
            System.out.println("Error al llamar a la base de datos" + e);
        }
        return lista;
    }

    @Override
    public List<VueltasContar> ViewGrafico() throws Exception {
        List<VueltasContar> lista = null;
        String sql = "SELECT * FROM `vista_contador_vueltas`";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<VueltasContar>();
            while (rs.next()) {
                VueltasContar v = new VueltasContar();
                v.setCuanto(rs.getInt("total_vueltas"));
                v.setN(rs.getInt("vueltas"));
                lista.add(v);
            }
        } catch (Exception e) {
            System.out.println("error al contar" + e);
        }
        return lista;
    }

    @Override
    public List<VueltasContar> ViewChofer(int i) throws Exception {
        List<VueltasContar> lista = null;
        String sql = "SELECT * FROM `nombre_vista` where ci_chofer=?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<VueltasContar>();
            while (rs.next()) {
                VueltasContar v = new VueltasContar();
                v.setCuanto(rs.getInt("total_vueltas"));
                v.setN(rs.getInt("vueltas"));
                lista.add(v);
            }
        } catch (Exception e) {
            System.out.println("error al contar n_vustal" + e);
        }
        return lista;
    }

}
