package com.grupo.dao;

import com.grupo.modelo.Chofer;
import com.grupo.modelo.Licencia;
import com.grupo.modelo.Vehiculo;
import com.grupo.utils.ConexionDB;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juans
 */
public class ChoferDAOimpl extends ConexionDB implements ChoferDAO {

    @Override
    public List<Chofer> findAllUsuarios() throws Exception {
        String sql = "SELECT * FROM chofer;";
        List<Chofer> lista = null;
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            lista = new ArrayList<Chofer>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Chofer chofer = new Chofer();
                chofer.setCi(rs.getInt("ci"));
                chofer.setNombre(rs.getString("nombre"));
                chofer.setApp(rs.getString("app"));
                chofer.setApm(rs.getString("apm"));
                chofer.setN_celular(rs.getString("n_celular"));
                chofer.setEstado(rs.getString("estado"));
                chofer.setLicencia(rs.getInt("licencia_id"));
                chofer.setUsername(rs.getString("username"));
                lista.add(chofer);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR: " + e.getMessage());
        } finally {

        }
        return lista;

    }

    @Override
    public Chofer findUsuarioById(Chofer chofer) throws Exception {
        Chofer choferr = new Chofer();
        String sql = "SELECT * FROM chofer WHERE ci = ?;";
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, chofer.getCi());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                choferr.setCi(rs.getInt("ci"));
                choferr.setNombre(rs.getString("nombre"));
                choferr.setApp(rs.getString("app"));
                choferr.setApm(rs.getString("apm"));
                choferr.setN_celular(rs.getString("n_celular"));
                choferr.setLicencia(rs.getInt("licencia_id"));
                choferr.setUsername(rs.getString("username"));
                choferr.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());
        } finally {

        }
        return choferr;
    }

    @Override
    public Chofer loginChofer(Chofer chofer) throws Exception {
        Chofer choferr = new Chofer();
        String sql = "SELECT * FROM chofer WHERE username = ? and password = PASSWORD(?) and estado='activo';";
        System.out.println(chofer.getUsername() + chofer.getPassword());
        this.conectar();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, chofer.getUsername());
            System.out.println(chofer.getUsername() + chofer.getPassword());
            ps.setString(2, chofer.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                choferr.setCi(rs.getInt("ci"));
                choferr.setNombre(rs.getString("nombre"));
                choferr.setApp(rs.getString("app"));
                choferr.setApm(rs.getString("apm"));
                choferr.setN_celular(rs.getString("n_celular"));
                choferr.setLicencia(rs.getInt("licencia_id"));
                choferr.setUsername(rs.getString("username"));
                choferr.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR: " + e.getMessage());

        }
        return choferr;
    }

    @Override
