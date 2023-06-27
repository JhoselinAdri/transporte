/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo.dao.vista;

import com.grupo.modelo.vistas.VistaDCV;

/**
 *
 * @author juans
 */
public interface VDCVDAO {
    public VistaDCV loginChofer(VistaDCV chofer)throws Exception;
    public VistaDCV idChofer(VistaDCV chofer)throws Exception;
    public VistaDCV idPlaca(VistaDCV chofer)throws Exception;
}
