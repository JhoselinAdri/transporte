/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo;

import java.util.Date;

/**
 *
 * @author juans
 */
public class Accidentes {
    private int n_accidente;
    private String placa;
    private int ci;
    private int ci_control;
    private String observaciones;
    private Date fecha;
    private String direccion;
    private int ci_reg;

    public Accidentes() {
    }

    public Accidentes(int n_accidente, String placa, int ci, int ci_control, String observaciones, Date fecha, String direccion, int ci_reg ) {
        this.n_accidente = n_accidente;
        this.placa = placa;
        this.ci = ci;
        this.ci_control = ci_control;
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.direccion=direccion;
        this.ci_reg=ci_reg;
    }

    public int getCi_reg() {
        return ci_reg;
    }

    public void setCi_reg(int ci_reg) {
        this.ci_reg = ci_reg;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getN_accidente() {
        return n_accidente;
    }

    public void setN_accidente(int n_accidente) {
        this.n_accidente = n_accidente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getCi_control() {
        return ci_control;
    }

    public void setCi_control(int ci_control) {
        this.ci_control = ci_control;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
