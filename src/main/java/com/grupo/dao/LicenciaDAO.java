package com.grupo.dao;

import com.grupo.modelo.Licencia;
import java.util.List;


public interface LicenciaDAO {
    public List<Licencia> findAllUsuarios() throws Exception;

    public Licencia findUsuarioById(Licencia licencia)throws Exception;

    public void insertUsuario(Licencia licencia)throws Exception;

    public void updateUsuario(Licencia licencia)throws Exception;
    
    public void deleteUsuario(Licencia licencia)throws Exception;
    
}
