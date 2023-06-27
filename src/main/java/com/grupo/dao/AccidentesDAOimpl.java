package com.grupo.dao;

import com.grupo.dao.AccidentesDAO;
import com.grupo.modelo.Accidentes;
import com.grupo.modelo.Detalle_accidente;
import com.grupo.utils.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class AccidentesDAOimpl extends ConexionDB implements AccidentesDAO {

    @Override
    public void insert(Accidentes accidente, Detalle_accidente daccidente) throws Exception {
        this.conectar();
        try {
            this.conn.setAutoCommit(false);
            String sql = "INSERT INTO `control_accidentes` (`placa`, `ci_chofer`,`observaciones`, `fecha`, `direccion` ,`ci_reg`) VALUES (?, ?, ?, CURDATE(), ?,?);";
            PreparedStatement ps = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, accidente.getPlaca());
            ps.setInt(2, accidente.getCi());
            ps.setString(3, accidente.getObservaciones());
            ps.setString(4, accidente.getDireccion());
            ps.setInt(5, accidente.getCi_reg());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idPrincipal = 0;
            if (generatedKeys.next()) {
                idPrincipal = generatedKeys.getInt(1);
            }

            String sql1 = "INSERT INTO `detalle_accidente` (`n_accidente`, `detalles`, `costo`, `ci_control`) VALUES (?,?,?,?)";
            PreparedStatement ps1 = this.conn.prepareStatement(sql1);
            ps1.setInt(1, idPrincipal);
            ps1.setString(2, daccidente.getDetalle());
            ps1.setDouble(3, daccidente.getCosto());
            ps1.setInt(4, 1);
            ps1.executeUpdate();

            this.conn.commit();
        } catch (Exception e) {
            System.out.println("Error al Insertar datos del accidente " + e);
        }
    }

    @Override
    public void update(Accidentes accidente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Accidentes getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Accidentes> getAll() throws Exception {
        List<Accidentes> acc = null;
        acc =new ArrayList<Accidentes>();
        String sql= "SELECT * FROM `control_accidentes` ORDER BY n_accidente DESC";
        try {
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Accidentes a= new Accidentes();
                a.setCi(rs.getInt("ci_chofer"));
                a.setCi_reg(rs.getInt("ci_reg"));
                a.setFecha(rs.getDate("fecha"));
                a.setDireccion(rs.getString("direccion"));
                a.setN_accidente(rs.getInt("n_accidente"));
                a.setObservaciones(rs.getString("observaciones"));
                a.setPlaca(rs.getString("placa"));
                acc.add(a);
                
            }
        } catch (Exception e) {
            System.out.println("Error al busscar"+e);
        }
        return acc;
         }

    @Override
    public void insertcontrol(Accidentes accidente, Detalle_accidente daccidente) throws Exception {
                this.conectar();
        try {
            this.conn.setAutoCommit(false);
            String sql = "INSERT INTO `control_accidentes` (`placa`, `ci_chofer`,`observaciones`, `fecha`, `direccion` ,`ci_reg`) VALUES (?, ?, ?, CURDATE(), ?,?);";
            PreparedStatement ps = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, accidente.getPlaca());
            ps.setInt(2, accidente.getCi());
            ps.setString(3, accidente.getObservaciones());
            ps.setString(4, accidente.getDireccion());
            ps.setInt(5, accidente.getCi_reg());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int idPrincipal = 0;
            if (generatedKeys.next()) {
                idPrincipal = generatedKeys.getInt(1);
            }

            String sql1 = "INSERT INTO `detalle_accidente` (`n_accidente`, `detalles`, `costo`, `ci_control`) VALUES (?,?,?,?)";
            PreparedStatement ps1 = this.conn.prepareStatement(sql1);
            ps1.setInt(1, idPrincipal);
            ps1.setString(2, daccidente.getDetalle());
            ps1.setDouble(3, daccidente.getCosto());
            ps1.setInt(4, accidente.getCi_reg());
            ps1.executeUpdate();

            this.conn.commit();
        } catch (Exception e) {
            System.out.println("Error al Insertar datos del accidente " + e);
        }
    }

}
