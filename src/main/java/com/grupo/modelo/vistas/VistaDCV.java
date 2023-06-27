
package com.grupo.modelo.vistas;

import java.util.Date;

public class VistaDCV {
    private int ci;
    private String nombre;
    private String app;
    private String apm;
    private String n_celular;
    private int licencia_id;
    private String username;
    private String password;
    private String placa;
    private int modelo;
    private String marca;
    private String estado;
    private String tipo;
    private int capacidad;
    private int ci_conductor;
    private String categoria;
    private Date fecha_exp;

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

    public int getLicencia_id() {
        return licencia_id;
    }

    public void setLicencia_id(int licencia_id) {
        this.licencia_id = licencia_id;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCi_conductor() {
        return ci_conductor;
    }

    public void setCi_conductor(int ci_conductor) {
        this.ci_conductor = ci_conductor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFecha_exp() {
        return fecha_exp;
    }

    public void setFecha_exp(Date fecha_exp) {
        this.fecha_exp = fecha_exp;
    }

    public VistaDCV(int ci, String nombre, String app, String apm, String n_celular, int licencia_id, String username, String password, String placa, int modelo, String marca, String estado, String tipo, int capacidad, int ci_conductor, String categoria, Date fecha_exp) {
        this.ci = ci;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.n_celular = n_celular;
        this.licencia_id = licencia_id;
        this.username = username;
        this.password = password;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.estado = estado;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ci_conductor = ci_conductor;
        this.categoria = categoria;
        this.fecha_exp = fecha_exp;
    }

    public VistaDCV() {
    }
}
