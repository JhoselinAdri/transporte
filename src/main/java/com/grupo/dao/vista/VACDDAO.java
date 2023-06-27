/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao.vista;

import com.grupo.modelo.vistas.VistaACD;
import com.grupo.modelo.vistas.VistaDCV;
import java.util.List;

/**
 *
 * @author juans
 */
public interface VACDDAO {
    public List<VistaACD> ViewAccidentesChofer(VistaDCV acidente) throws Exception;
    public VistaACD getById(int id) throws Exception;
}
