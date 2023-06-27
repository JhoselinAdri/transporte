/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Control_ruta;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class ControlRutaDAOimpl extends ConexionDB implements ControlRutaDAO{

    @Override
    public void insert(Control_ruta rutas) throws Exception {
        String sql = "INSERT INTO `control_ruta` (`ci`, `nombre`, `app`, `apm`, `telefono`, `username`, `password`,`estado`) VALUES ( ?, ?, ?, ?, ?, ?, PASSWORD(?),'activo')";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        try {
            ps.setInt(1, rutas.getCi());
            ps.setString(2, rutas.getNombre());
            ps.setString(3, rutas.getApp());
            ps.setString(4, rutas.getApm());
            ps.setString(5, rutas.getTelefono());
            ps.setString(6, rutas.getUsername());
            ps.setString(7, rutas.getPassword());
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar a la base de datos" + e);
        }
    }

    @Override
    public void update(Control_ruta rutas) throws Exception {
        String sql = "UPDATE `control_ruta` SET `nombre` = ?, `app` = ?, `apm` = ?, `telefono` = ? WHERE `ci` = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, rutas.getNombre());
            ps.setString(2, rutas.getApp());
            ps.setString(3, rutas.getApm());
            ps.setString(4, rutas.getTelefono());

            ps.setInt(5, rutas.getCi());
            ps.executeUpdate();
            System.out.println("Acctualizado");
        } catch (Exception e) {
            System.out.println("Error al actualizar accidente"+e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Control_ruta getById(int id) throws Exception {
        String sql = "SELECT * FROM control_ruta where ci=?;";
        this.conectar();
        Control_ruta usuario = new Control_ruta();
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
    public List<Control_ruta> getAll() throws Exception {
        List<Control_ruta> lista= new ArrayList<Control_ruta>();
        String sql = "SELECT * FROM control_ruta;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            lista = new ArrayList<Control_ruta>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Control_ruta usuario= new Control_ruta();
                usuario.setCi(rs.getInt("ci"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApp(rs.getString("app"));
                usuario.setApm(rs.getString("apm"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setEstado(rs.getString("estado"));
                
                usuario.setUsername(rs.getString("username"));
                lista.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR: " + e.getMessage());
        } finally {

        }
        return lista;
    }

    @Override
    public Control_ruta login(Control_ruta cr) throws Exception {
        String sql = "SELECT * FROM `control_ruta` where username=? and password=PASSWORD(?)";
        Control_ruta ca = new Control_ruta();
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cr.getUsername());
            ps.setString(2, cr.getPassword());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ca.setApm(rs.getString("apm"));
                ca.setApp(rs.getString("app"));
                ca.setCi(rs.getInt("ci"));
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
    public Control_ruta loginver(Control_ruta cr) throws Exception {
        String sql = "SELECT * FROM `control_ruta` where username=? and password=PASSWORD(?) and estado='activo'";
        Control_ruta ca = new Control_ruta();
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cr.getUsername());
            ps.setString(2, cr.getPassword());
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ca.setApm(rs.getString("apm"));
                ca.setApp(rs.getString("app"));
                ca.setCi(rs.getInt("ci"));
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
    public void updatePass(Control_ruta c) throws Exception {
        String sql = "UPDATE `control_ruta` SET `password` = PASSWORD(?) WHERE `ci` = ?;";
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
    public void updatedelete(Control_ruta c) throws Exception {
        String sql = "UPDATE `control_ruta` SET `estado` = 'inactivo' WHERE `ci` = ?;";
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
    public void updatehabil(Control_ruta c) throws Exception {
        String sql = "UPDATE `control_ruta` SET `estado` = 'activo' WHERE `ci` = ?;";
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
    public Control_ruta veripass(Control_ruta c) throws Exception {
        String sql = "SELECT * FROM control_ruta where ci=? and password=PASSWORD(?);;";
        this.conectar();
        Control_ruta usuario = new Control_ruta();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, c.getCi());
            ps.setString(2, c.getPassword());
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setCi(rs.getInt("ci"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApp(rs.getString("app"));
                usuario.setApm(rs.getString("apm"));
                usuario.setTelefono(rs.getString("telefono"));
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
