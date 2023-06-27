/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Ruta;
import com.grupo.modelo.vistas.VRChofer;
import java.util.List;

/**
 *
 * @author juans
 */
public interface RutaDAO {
    public void insert(Ruta ruta) throws Exception;

    public void update(Ruta ruta) throws Exception;

    public void delete(int id) throws Exception;

    public VRChofer getById(int id,int linea) throws Exception;

    public List<Ruta> getAll() throws Exception;
    public List<Ruta> getAllCi( int ci) throws Exception;
}
