/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo;

import java.io.InputStream;

/**
 *
 * @author juans
 */
public class Avisos {
    private int n;
    private int tipo;
    private String descripcion;
    private int ci_emisor;
    private String nombre;
    private String destino;
    private String dato;
    private String estado;

    public Avisos() {
    }

    public Avisos(int n, int tipo, String descripcion, int ci_emisor, String nombre, String destino,String dato) {
        this.n = n;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.ci_emisor = ci_emisor;
        this.nombre=nombre;
        this.destino= destino;
        this.dato=dato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCi_emisor() {
        return ci_emisor;
    }

    public void setCi_emisor(int ci_emisor) {
        this.ci_emisor = ci_emisor;
    }
    
    
}
