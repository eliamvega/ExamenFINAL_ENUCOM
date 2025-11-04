package com.mx.Categoria.Domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @Column(name = "ID_CATEGORIA")
    private Integer idCategoria;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "GENERO", length = 50)
    private String genero;

    @Column(name = "EDAD_MINIMA")
    private Integer edadMinima;

    @Column(name = "ES_MULTIJUGADOR")
    private Integer esMultijugador;  // 1 = sí, 0 = no

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    // Constructor vacío requerido por JPA
    public Categoria() {
    }

    // Constructor con todos los campos
    public Categoria(Integer idCategoria, String nombre, String genero, Integer edadMinima, Integer esMultijugador, Date fechaCreacion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.genero = genero;
        this.edadMinima = edadMinima;
        this.esMultijugador = esMultijugador;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y setters

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Integer getEsMultijugador() {
        return esMultijugador;
    }

    public void setEsMultijugador(Integer esMultijugador) {
        this.esMultijugador = esMultijugador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + ", genero=" + genero + ", edadMinima="
				+ edadMinima + ", esMultijugador=" + esMultijugador + ", fechaCreacion=" + fechaCreacion + "]";
	}
    
    
}
