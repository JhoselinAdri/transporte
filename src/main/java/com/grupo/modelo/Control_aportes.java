/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo;

/**
 *
 * @author juans
 */
public class Control_aportes {
    private int n;
    private int ci;
    private String nombre;
    private String app;
    private String apm;
    private String telefono;
    private String direccion;
    private String username;
    private String password;
    private String estado;

    public Control_aportes() {
    }

    public Control_aportes(int n, int ci, String nombre, String app, String apm, String telefono, String direccion,String username,String password) {
        this.n = n;
        this.ci = ci;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.telefono = telefono;
        this.direccion = direccion;
        this.username=username;
        this.password=password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
