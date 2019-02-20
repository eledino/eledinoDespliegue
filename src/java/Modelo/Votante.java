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
public class Votante {
    
    private String nif;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private LocalDate fechaNac;
    private String rol;
    private String password;
    private String votado;

    public Votante() {
    }

    
    public Votante(String nif, String nombre, String apellidos, String domicilio, LocalDate fechaNac, String rol, String password,String votado) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.rol = rol;
        this.password = password;
        this.votado = votado;
    }

      public Votante(String nif, String nombre, String apellidos, String domicilio, LocalDate fechaNac, String rol, String password) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.rol = rol;
        this.password = password;
      
    }

    public Votante(String nif, String nombre, String apellidos, String domicilio, LocalDate fechaNac, String password) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.password = password;
    }
      
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVotado() {
        return votado;
    }

    public void setVotado(String votado) {
        this.votado = votado;
    }

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
