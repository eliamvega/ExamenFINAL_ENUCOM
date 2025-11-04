package com.mx.Videojuego;

public class Videojuego {
 
	private String nombre;
	private String genero;
	private String compañia;
	private int estreno;
	private Double precio;
	
	
	public Videojuego () {
		
	}

	public Videojuego(String nombre, String genero, String compañia, int estreno, Double precio) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.compañia = compañia;
		this.precio = precio;
		this.estreno = estreno;
	}

	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", genero=" + genero + ", compañia=" + compañia + ", precio=" + precio
				+ ", estreno=" + estreno + "]\n";
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

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getEstreno() {
		return estreno;
	}

	public void setEstreno(int estreno) {
		this.estreno = estreno;
	}
	
	
	
}
