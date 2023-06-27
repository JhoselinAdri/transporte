package com.grupo.modelo.vistas;

import java.util.Date;


public class VistaACD {
    private int numero;
    private String placa;
    private int ci;
    private String concepto;
    private String detalle;
    private String ubicacion;
    private Date fecha;

    public VistaACD() {
    }

    public VistaACD(int numero, String placa, int ci, String concepto, String detalle, String ubicacion, Date fecha) {
        this.numero = numero;
        this.placa = placa;
        this.ci = ci;
        this.concepto = concepto;
        this.detalle = detalle;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
