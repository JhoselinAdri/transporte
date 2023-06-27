/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao;

import com.grupo.modelo.Admin;
import java.util.List;

public interface AdminDAO {
        public void insert(Admin admin) throws Exception;

    public void update(Admin admin) throws Exception;

    public void delete(int id) throws Exception;

    public Admin getById(int id) throws Exception;

    public List<Admin> getAll() throws Exception;
    
    public Admin Login(Admin admin) throws Exception;
    
    public Admin veripass(Admin ca) throws Exception;
    public void updatePass(Admin accidentes)throws Exception;
}
