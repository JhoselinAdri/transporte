package com.grupo.modelo;

public class Admin {
    private int ci;
    private String nombre;
    private String app;
    private String apm;
    private String celular;
    private String direccion;
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(int ci, String nombre, String app, String apm, String celular, String direccion, String username, String password) {
        this.ci = ci;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.celular = celular;
        this.direccion = direccion;
        this.username = username;
        this.password = password;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    
}
