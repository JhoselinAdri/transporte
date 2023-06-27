/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Avisos;
import com.grupo.utils.ConexionDB;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jdk.internal.jimage.ImageStream;

/**
 *
 * @author juans
 */
public class AvisosDAOimpl extends ConexionDB implements AvisosDAO {

    @Override
    public void insert(Avisos avisos) throws Exception {
        String sql = "INSERT INTO `aviso` (`tipo`, `descipcion`, `ci_emisor`, `nombre`, `datos`,`detino`,`estado`) VALUES (?, ?, ? , ?, ?,?,'activo')";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        try {
            ps.setInt(1, avisos.getTipo());
            ps.setString(2, avisos.getDescripcion());
            ps.setInt(3, avisos.getCi_emisor());
            ps.setString(4, avisos.getNombre());
            ps.setString(5, avisos.getDato());
            ps.setString(6, avisos.getDestino());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar comunicados a la base de datos" + e);
        }

    }

    @Override
    public void update(Avisos avisos) throws Exception {
        String sql = "UPDATE `aviso` SET `tipo` = ?, `descipcion` = ?, `nombre` = ?, `datos` = ?, `detino` = ?, `estado` = 'activo' WHERE `aviso`.`n_aviso` = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, avisos.getTipo());
        ps.setString(2, avisos.getDescripcion());
        ps.setString(3, avisos.getNombre());
        ps.setString(4, avisos.getDato());
        ps.setString(5, avisos.getDestino());
        ps.setInt(6, avisos.getN());
        ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar comunicado"+e);
        }
        
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "UPDATE `aviso` SET `estado` = 'inactivo' WHERE `aviso`.`n_aviso` = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar comunicado"+e);
        }
    }

    @Override
    public Avisos getById(int id) throws Exception {
        Avisos av = new Avisos();
        String sql = "SELECT * FROM `aviso` where n_aviso=? and estado='activo'";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String avi = (rs.getString("datos"));
                av.setCi_emisor(rs.getInt("ci_emisor"));
                av.setDescripcion(rs.getString("descipcion"));
                av.setDestino(rs.getString("detino"));
                av.setN(rs.getInt("n_aviso"));
                av.setNombre(rs.getString("nombre"));
                av.setTipo(rs.getInt("tipo"));
                av.setDato(avi);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar avso" + e);
        }
        return av;
    }

    @Override
    public List<Avisos> getAll() throws Exception {
        List<Avisos> comunicados = new ArrayList<>();
        String sql = "SELECT * FROM `aviso`  where  estado='activo' ORDER BY `n_aviso` DESC";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String avi = (rs.getString("datos"));
                Avisos av = new Avisos();
                av.setCi_emisor(rs.getInt("ci_emisor"));
                av.setDescripcion(rs.getString("descipcion"));
                av.setDestino(rs.getString("detino"));
                av.setN(rs.getInt("n_aviso"));
                av.setNombre(rs.getString("nombre"));
                av.setTipo(rs.getInt("tipo"));
                av.setDato(avi);
                comunicados.add(av);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de avisos de la base de datos" + e);
        }
        return comunicados;

    }

    @Override
    public List<Avisos> getAllChofer() throws Exception {
        List<Avisos> comunicados = new ArrayList<>();
        String sql = "SELECT * FROM `aviso` where detino='chofer' or detino='todos'  and estado='activo'ORDER BY `n_aviso` DESC;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String avi = (rs.getString("datos"));
                Avisos av = new Avisos();
                av.setCi_emisor(rs.getInt("ci_emisor"));
                av.setDescripcion(rs.getString("descipcion"));
                av.setDestino(rs.getString("detino"));
                av.setN(rs.getInt("n_aviso"));
                av.setNombre(rs.getString("nombre"));
                av.setTipo(rs.getInt("tipo"));
                av.setDato(avi);
                comunicados.add(av);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de avisos de la base de datos" + e);
        }
        return comunicados;
    }

    @Override
    public List<Avisos> getAllAportes() throws Exception {
        List<Avisos> comunicados = new ArrayList<>();
        String sql = "SELECT * FROM `aviso` where detino='aportes' or detino='todos'  and estado='activo'ORDER BY `n_aviso` DESC;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String avi = (rs.getString("datos"));
                Avisos av = new Avisos();
                av.setCi_emisor(rs.getInt("ci_emisor"));
                av.setDescripcion(rs.getString("descipcion"));
                av.setDestino(rs.getString("detino"));
                av.setN(rs.getInt("n_aviso"));
                av.setNombre(rs.getString("nombre"));
                av.setTipo(rs.getInt("tipo"));
                av.setDato(avi);
                comunicados.add(av);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de avisos de la base de datos" + e);
        }
        return comunicados;
    }

    @Override
    public List<Avisos> getAllAccidentes() throws Exception {
        List<Avisos> comunicados = new ArrayList<>();
        String sql = "SELECT * FROM `aviso` where detino='accidentes' or detino='todos'  and estado='activo'ORDER BY `n_aviso` DESC;";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String avi = (rs.getString("datos"));
                Avisos av = new Avisos();
                av.setCi_emisor(rs.getInt("ci_emisor"));
                av.setDescripcion(rs.getString("descipcion"));
                av.setDestino(rs.getString("detino"));
                av.setN(rs.getInt("n_aviso"));
                av.setNombre(rs.getString("nombre"));
                av.setTipo(rs.getInt("tipo"));
                av.setDato(avi);
                comunicados.add(av);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de avisos de la base de datos" + e);
        }
        return comunicados;
    }

    @Override
    public List<Avisos> getAllParada() throws Exception {
        List<Avisos> comunicados = new ArrayList<>();
        String sql = "SELECT * FROM `aviso` where detino='parada' or detino='todos'  and estado='activo'ORDER BY `n_aviso` DESC";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String avi = (rs.getString("datos"));
                Avisos av = new Avisos();
                av.setCi_emisor(rs.getInt("ci_emisor"));
                av.setDescripcion(rs.getString("descipcion"));
                av.setDestino(rs.getString("detino"));
                av.setN(rs.getInt("n_aviso"));
                av.setNombre(rs.getString("nombre"));
                av.setTipo(rs.getInt("tipo"));
                av.setDato(avi);
                comunicados.add(av);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de avisos de la base de datos" + e);
        }
        return comunicados;
    }

    @Override
    public List<Avisos> getAllTodos() throws Exception {
        List<Avisos> comunicados = new ArrayList<>();
        String sql = "SELECT * FROM `aviso` where detino='todos'  and estado='activo'ORDER BY `n_aviso` DESC";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String avi = (rs.getString("datos"));
                Avisos av = new Avisos();
                av.setCi_emisor(rs.getInt("ci_emisor"));
                av.setDescripcion(rs.getString("descipcion"));
                av.setDestino(rs.getString("detino"));
                av.setN(rs.getInt("n_aviso"));
                av.setNombre(rs.getString("nombre"));
                av.setTipo(rs.getInt("tipo"));
                av.setDato(avi);
                comunicados.add(av);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener datos de avisos de la base de datos" + e);
        }
        return comunicados;
    }

}
