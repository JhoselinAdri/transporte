/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo;

/**
 *
 * @author juans
 */
public class Vuelta {
    private int numero;
    private int n_vueta;
    private String hora_salida;
    private String hora_llegada;
    private String observaciones;
    private int n_ruta;
    private int ci_control;

    public Vuelta() {
    }

    public Vuelta(int numero, int n_vueta, String hora_salida, String hora_llegada, String observaciones, int n_ruta,int ci_control) {
        this.numero = numero;
        this.n_vueta = n_vueta;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.observaciones = observaciones;
        this.n_ruta = n_ruta;
        this.ci_control=ci_control;
    }

    public int getCi_control() {
        return ci_control;
    }

    public void setCi_control(int ci_control) {
        this.ci_control = ci_control;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getN_vueta() {
        return n_vueta;
    }

    public void setN_vueta(int n_vueta) {
        this.n_vueta = n_vueta;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getN_ruta() {
        return n_ruta;
    }

    public void setN_ruta(int n_ruta) {
        this.n_ruta = n_ruta;
    }
    
    
}
