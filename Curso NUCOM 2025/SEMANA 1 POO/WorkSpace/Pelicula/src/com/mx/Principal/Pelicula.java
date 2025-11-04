package com.mx.Principal;

public class Pelicula {

	//ATRIBUTOS 
	
	private String nombre;
	private String categoria;
	private String lenguaje;
	private String duracion;
	private Double precio;
	private String fecha;
	
	//CONSTRUCTORES 
	
	public Pelicula () {
		
		
	}

	public Pelicula(String nombre, String categoria, String lenguaje, String duracion, Double precio, String fecha) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.lenguaje = lenguaje;
		this.duracion = duracion;
		this.precio = precio;
		this.fecha = fecha;
		
		
	}

	//mostrar el objeto en formato cadena
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", categoria=" + categoria + ", lenguaje=" + lenguaje + ", duracion="
				+ duracion + ", precio=" + precio + ", fecha=" + fecha + "]\n";
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
} //CIERRE PRINCIPAL
