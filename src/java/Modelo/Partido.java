/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author eledi
 */
public class Partido {
    
    private String denominacion;
    private String siglas;
    private String logo;
    private int votos;
    private int escaños;
    
    public Partido(){
        
    }

    public Partido(String denominacion, String siglas,int votos, int escaños) {
        this.denominacion = denominacion;
        this.siglas = siglas;
        this.votos = votos;
        this.escaños = escaños;
    }
    

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getEscaños() {
        return escaños;
    }

    public void setEscaños(int escaños) {
        this.escaños = escaños;
    }

    @Override
    public String toString() {
        return "Partido{" + "denominacion=" + denominacion + ", siglas=" + siglas + ", logo=" + logo + ", votos=" + votos + ", esca\u00f1os=" + escaños + '}';
    }
    
    
    
}
