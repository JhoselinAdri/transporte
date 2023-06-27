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
public class VistaAC {

    private int ci;
    private String nombre;
    private String app;
    private String apm;
    private String n_celular;
    private int ci_a;
    private int n_aporte;
    private String nombre_aporte;
    private String app_aportes;
    private String apm_aportes;
    private double monto;
    private Date fecha;
    private int ci_chofer;
    private int ci_aportes;
    private String concepto;
    private String sector;
    private int grupo;
    private String placa;

    public VistaAC() {
    }

    public int getN_aporte() {
        return n_aporte;
    }

    public void setN_aporte(int n_aporte) {
        this.n_aporte = n_aporte;
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

    public String getN_celular() {
        return n_celular;
    }

    public void setN_celular(String n_celular) {
        this.n_celular = n_celular;
    }

    public int getCi_a() {
        return ci_a;
    }

    public void setCi_a(int ci_a) {
        this.ci_a = ci_a;
    }

    public String getNombre_aporte() {
        return nombre_aporte;
    }

    public void setNombre_aporte(String nombre_aporte) {
        this.nombre_aporte = nombre_aporte;
    }

    public String getApp_aportes() {
        return app_aportes;
    }

    public void setApp_aportes(String app_aportes) {
        this.app_aportes = app_aportes;
    }

    public String getApm_aportes() {
        return apm_aportes;
    }

    public void setApm_aportes(String apm_aportes) {
        this.apm_aportes = apm_aportes;
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

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public VistaAC(int ci, String nombre, String app, String apm, String n_celular, int ci_a, String nombre_aporte, String app_aportes, String apm_aportes, double monto, Date fecha, int ci_chofer, int ci_aportes, String concepto, String sector, int grupo, String placa, int n_aporte) {
        this.ci = ci;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.n_celular = n_celular;
        this.ci_a = ci_a;
        this.n_aporte = n_aporte;
        this.nombre_aporte = nombre_aporte;
        this.app_aportes = app_aportes;
        this.apm_aportes = apm_aportes;
        this.monto = monto;
        this.fecha = fecha;
        this.ci_chofer = ci_chofer;
        this.ci_aportes = ci_aportes;
        this.concepto = concepto;
        this.sector = sector;
        this.grupo = grupo;
        this.placa = placa;
    }
}
