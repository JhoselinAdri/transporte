/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao.vista;

import com.grupo.modelo.vistas.VistaAC;
import com.grupo.modelo.vistas.VistaDCV;
import java.util.List;

/**
 *
 * @author juans
 */
public interface VCADAO {
    public List<VistaAC> ViewApoptesChofer(VistaDCV aporte) throws Exception;
    public List<VistaAC> ViewApoptes() throws Exception;
    public VistaAC getById(int id) throws Exception;
}
