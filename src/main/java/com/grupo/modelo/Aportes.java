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
public class Aportes {
    private int n;
    private double monto;
    private Date fecha;
    private int ci_chofer;
    private int ci_aportes;
    private String concepto;
    private String sector;
    private String grupo;
    private String placa_vehiculo;

    public Aportes() {
    }

    public Aportes(int n, double monto, Date fecha, int ci_chofer, int ci_aportes, String concepto, String sector, String grupo, String placa_vehiculo) {
        this.n = n;
        this.monto = monto;
        this.fecha = fecha;
        this.ci_chofer = ci_chofer;
        this.ci_aportes = ci_aportes;
        this.concepto = concepto;
        this.sector = sector;
        this.grupo = grupo;
        this.placa_vehiculo = placa_vehiculo;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCi_chofer() {
        return ci_chofer;
    }

    public void setCi_chofer(int ci_chofer) {
        this.ci_chofer = ci_chofer;
    }

    public int getCi_aportes() {
        return ci_aportes;
    }

    public void setCi_aportes(int ci_aportes) {
        this.ci_aportes = ci_aportes;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPlaca_vehiculo() {
        return placa_vehiculo;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }
    
    
}
