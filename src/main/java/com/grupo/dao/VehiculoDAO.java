/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Vehiculo;
import java.util.List;

/**
 *
 * @author juans
 */
public interface VehiculoDAO {
    public void insert(Vehiculo vehiculo) throws Exception;

    public void update(Vehiculo vehiculo) throws Exception;

    public void delete(int id) throws Exception;

    public Vehiculo getById(String id) throws Exception;

    public List<Vehiculo> getAll() throws Exception;
}
