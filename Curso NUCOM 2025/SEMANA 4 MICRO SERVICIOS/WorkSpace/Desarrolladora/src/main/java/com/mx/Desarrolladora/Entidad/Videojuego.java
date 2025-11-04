package com.mx.Desarrolladora.Entidad;

public class Videojuego {

	
	private int idVideojuego;
	private String nombre;
	private int  categoriaId;
	private double precio;
	private int desarrolladoraId;
	
	
	public Videojuego() {}


	public Videojuego(int idVideojuego, String nombre, int categoriaId, double precio, int desarrolladoraId) {
		super();
		this.idVideojuego = idVideojuego;
		this.nombre = nombre;
		this.categoriaId = categoriaId;
		this.precio = precio;
		this.desarrolladoraId = desarrolladoraId;
	}


	@Override
	public String toString() {
		return "Videojuego [idVideojuego=" + idVideojuego + ", nombre=" + nombre + ", categoriaId=" + categoriaId
				+ ", precio=" + precio + ", desarrolladoraId=" + desarrolladoraId + "]";
	}


	public int getIdVideojuego() {
		return idVideojuego;
	}


	public void setIdVideojuego(int idVideojuego) {
		this.idVideojuego = idVideojuego;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCategoriaId() {
		return categoriaId;
	}


	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getDesarrolladoraId() {
		return desarrolladoraId;
	}


	public void setDesarrolladoraId(int desarrolladoraId) {
		this.desarrolladoraId = desarrolladoraId;
	}
	
	
}
