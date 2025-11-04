package com.mx.Desarrolladora.Dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "DESARROLLADORA")
public class Desarrolladora {

    @Id
    @Column(name = "ID_DESARROLLADORA")
    private Integer idDesarrolladora;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "PAIS", nullable = false, length = 100)
    private String pais;

    // Constructor vacío
    public Desarrolladora() {
    }

    // Constructor con parámetros
    public Desarrolladora(Integer idDesarrolladora, String nombre, String pais) {
        this.idDesarrolladora = idDesarrolladora;
        this.nombre = nombre;
        this.pais = pais;
    }

    // Getters y setters
    public Integer getIdDesarrolladora() {
        return idDesarrolladora;
    }

    public void setIdDesarrolladora(Integer idDesarrolladora) {
        this.idDesarrolladora = idDesarrolladora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
