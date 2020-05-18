package com.example.misionservi.model;

import java.util.List;

public class Encuesta {
    private String numeroDocumento;
    private String nombre;
    private List<EncuestaBody> encuesta;

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EncuestaBody> getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(List<EncuestaBody> encuesta) {
        this.encuesta = encuesta;
    }
}
