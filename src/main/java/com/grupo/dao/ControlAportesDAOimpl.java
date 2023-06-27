/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Control_aportes;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class ControlAportesDAOimpl extends ConexionDB implements ControlAportesDAO {

    @Override
    public void insert(Control_aportes controlaportes) throws Exception {
        String sql = "INSERT INTO `control_aportes` (`ci`, `nombre`, `app`, `apm`, `telefono`, `direccion`, `username`, `password`,`estado`) VALUES (?, ?, ?, ?, ?, ?, ?, PASSWORD(?),'activo')";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        try {
            ps.setInt(1, controlaportes.getCi());
            ps.setString(2, controlaportes.getNombre());
            ps.setString(3, controlaportes.getApp());
            ps.setString(4, controlaportes.getApm());
            ps.setString(5, controlaportes.getTelefono());
            ps.setString(6, controlaportes.getDireccion());
            ps.setString(7, controlaportes.getUsername());
            ps.setString(8, controlaportes.getPassword());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar a la base de datos" + e);
        }
    }

    @Override
    public void update(Control_aportes controlaportes) throws Exception {
         String sql ="UPDATE `control_aportes` SET `nombre` = ?, `app` = ?, `apm` = ?, `telefono` = ?, `direccion` = ? WHERE `ci` = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,controlaportes.getNombre());
            ps.setString(2,controlaportes.getApp());
            ps.setString(3,controlaportes.getApm());
            ps.setString(4,controlaportes.getTelefono());
            ps.setString(5,controlaportes.getDireccion());
            
            ps.setInt(6, controlaportes.getCi());
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
    public Control_aportes getById(int id) throws Exception {
        String sql = "SELECT * FROM control_aportes where ci=?;";
        this.conectar();
        Control_aportes usuario = new Control_aportes();
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
    public List<Control_aportes> getAll() throws Exception {
        List<Control_aportes> lista= new ArrayList<Control_aportes>();
        String sql = "SELECT * FROM control_aportes;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            lista = new ArrayList<Control_aportes>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Control_aportes usuario= new Control_aportes();
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
    public Control_aportes login(Control_aportes aportes) throws Exception {
        String sql = "SELECT * FROM `control_aportes` where username=? and password=PASSWORD(?)";
        Control_aportes ca = new Control_aportes();
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aportes.getUsername());
            ps.setString(2, aportes.getPassword());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ca.setApm(rs.getString("apm"));
                ca.setApp(rs.getString("app"));
                ca.setCi(rs.getInt("ci"));
                ca.setDireccion(rs.getString("direccion"));
                ca.setNombre(rs.getString("nombre"));
                ca.setTelefono(rs.getString("telefono"));
                ca.setUsername(rs.getString("username"));
                
            }
        }catch (Exception e) {
            System.out.println("Error al buscar usuario aportes" +e);
        }
        return ca;
    }
 @Override
    public Control_aportes loginver(Control_aportes aportes) throws Exception {
        String sql = "SELECT * FROM `control_aportes` where username=? and password=PASSWORD(?) and estado='activo'";
        Control_aportes ca = new Control_aportes();
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aportes.getUsername());
            ps.setString(2, aportes.getPassword());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ca.setApm(rs.getString("apm"));
                ca.setApp(rs.getString("app"));
                ca.setCi(rs.getInt("ci"));
                ca.setDireccion(rs.getString("direccion"));
                ca.setNombre(rs.getString("nombre"));
                ca.setTelefono(rs.getString("telefono"));
                ca.setUsername(rs.getString("username"));
                
            }
        }catch (Exception e) {
            System.out.println("Error al buscar usuario aportes" +e);
        }
        return ca;
    }
    @Override
    public void updatePass(Control_aportes c) throws Exception {
        String sql = "UPDATE `control_aportes` SET `password` = PASSWORD(?) WHERE `ci` = ?;";
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
    public void updatedelete(Control_aportes c) throws Exception {
        String sql = "UPDATE `control_aportes` SET `estado` = 'inactivo' WHERE `ci` = ?;";
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
    public void updatehabil(Control_aportes c) throws Exception {
        String sql = "UPDATE `control_aportes` SET `estado` = 'activo' WHERE `ci` = ?;";
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
    public Control_aportes veripass(Control_aportes ca) throws Exception {
        String sql = "SELECT * FROM control_aportes where ci=? and password=PASSWORD(?);";
        this.conectar();
        Control_aportes usuario = new Control_aportes();
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
