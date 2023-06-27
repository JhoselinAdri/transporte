package com.grupo.dao;

import com.grupo.modelo.Control_accidentes;
import java.util.List;

/**
 *
 * @author juans
 */
public interface CAccidenteDAO {

    public List<Control_accidentes> findAllUsuarios() throws Exception;

    public Control_accidentes findUsuarioById(Control_accidentes accidentes) throws Exception;

    public Control_accidentes loginChofer(Control_accidentes accidentes) throws Exception;

    public Control_accidentes loginChoferVer(Control_accidentes accidentes) throws Exception;

    public void insertUsuario(Control_accidentes accidentes) throws Exception;

    public void updateUsuario(Control_accidentes accidentes) throws Exception;

    //public void deleteUsuario(Chofer chofer)throws Exception;
}
