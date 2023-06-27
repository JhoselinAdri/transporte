/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Linea;
import java.util.List;

/**
 *
 * @author juans
 */
public interface LineaDAO {
    public void insert(Linea linea) throws Exception;

    public void update(Linea linea) throws Exception;

    public void delete(int id) throws Exception;

    public Linea getById(int id) throws Exception;

    public List<Linea> getAll() throws Exception;
}
