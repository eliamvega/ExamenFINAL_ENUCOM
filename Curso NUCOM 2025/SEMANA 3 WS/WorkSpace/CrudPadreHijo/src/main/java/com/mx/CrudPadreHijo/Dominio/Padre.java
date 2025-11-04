package com.mx.CrudPadreHijo.Dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PADRE")
public class Padre {
	
	@Id
	@Column
	private int idPadre;
	
	@Column 
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private int edad;
	
	@Column
	private String trabajo;
	
	@OneToMany(mappedBy = "padreId", cascade = CascadeType.ALL)
	List<Hijo> lista = new ArrayList<>();

	public Padre() {
		
	}


	public Padre(int idPadre, String nombre, String apellido, int edad, String trabajo, List<Hijo> lista) {
		super();
		this.idPadre = idPadre;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.trabajo = trabajo;
		this.lista = lista;
	}



	@Override
	public String toString() {
		return "Padre [idPadre=" + idPadre + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", trabajo=" + trabajo + ", lista=" + lista + "]\n";
	}


	public int getIdPadre() {
		return idPadre;
	}


	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	
	
}
