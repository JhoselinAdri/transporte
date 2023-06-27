/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Control_accidentes;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author juans
 */
public class CAccidentesDAOimpl extends ConexionDB implements CAccidenteDAO {

    @Override
    public List<Control_accidentes> findAllUsuarios() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Control_accidentes findUsuarioById(Control_accidentes accidentes) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Control_accidentes loginChofer(Control_accidentes accidentes) throws Exception {
        Control_accidentes login = new Control_accidentes();
        String sql = "SELECT * FROM `accidentes`where username=? and password=PASSWORD(?);";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, accidentes.getUsername());
            ps.setString(2, accidentes.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                login.setCi(rs.getInt("ci"));
                login.setNombre(rs.getString("nombre"));
                login.setApp(rs.getString("app"));
                login.setApm(rs.getString("apm"));
                login.setTelefono(rs.getString("telefono"));
                login.setDireccion(rs.getString("direccion"));
                login.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("Error al logear "+ e);
        }

        return login;
    }
@Override
    public Control_accidentes loginChoferVer(Control_accidentes accidentes) throws Exception {
        Control_accidentes login = new Control_accidentes();
        String sql = "SELECT * FROM `accidentes`where username=? and password=PASSWORD(?) and estado='activo';";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, accidentes.getUsername());
            ps.setString(2, accidentes.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                login.setCi(rs.getInt("ci"));
                login.setNombre(rs.getString("nombre"));
                login.setApp(rs.getString("app"));
                login.setApm(rs.getString("apm"));
                login.setTelefono(rs.getString("telefono"));
                login.setDireccion(rs.getString("direccion"));
                login.setUsername(rs.getString("username"));
            }
        } catch (Exception e) {
            System.out.println("Error al logear "+ e);
        }

        return login;
    }
    @Override
    public void insertUsuario(Control_accidentes accidentes) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateUsuario(Control_accidentes accidentes) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
