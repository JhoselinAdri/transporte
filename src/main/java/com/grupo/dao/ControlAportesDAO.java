/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Control_aportes;
import java.util.List;

/**
 *
 * @author juans
 */
public interface ControlAportesDAO {
    public void insert(Control_aportes controlaportes) throws Exception;

    public void update(Control_aportes controlaportes) throws Exception;

    public void delete(int id) throws Exception;

    public Control_aportes getById(int id) throws Exception;
    public Control_aportes login (Control_aportes aportes) throws Exception;
public Control_aportes loginver (Control_aportes aportes) throws Exception;
    public List<Control_aportes> getAll() throws Exception;
    
    public Control_aportes veripass(Control_aportes ca) throws Exception;
    public void updatePass(Control_aportes controlaportes)throws Exception;
    public void updatedelete(Control_aportes controlaportes)throws Exception;
    public void updatehabil(Control_aportes controlaportes)throws Exception;
}
