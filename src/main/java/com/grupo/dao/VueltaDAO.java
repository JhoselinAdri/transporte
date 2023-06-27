/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Vuelta;
import java.util.List;

/**
 *
 * @author juans
 */
public interface VueltaDAO {
    public void insert(Vuelta vuelta) throws Exception;

    public void update(Vuelta vuelta) throws Exception;

    public void delete(int id) throws Exception;

    public Vuelta getById(int ci, int linea) throws Exception;

    public List<Vuelta> getAll() throws Exception;
    
    public List<Vuelta> getAllByid(Vuelta vu) throws Exception;
    
   public List<Vuelta> getAllNoe(Vuelta vuelta, int ci) throws Exception;
}
