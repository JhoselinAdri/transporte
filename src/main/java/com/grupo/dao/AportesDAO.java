/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Aportes;
import java.util.List;

/**
 *
 * @author juans
 */
public interface AportesDAO {
    public void insert(Aportes aporte) throws Exception;

    public void update(Aportes aporte) throws Exception;

    public void delete(int id) throws Exception;

    public Aportes getById(int id) throws Exception;

    public List<Aportes> getAll() throws Exception;
}
