package com.mx.EmpresaEmpleado.Dominio;


import jakarta.persistence.*;

@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @Column(name = "IDROL")
    private Integer idRol;

    @Column(name = "NOMBRE")
    private String nombre;

    public Rol() {
    }

    public Rol(Integer idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Rol [idRol=" + idRol + ", nombre=" + nombre + "]";
    }

    // Getters y Setters
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}