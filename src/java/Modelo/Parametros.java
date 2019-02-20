/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author eledi
 */
public class Parametros {
    
    private String circunscripcion;
    private int candidatosAElegir;
    private String tipoConsulta;
    private LocalDate fechaConsulta;
    private String escrutinioAbierto;
    private String finConsulta;

    public Parametros(String circunscripcion, int candidatosAElegir, String tipoConsulta, LocalDate fechaConsulta, String escrutinioAbierto, String finConsulta) {
        this.circunscripcion = circunscripcion;
        this.candidatosAElegir = candidatosAElegir;
        this.tipoConsulta = tipoConsulta;
        this.fechaConsulta = fechaConsulta;
        this.escrutinioAbierto = escrutinioAbierto;
        this.finConsulta = finConsulta;
    }

    public Parametros() {
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(String circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public int getCandidatosAElegir() {
        return candidatosAElegir;
    }

    public void setCandidatosAElegir(int candidatosAElegir) {
        this.candidatosAElegir = candidatosAElegir;
    }

   

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getEscrutinioAbierto() {
        return escrutinioAbierto;
    }

    public void setEscrutinioAbierto(String escrutinioAbierto) {
        this.escrutinioAbierto = escrutinioAbierto;
    }

    public String getFinConsulta() {
        return finConsulta;
    }

    public void setFinConsulta(String finConsulta) {
        this.finConsulta = finConsulta;
    }

    @Override
    public String toString() {
        return "Parametros{" + "circunscripcion=" + circunscripcion + ", candidatoElegido=" + candidatosAElegir + ", tipoConsulta=" + tipoConsulta + ", fechaConsulta=" + fechaConsulta + ", escrutinioAbierto=" + escrutinioAbierto + ", finConsulta=" + finConsulta + '}';
    }
    
    
}
