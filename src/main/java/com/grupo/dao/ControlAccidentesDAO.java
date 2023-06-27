/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;


import com.grupo.modelo.Control_accidentes;
import java.util.List;

/**
 *
 * @author juans
 */
public interface ControlAccidentesDAO {
    public void insert(Control_accidentes accidentes) throws Exception;

    public void update(Control_accidentes accidentes) throws Exception;

    public void delete(int id) throws Exception;

    public Control_accidentes getById(int id) throws Exception;

    public List<Control_accidentes> getAll() throws Exception;
    public Control_accidentes veripass(Control_accidentes ca) throws Exception;
    public void updatePass(Control_accidentes accidentes)throws Exception;
    public void updatedelete(Control_accidentes accidentes)throws Exception;
    public void updatehabil(Control_accidentes accidentes)throws Exception;
}
