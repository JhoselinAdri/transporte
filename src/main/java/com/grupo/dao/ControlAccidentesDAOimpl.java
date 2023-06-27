/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Control_accidentes;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class ControlAccidentesDAOimpl extends ConexionDB implements ControlAccidentesDAO {

    @Override
    public void insert(Control_accidentes accidentes) throws Exception {
        String sql = "INSERT INTO `accidentes` (`ci`, `nombre`, `app`, `apm`, `telefono`, `direccion`, `username`, `password`,`estado`) VALUES (?, ?, ?, ?, ?, ?, ?, PASSWORD(?),'activo')";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        try {
            ps.setInt(1, accidentes.getCi());
            ps.setString(2, accidentes.getNombre());
            ps.setString(3, accidentes.getApp());
            ps.setString(4, accidentes.getApm());
            ps.setString(5, accidentes.getTelefono());
            ps.setString(6, accidentes.getDireccion());
            ps.setString(7, accidentes.getUsername());
            ps.setString(8, accidentes.getPassword());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar a la base de datos" + e);
        }
    }

    @Override
    public void update(Control_accidentes accidentes) throws Exception {
        
        String sql ="UPDATE `accidentes` SET `nombre` = ?, `app` = ?, `apm` = ?, `telefono` = ?, `direccion` = ? WHERE `accidentes`.`ci` = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,accidentes.getNombre());
            ps.setString(2,accidentes.getApp());
            ps.setString(3,accidentes.getApm());
            ps.setString(4,accidentes.getTelefono());
            ps.setString(5,accidentes.getDireccion());
            
            ps.setInt(6, accidentes.getCi());
            ps.executeUpdate();
            System.out.println("Acctualizado");
        } catch (Exception e) {
            System.out.println("Error al actualizar accidente");
        }
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Control_accidentes getById(int id) throws Exception {
        String sql = "SELECT * FROM accidentes where ci=?;";
        this.conectar();
        Control_accidentes usuario = new Control_accidentes();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setCi(rs.getInt("ci"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApp(rs.getString("app"));
                usuario.setApm(rs.getString("apm"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR: " + e.getMessage());
        } finally {

        }
        return usuario;
    }

    @Override
    public List<Control_accidentes> getAll() throws Exception {
        List<Control_accidentes> lista = new ArrayList<Control_accidentes>();
        String sql = "SELECT * FROM accidentes;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            lista = new ArrayList<Control_accidentes>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Control_accidentes usuario = new Control_accidentes();
                usuario.setCi(rs.getInt("ci"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApp(rs.getString("app"));
                usuario.setApm(rs.getString("apm"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEstado(rs.getString("estado"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR: " + e.getMessage());
        } finally {

        }
        return lista;
    }

    @Override
    public void updatePass(Control_accidentes c) throws Exception {
        String sql = "UPDATE `accidentes` SET `password` = PASSWORD(?) WHERE `ci` = ?;";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, c.getPassword());
            ps.setInt(2, c.getCi());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al Actualizar chofer desde DAO: " + e.getMessage());
        }
    }

    @Override
    public void updatedelete(Control_accidentes c) throws Exception {
        String sql = "UPDATE `accidentes` SET `estado` = 'inactivo' WHERE `ci` = ?;";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, c.getCi());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al desabilitar chofer desde DAO: " + e.getMessage());
        }
    }

    @Override
    public void updatehabil(Control_accidentes c) throws Exception {
        String sql = "UPDATE `accidentes` SET `estado` = 'activo' WHERE `ci` = ?;";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, c.getCi());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al habilitar chofer desde DAO: " + e.getMessage());
        }
    }

    @Override
    public Control_accidentes veripass(Control_accidentes ca) throws Exception {
        String sql = "SELECT * FROM accidentes where ci=? and password=PASSWORD(?);";
        this.conectar();
        Control_accidentes usuario = new Control_accidentes();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, ca.getCi());
            ps.setString(2, ca.getPassword());
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setCi(rs.getInt("ci"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApp(rs.getString("app"));
                usuario.setApm(rs.getString("apm"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setUsername(rs.getString("username"));
                usuario.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR: " + e.getMessage());
        } finally {

        }
        return usuario;
    }

}
