package com.mx.Entidad;

public class Fruta {

	private String nombre;
	private String color;
	private String temporada;
	private Double stock;
	private Double precio;
	
	public Fruta() {
		
	}

	public Fruta(String nombre, String color, String temporada, Double stock, Double precio) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.temporada = temporada;
		this.stock = stock;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Fruta [nombre=" + nombre + ", color=" + color + ", temporada=" + temporada + ", stock=" + stock
				+ ", precio=" + precio + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public Double getStock() {
		return stock;
	}

	public void setStock(Double stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
