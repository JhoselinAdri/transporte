
package com.grupo.modelo;

import java.util.Date;


public class Ruta {
    private int n_ruta;
    private Date fecha;
    private int linea;
    private int ci_chofer;

    public Ruta() {
    }

    public Ruta(int n_ruta, Date fecha, int linea, int ci_chofer) {
        this.n_ruta = n_ruta;
        this.fecha = fecha;
        this.linea = linea;
        this.ci_chofer = ci_chofer;
    }

    public int getN_ruta() {
        return n_ruta;
    }

    public void setN_ruta(int n_ruta) {
        this.n_ruta = n_ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getCi_chofer() {
        return ci_chofer;
    }

    public void setCi_chofer(int ci_chofer) {
        this.ci_chofer = ci_chofer;
    }
    
    
}
