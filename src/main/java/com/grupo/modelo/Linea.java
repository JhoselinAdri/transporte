/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo;

/**
 *
 * @author juans
 */
public class Linea {
    private int n_linea;
    private String salida;
    private String parada;
    private String tiempo_estimado;

    public Linea() {
    }

    public Linea(int n_linea, String salida, String parada, String tiempo_estimado) {
        this.n_linea = n_linea;
        this.salida = salida;
        this.parada = parada;
        this.tiempo_estimado = tiempo_estimado;
    }

    public int getN_linea() {
        return n_linea;
    }

    public void setN_linea(int n_linea) {
        this.n_linea = n_linea;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }

    public String getTiempo_estimado() {
        return tiempo_estimado;
    }

    public void setTiempo_estimado(String tiempo_estimado) {
        this.tiempo_estimado = tiempo_estimado;
    }
    
    
}
