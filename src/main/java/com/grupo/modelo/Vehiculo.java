/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.modelo;

/**
 *
 * @author juans
 */
public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int capacidad;
    private int ci_conductor;
    private String estado;
    private String tipo;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String modelo, String marca, int capacidad, int ci_conductor, String estado,String tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidad = capacidad;
        this.ci_conductor = ci_conductor;
        this.estado = estado;
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
