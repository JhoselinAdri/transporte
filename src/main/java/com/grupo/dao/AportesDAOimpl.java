/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.dao.AportesDAO;
import com.grupo.modelo.Aportes;
import com.grupo.utils.ConexionDB;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author juans
 */
public class AportesDAOimpl extends ConexionDB implements AportesDAO {

    @Override
    public void insert(Aportes aporte) throws Exception {
        String sql = "INSERT INTO `aportes` (`monto`, `fecha`, `ci_chofer`, `ci_aportes`, `concepto`, `sector`, `grupo`, `placa`) VALUES (?,CURDATE(),?, ?, ?, ?,?, ?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        try {
            ps.setDouble(1, aporte.getMonto());
            ps.setInt(2, aporte.getCi_chofer());
            ps.setInt(3, aporte.getCi_aportes());
            ps.setString(4, aporte.getConcepto());
            ps.setString(5, aporte.getSector());
            ps.setString(6, aporte.getGrupo());
            ps.setString(7, aporte.getPlaca_vehiculo());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar registro aporte"+e);
        }

    }

    @Override
    public void update(Aportes aporte) throws Exception {
        String sql = "UPDATE `aportes` SET `monto` = ? WHERE `aportes`.`n_aporte` = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        try {
            ps.setDouble(1, aporte.getMonto());
            ps.setInt(2, aporte.getN());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar registro aporte"+e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Aportes getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Aportes> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
