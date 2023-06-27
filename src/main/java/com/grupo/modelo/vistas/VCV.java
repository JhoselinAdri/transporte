/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo.vistas;

import java.util.Date;

/**
 *
 * @author juans
 */
public class VCV {
    private int n;
    private String nombre;
    private String app;
    private String apm;
    private int ci_chofer;
    private Date fecha;
    private int linea;
    private int ci_control;
    private String nombre_control;
    private String app_control;
    private String apm_control;
    private int vueltas;

    public VCV() {
    }

    public VCV(int n, String nombre, String app, String apm, int ci_chofer, Date fecha, int linea, int ci_control, String nombre_control, String app_control, String apm_control, int vueltas) {
        this.n = n;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.ci_chofer = ci_chofer;
        this.fecha = fecha;
        this.linea = linea;
        this.ci_control = ci_control;
        this.nombre_control = nombre_control;
        this.app_control = app_control;
        this.apm_control = apm_control;
        this.vueltas = vueltas;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getCi_chofer() {
        return ci_chofer;
    }

    public void setCi_chofer(int ci_chofer) {
        this.ci_chofer = ci_chofer;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getCi_control() {
        return ci_control;
    }

    public void setCi_control(int ci_control) {
        this.ci_control = ci_control;
    }

    public String getNombre_control() {
        return nombre_control;
    }

    public void setNombre_control(String nombre_control) {
        this.nombre_control = nombre_control;
    }

    public String getApp_control() {
        return app_control;
    }

    public void setApp_control(String app_control) {
        this.app_control = app_control;
    }

    public String getApm_control() {
        return apm_control;
    }

    public void setApm_control(String apm_control) {
        this.apm_control = apm_control;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }
    
    
}
