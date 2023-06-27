/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Vuelta;
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
public class VueltaDAOimp extends ConexionDB implements VueltaDAO {

    @Override
    public void insert(Vuelta vuelta) throws Exception {
        int n = 0;
        String sql1 = "SELECT COUNT(*) +1 as total from vuelta where n_ruta = ? ;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql1);
            ps.setInt(1, vuelta.getN_ruta());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt("total");
            }

        } catch (Exception e) {
            System.out.println("Error al contar" + e);
        }

        System.out.println(n);
        String sql = "INSERT INTO vuelta (numero, hora_salida, hora_llegada, control_vuelta, observaciones, n_ruta) VALUES (?,  NULL, CURTIME(), ?, ?, ?)";

// Resto del código para establecer los valores de los parámetros y ejecutar la consulta
        try {
            PreparedStatement ps1 = this.conn.prepareStatement(sql);
            ps1.setInt(1, n);
            ps1.setInt(2, vuelta.getCi_control());
            ps1.setString(3, vuelta.getObservaciones());
            ps1.setInt(4, vuelta.getN_ruta());
            ps1.executeUpdate();
            System.out.println("Se registro en la base de datos");
        } catch (Exception e) {
            System.out.println("Error al insertar" + e);
        }
    }

    @Override
    public void update(Vuelta vuelta) throws Exception {
        String sql ="UPDATE `vuelta` SET `hora_salida` = CURTIME() WHERE `n_vuelta` = ?";
        try {
            System.out.println(vuelta.getN_vueta());
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, vuelta.getN_vueta());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar"+e);
        }
        
        }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vuelta getById(int ci,int linea) throws Exception {
        String sql = "SELECT * FROM ruta r JOIN vuelta v ON r.n_ruta = v.n_ruta WHERE r.fecha = CURDATE() AND  v.hora_salida IS NULL AND r.ci_chofer = ? and r.linea=?;";
        Vuelta v = new Vuelta();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, ci);
        ps.setInt(2, linea);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            v.setCi_control(rs.getInt("control_vuelta"));
            v.setN_ruta(rs.getInt("n_ruta"));
            v.setN_vueta(rs.getInt("n_vuelta"));
            v.setNumero(rs.getInt("numero"));
            v.setObservaciones(rs.getString("observaciones"));
            
        }
        } catch (Exception e) {
            System.out.println("Error en sql "+e);
        }
        
        return v;
        }

    @Override
    public List<Vuelta> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vuelta> getAllByid(Vuelta vuelta) throws Exception {
        List<Vuelta> datos =  new ArrayList<Vuelta>();
        String sql = "SELECT *,TIME_FORMAT(hora_llegada, '%H:%i:%s') AS h_llegada,TIME_FORMAT(hora_salida, '%H:%i:%s') AS h_salida   FROM `vuelta` WHERE n_ruta = ?;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, vuelta.getN_ruta());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Vuelta v= new Vuelta();
                v.setCi_control(rs.getInt("control_vuelta"));
                v.setHora_llegada(rs.getString("h_llegada"));
                v.setHora_salida(rs.getString("h_salida"));
                v.setN_ruta(rs.getInt("n_ruta"));
                v.setN_vueta(rs.getInt("n_vuelta"));
                v.setNumero(rs.getInt("numero"));
                v.setObservaciones(rs.getString("observaciones"));
                datos.add(v);
            }
        } catch (Exception e) {
            System.out.println("Error la buscar "+e);
        }
        return datos;
        }

    @Override
    public List<Vuelta> getAllNoe(Vuelta vuelta, int i) throws Exception {
        
        VRChofer ruta = new VRChofer();
        String sql = "select * from vista_ruta_chofer where fecha=CURDATE() and ci_chofer=?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, i);
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
        List<Vuelta> datos =  new ArrayList<Vuelta>();
        String sql1 = "SELECT *,TIME_FORMAT(hora_llegada, '%H:%i:%s') AS h_llegada,TIME_FORMAT(hora_salida, '%H:%i:%s') AS h_salida   FROM `vuelta` WHERE n_ruta = ?;";
        try {
            PreparedStatement ps1 = this.conn.prepareStatement(sql1);
            ps1.setInt(1, ruta.getN_ruta());
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                Vuelta v= new Vuelta();
                v.setCi_control(rs.getInt("control_vuelta"));
                v.setHora_llegada(rs.getString("h_llegada"));
                v.setHora_salida(rs.getString("h_salida"));
                v.setN_ruta(rs.getInt("n_ruta"));
                v.setN_vueta(rs.getInt("n_vuelta"));
                v.setNumero(rs.getInt("numero"));
                v.setObservaciones(rs.getString("observaciones"));
                datos.add(v);
            }
        } catch (Exception e) {
            System.out.println("Error la buscar "+e);
        }
        return datos;
        }

}
