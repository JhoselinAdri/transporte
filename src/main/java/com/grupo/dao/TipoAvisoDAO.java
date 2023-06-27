/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Tipo_aviso;
import java.util.List;

/**
 *
 * @author juans
 */
public interface TipoAvisoDAO {
    public void insert(Tipo_aviso taviso) throws Exception;

    public void update(Tipo_aviso taviso) throws Exception;

    public void delete(int id) throws Exception;

    public Tipo_aviso getById(int id) throws Exception;

    public List<Tipo_aviso> getAll() throws Exception;
}
