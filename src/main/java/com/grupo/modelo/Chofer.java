package com.grupo.modelo;
public class Chofer {
    private int ci;
    private String nombre;
    private String app;
    private String apm;
    private String n_celular;
    private String password;
    private String username;
    private int licencia;
    private String estado;



    public Chofer() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Chofer(int ci, String nombre, String app, String apm, String n_celular,String password,String username,int licencia,String estado) {
        this.ci = ci;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.n_celular = n_celular;
        this.password = password;
        this.username= username;
        this.licencia= licencia;
        this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public String getN_celular() {
        return n_celular;
    }

    public void setN_celular(String n_celular) {
        this.n_celular = n_celular;
    }
    
}