public void insertUsuario(Chofer chofer, Licencia licencia,Vehiculo vehiculo) throws Exception {
    this.conn.setAutoCommit(false);
    String sql1 = "INSERT INTO `licencia` (`id_licencia`, `categoria`, `fecha_exp`) VALUES (?, ?, ?)";
    PreparedStatement ps1 = this.conn.prepareStatement(sql1);
    ps1.setInt(1, licencia.getId_licencia());
    ps1.setString(2, licencia.getCategoria());
    Date fecha = licencia.getFecha_exp();
    ps1.setDate(3, new java.sql.Date(fecha.getTime()));
    
    ps1.executeUpdate();
    String sql = "INSERT INTO `chofer` (`ci`, `nombre`, `app`, `apm`, `n_celular`, `licencia_id`, `username`, `password`,`estado`) VALUES (?, ?, ?, ?, ?, ?, ?, PASSWORD(?),'activo');";
    String sql3="INSERT INTO `vehiculo` (`placa`, `modelo`, `marca`, `estado`, `tipo`, `capacidad`, `ci_conductor`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, chofer.getCi());
        ps.setString(2, chofer.getNombre());
        ps.setString(3, chofer.getApp());
        ps.setString(4, chofer.getApm());
        ps.setString(5, chofer.getN_celular());
        ps.setInt(6, licencia.getId_licencia());
        ps.setString(7, chofer.getUsername());
        ps.setString(8, chofer.getPassword());

        ps.executeUpdate();
        
        PreparedStatement ps3 = this.conn.prepareStatement(sql3);
        ps3.setString(1, vehiculo.getPlaca());
        ps3.setString(2, vehiculo.getModelo());
        ps3.setString(3, vehiculo.getMarca());
        ps3.setString(4, vehiculo.getEstado());
        ps3.setString(5, vehiculo.getTipo());
        ps3.setInt(6, vehiculo.getCapacidad());
        ps3.setInt(7, licencia.getId_licencia());
        
        ps3.executeUpdate();
        this.conn.commit();
    } catch (Exception e) {
        System.out.println("Error al insertar chofer desde DAO: " + e.getMessage());
    }
}


    @Override
    public void updateUsuario(Chofer chofer, Licencia licencia,Vehiculo vehiculo) throws Exception {
        this.conn.setAutoCommit(false);
    String sql1 = "UPDATE `licencia` SET  `categoria` = ?, `fecha_exp` = ? WHERE `licencia`.`id_licencia` = ?";
    PreparedStatement ps1 = this.conn.prepareStatement(sql1);
    
    ps1.setString(1, licencia.getCategoria());
    Date fecha = licencia.getFecha_exp();
    ps1.setDate(2, new java.sql.Date(fecha.getTime()));
    ps1.setInt(3, licencia.getId_licencia());
    
    ps1.executeUpdate();
    String sql = "UPDATE `chofer` SET  `nombre` = ?, `app` = ?, `apm` = ?,`n_celular` = ? WHERE `chofer`.`ci` = ?";
    String sql3="UPDATE `vehiculo` SET `modelo` = ?, `marca` = ?, `estado` = ?, `tipo` = ?, `capacidad` = ? WHERE `vehiculo`.`placa` = ?";
    try {
        PreparedStatement ps = this.conn.prepareStatement(sql);
        
        ps.setString(1, chofer.getNombre());
        ps.setString(2, chofer.getApp());
        ps.setString(3, chofer.getApm());
        ps.setString(4, chofer.getN_celular());
        
        ps.setInt(5, chofer.getCi());
        
        ps.executeUpdate();
        
        PreparedStatement ps3 = this.conn.prepareStatement(sql3);
        
        ps3.setString(1, vehiculo.getModelo());
        ps3.setString(2, vehiculo.getMarca());
        ps3.setString(3, vehiculo.getEstado());
        ps3.setString(4, vehiculo.getTipo());
        ps3.setInt(5, vehiculo.getCapacidad());
        ps3.setString(6, vehiculo.getPlaca());
        
        ps3.executeUpdate();
        this.conn.commit();
    } catch (Exception e) {
        System.out.println("Error al actualizar chofer desde DAO: " + e.getMessage());
    }
    }

    //@Override
    //public void deleteUsuario(Chofer chofer) throws Exception {
    //}

    @Override
    public void updatePass(Chofer chofer) throws Exception {
        String sql = "UPDATE `chofer` SET `password` = PASSWORD(?) WHERE `chofer`.`ci` = ?;";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, chofer.getPassword());
            ps.setInt(2, chofer.getCi());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al Actualizar chofer desde DAO: " + e.getMessage());
        }
    }
 @Override
    public Chofer veriPass(Chofer chofer) throws Exception {
        Chofer datos=new Chofer();
        String sql = "SELECT * FROM chofer WHERE ci = ? and password=PASSWORD(?);";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, chofer.getCi());
            ps.setString(2, chofer.getPassword());
            

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {

                datos.setCi(rs.getInt("ci"));
                datos.setNombre(rs.getString("nombre"));
                datos.setApp(rs.getString("app"));
                datos.setApm(rs.getString("apm"));
                datos.setN_celular(rs.getString("n_celular"));
                datos.setLicencia(rs.getInt("licencia_id"));
                datos.setUsername(rs.getString("username"));
                datos.setEstado(rs.getString("estado"));
            }

        } catch (Exception e) {
            System.out.println("Error al buscar contraseña chofer desde DAO: " + e.getMessage());
        }
        return datos;
    }
    @Override
    public void updatedelete(Chofer chofer) throws Exception {
        String sql = "UPDATE `chofer` SET `estado` = 'inactivo' WHERE `chofer`.`ci` = ?;";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, chofer.getCi());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al desabilitar chofer desde DAO: " + e.getMessage());
        }
    }

    @Override
    public void updatehabil(Chofer chofer) throws Exception {
        String sql = "UPDATE `chofer` SET `estado` = 'activo' WHERE `chofer`.`ci` = ?;";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, chofer.getCi());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al habilitar chofer desde DAO: " + e.getMessage());
        }
    }
}
