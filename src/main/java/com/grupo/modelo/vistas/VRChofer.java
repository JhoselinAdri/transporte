/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo.vistas;

import java.util.Date;

public class VRChofer {
    private int n_ruta;
    private Date fecha;
    private int ci_chofer;
    private int ci;
    private int linea;
    private String nombre;
    private String app;
    private String apm;
    private String celular;
    private int licencia;

    public VRChofer() {
    }

    public VRChofer(int linea,int n_ruta, Date fecha, int ci_chofer, int ci, String Nombre, String app, String apm, String celular, int licencia) {
        this.n_ruta = n_ruta;
        this.fecha = fecha;
        this.ci_chofer = ci_chofer;
        this.ci = ci;
        this.nombre = Nombre;
        this.app = app;
        this.apm = apm;
        this.celular = celular;
        this.licencia = licencia;
        this.linea=linea;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getN_ruta() {
        return n_ruta;
    }

    public void setN_ruta(int n_ruta) {
        this.n_ruta = n_ruta;
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

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }
    
}
