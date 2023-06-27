/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Control_ruta;
import java.util.List;

/**
 *
 * @author juans
 */
public interface ControlRutaDAO {

    public void insert(Control_ruta rutas) throws Exception;

    public void update(Control_ruta rutas) throws Exception;

    public void delete(int id) throws Exception;

    public Control_ruta getById(int id) throws Exception;

    public Control_ruta login(Control_ruta cr) throws Exception;

    public Control_ruta loginver(Control_ruta cr) throws Exception;
    public Control_ruta veripass(Control_ruta cr) throws Exception;
    public List<Control_ruta> getAll() throws Exception;

    public void updatePass(Control_ruta rutas) throws Exception;

    public void updatedelete(Control_ruta rutas) throws Exception;

    public void updatehabil(Control_ruta rutas) throws Exception;
}
