/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Chofer;
import com.grupo.modelo.Licencia;
import com.grupo.modelo.Vehiculo;
import java.util.List;

/**
 *
 * @author juans
 */
public interface ChoferDAO {
    public List<Chofer> findAllUsuarios() throws Exception;

    public Chofer findUsuarioById(Chofer chofer)throws Exception;

    public Chofer loginChofer(Chofer chofer)throws Exception;

    public void insertUsuario(Chofer chofer,Licencia licencia,Vehiculo vehiculo)throws Exception;

    public void updateUsuario(Chofer chofer,Licencia licencia,Vehiculo vehiculo)throws Exception;
    public void updatePass(Chofer chofer)throws Exception;
    public Chofer veriPass(Chofer chofer)throws Exception;
    public void updatedelete(Chofer chofer)throws Exception;
    public void updatehabil(Chofer chofer)throws Exception;
    

    //public void deleteUsuario(Chofer chofer)throws Exception;
    

}
