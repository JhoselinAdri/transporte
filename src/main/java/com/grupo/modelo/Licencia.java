package com.grupo.modelo;

import java.util.Date;

public class Licencia {
    private int id_licencia;
    private String categoria;
    private Date fecha_exp;

    public int getId_licencia() {
        return id_licencia;
    }

    public void setId_licencia(int id_licencia) {
        this.id_licencia = id_licencia;
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

    public Licencia(int id_licencia, String categoria, Date fecha_exp) {
        this.id_licencia = id_licencia;
        this.categoria = categoria;
        this.fecha_exp = fecha_exp;
    }

    public Licencia() {
    }
}
