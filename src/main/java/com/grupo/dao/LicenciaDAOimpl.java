/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Licencia;
import com.grupo.utils.ConexionDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author juans
 */
public class LicenciaDAOimpl extends ConexionDB implements LicenciaDAO{

    @Override
    public List<Licencia> findAllUsuarios() throws Exception {
        List<Licencia> lista=null;
        
        return lista;
        }

    @Override
    public Licencia findUsuarioById(Licencia licencia) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertUsuario(Licencia licencia) throws Exception {
        String sql1="SELECT * FROM `licencia` where id_licencia=?";
        PreparedStatement ps=this.conn.prepareStatement(sql1);
        ps.setInt(1, licencia.getId_licencia());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            System.out.println("La Licencia ya existe");
        }else{
            String sql="INSERT INTO `licencia` (`id_licencia`, `categoria`, `fecha_exp`) VALUES (?, ?, ?)";
            PreparedStatement ps1=this.conn.prepareStatement(sql);
            ps1.setInt(1, licencia.getId_licencia());
            ps1.setString(2, licencia.getCategoria());
            ps1.setDate(3, (Date) licencia.getFecha_exp());
        }
        
        
        }

    @Override
    public void updateUsuario(Licencia licencia) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUsuario(Licencia licencia) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
