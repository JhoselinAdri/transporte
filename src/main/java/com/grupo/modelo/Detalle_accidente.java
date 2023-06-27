/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo;

/**
 *
 * @author juans
 */
public class Detalle_accidente {
    private int n;
    private int n_acc;
    private String detalle;
    private double costo;
    private int ci;

    public Detalle_accidente() {
    }

    public Detalle_accidente(int n, int n_acc, String detalle, double costo, int ci) {
        this.n = n;
        this.n_acc = n_acc;
        this.detalle = detalle;
        this.costo = costo;
        this.ci=ci;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN_acc() {
        return n_acc;
    }

    public void setN_acc(int n_acc) {
        this.n_acc = n_acc;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
