/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;


import com.grupo.modelo.Detalle_accidente;
import java.util.List;

/**
 *
 * @author juans
 */
public interface DetalleAccidenteDAO {
    public void insert(Detalle_accidente detalles) throws Exception;

    public void update(Detalle_accidente detalles) throws Exception;

    public void delete(int id) throws Exception;

    public Detalle_accidente getById(int id) throws Exception;

    public List<Detalle_accidente> getAll() throws Exception;
    public List<Detalle_accidente>  getdetalleRegistro(Detalle_accidente detalle) throws Exception;
}
