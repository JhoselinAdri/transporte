/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Detalle_accidente;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class DetalleAccidenteDAOimpl extends ConexionDB implements DetalleAccidenteDAO {

    @Override
    public void insert(Detalle_accidente detalles) throws Exception {
        String sql = "INSERT INTO `detalle_accidente` (`n_accidente`, `detalles`, `costo`, `ci_control`) VALUES ( ?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, detalles.getN_acc());
            ps.setString(2, detalles.getDetalle());
            ps.setDouble(3, detalles.getCosto());
            ps.setInt(4, detalles.getCi());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al registrar" + e);
        }

    }

    @Override
    public void update(Detalle_accidente detalles) throws Exception {
        String sql ="UPDATE `detalle_accidente` SET `detalles` = ?, `costo` = ?, `ci_control` = ? WHERE `detalle_accidente`.`n` = ?";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, detalles.getDetalle());
            ps.setDouble(2, detalles.getCosto());
            ps.setInt(3, detalles.getCi());
            ps.setInt(4, detalles.getN());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al registrar" +e);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Detalle_accidente getById(int id) throws Exception {
        Detalle_accidente de = new Detalle_accidente();
        String sql = "SELECT * FROM `detalle_accidente` where n =?";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                de.setCosto(rs.getDouble("costo"));
                de.setDetalle(rs.getString("detalles"));
                de.setN(rs.getInt("n"));
                de.setN_acc(rs.getInt("n_accidente"));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar detalles" + e);
        }

        return de;
    }

    @Override
    public List<Detalle_accidente> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Detalle_accidente> getdetalleRegistro(Detalle_accidente detalle) throws Exception {
        List<Detalle_accidente> lista = null;
        lista = new ArrayList<Detalle_accidente>();
        String sql = "SELECT * FROM `detalle_accidente` where n_accidente =?";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, detalle.getN_acc());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Detalle_accidente de = new Detalle_accidente();
                de.setCosto(rs.getDouble("costo"));
                de.setDetalle(rs.getString("detalles"));
                de.setN(rs.getInt("n"));
                de.setN_acc(rs.getInt("n_accidente"));
                lista.add(de);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar detalles" + e);
        }

        return lista;
    }

}
