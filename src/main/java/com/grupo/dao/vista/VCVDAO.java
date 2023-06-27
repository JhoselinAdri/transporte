/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao.vista;

import com.grupo.modelo.vistas.VCV;
import com.grupo.modelo.vistas.VueltasContar;
import java.util.List;

/**
 *
 * @author juans
 */
public interface VCVDAO {
    public List<VCV> ViewAll() throws Exception;
    public List<VCV> ViewChoferAll(int ci) throws Exception;
    public List<VueltasContar> ViewGrafico() throws Exception;
    public List<VueltasContar> ViewChofer(int ci) throws Exception;
}
