/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Avisos;
import java.util.List;

/**
 *
 * @author juans
 */
public interface AvisosDAO {
    public void insert(Avisos avisos) throws Exception;

    public void update(Avisos avisos) throws Exception;

    public void delete(int id) throws Exception;

    public Avisos getById(int id) throws Exception;

    public List<Avisos> getAll() throws Exception;
    public List<Avisos> getAllChofer() throws Exception;
    public List<Avisos> getAllAportes() throws Exception;
    public List<Avisos> getAllAccidentes() throws Exception;
    public List<Avisos> getAllParada() throws Exception;
    public List<Avisos> getAllTodos() throws Exception;
    
    
    
}
