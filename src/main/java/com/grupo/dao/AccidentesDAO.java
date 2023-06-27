
package com.grupo.dao;

import com.grupo.modelo.Accidentes;
import com.grupo.modelo.Detalle_accidente;
import java.util.List;

/**
 *
 * @author juans
 */
public interface AccidentesDAO {
    public void insert(Accidentes accidente, Detalle_accidente daccidente) throws Exception;
    
    public void insertcontrol(Accidentes accidente, Detalle_accidente daccidente) throws Exception;

    public void update(Accidentes accidente) throws Exception;

    public void delete(int id) throws Exception;

    public Accidentes getById(int id) throws Exception;

    public List<Accidentes> getAll() throws Exception;
}
