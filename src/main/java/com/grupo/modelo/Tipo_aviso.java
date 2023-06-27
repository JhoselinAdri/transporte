/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo;

/**
 *
 * @author juans
 */
public class Tipo_aviso {
    private int n;
    private String descripcion;
    private String roles;

    public Tipo_aviso() {
    }

    public Tipo_aviso(int n, String descripcion, String roles) {
        this.n = n;
        this.descripcion = descripcion;
        this.roles = roles;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    
}
