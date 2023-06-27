/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Admin;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author juans
 */
public class AdminDAOimpl extends ConexionDB implements AdminDAO{

    @Override
    public void insert(Admin admin) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Admin admin) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Admin getById(int id) throws Exception {
        Admin login = new Admin();
        String sql = "SELECT * FROM admin WHERE ci = ? ";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                login.setCi(rs.getInt("ci"));
                login.setApm(rs.getString("apm"));
                login.setApp(rs.getString("app"));
                login.setCelular(rs.getString("celular"));
                login.setDireccion(rs.getString("direccion"));
                login.setNombre(rs.getString("nombre"));
                login.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());
            
        } 
        return login;
    }

    @Override
    public List<Admin> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Admin Login(Admin admin) throws Exception {
        Admin login = new Admin();
        String sql = "SELECT * FROM admin WHERE username = ? AND password = PASSWORD(?);";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                login.setCi(rs.getInt("ci"));
                login.setApm(rs.getString("apm"));
                login.setApp(rs.getString("app"));
                login.setCelular(rs.getString("celular"));
                login.setDireccion(rs.getString("direccion"));
                login.setNombre(rs.getString("nombre"));
                login.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());
            
        } 
        return login;
    }

    @Override
    public Admin veripass(Admin admin) throws Exception {
        Admin login = new Admin();
        String sql = "SELECT * FROM admin WHERE ci = ? AND password = PASSWORD(?);";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, admin.getCi());
            ps.setString(2, admin.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                login.setCi(rs.getInt("ci"));
                login.setApm(rs.getString("apm"));
                login.setApp(rs.getString("app"));
                login.setCelular(rs.getString("celular"));
                login.setDireccion(rs.getString("direccion"));
                login.setNombre(rs.getString("nombre"));
                login.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());
            
        } 
        return login;
    }

    @Override
    public void updatePass(Admin admin) throws Exception {
        String sql = "UPDATE `admin` SET `password` = PASSWORD(?) WHERE `ci` = ?;";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, admin.getPassword());
            ps.setInt(2, admin.getCi());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al Actualizar chofer desde DAO: " + e.getMessage());
        }
   }
    
    
}
