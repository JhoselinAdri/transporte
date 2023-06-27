
package com.grupo.modelo.vistas;

import java.util.Date;

public class VistaApoC {
    private int ci;
    private String app;
    private String apm;
    private String n_celular;
    private int licencia_id;
    private int n_aporte;
    private double monto;
    private Date fecha;
    private int ci_chofer;
    private int ci_aportes;
    private String sector;
    private String grupo;
    private String placa;

    public VistaApoC() {
    }

    public VistaApoC(int ci, String app, String apm, String n_celular, int licencia_id, int n_aporte, double monto, Date fecha, int ci_chofer, int ci_aportes, String sector, String grupo, String placa) {
        this.ci = ci;
        this.app = app;
        this.apm = apm;
        this.n_celular = n_celular;
        this.licencia_id = licencia_id;
        this.n_aporte = n_aporte;
        this.monto = monto;
        this.fecha = fecha;
        this.ci_chofer = ci_chofer;
        this.ci_aportes = ci_aportes;
        this.sector = sector;
        this.grupo = grupo;
        this.placa = placa;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
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

    public int getLicencia_id() {
        return licencia_id;
    }

    public void setLicencia_id(int licencia_id) {
        this.licencia_id = licencia_id;
    }

    public int getN_aporte() {
        return n_aporte;
    }

    public void setN_aporte(int n_aporte) {
        this.n_aporte = n_aporte;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
