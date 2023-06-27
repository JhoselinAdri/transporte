/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Vehiculo;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author juans
 */
public class VehiculoDAOimpl extends ConexionDB implements VehiculoDAO{

    @Override
    public void insert(Vehiculo vehiculo) throws Exception {
    }

    @Override
    public void update(Vehiculo vehiculo) throws Exception {
    }

    @Override
    public void delete(int id) throws Exception {
    }

    @Override
    public Vehiculo getById(String id) throws Exception {
        Vehiculo ve = new Vehiculo();
        String sql = "SELECT * FROM `vehiculo`where placa = ?";
        try {
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ve.setCapacidad(rs.getInt("capacidad"));
                ve.setCi_conductor(rs.getInt("ci_conductor"));
                ve.setEstado(rs.getString("estado"));
                ve.setMarca(rs.getString("marca"));
                ve.setModelo(rs.getString("modelo"));
                ve.setPlaca(rs.getString("placa"));
                ve.setTipo(rs.getString("tipo"));
            }
        } catch (Exception e) {
            System.out.println("error al buscar"+e);
        }
        return ve;
    }

    @Override
    public List<Vehiculo> getAll() throws Exception {
        List<Vehiculo> lista = null;
        return lista;
    }
    
}
