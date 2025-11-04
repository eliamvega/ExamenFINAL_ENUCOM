package com.mx.Entidad;

public class Ropa {
	private int codigo;
	private String nombre;
	private String marca;
	private int stock;
	private double precio;
	public Ropa() {
		super();
	}
	public Ropa(int codigo, String nombre, String marca, int stock, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.stock = stock;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Ropa [codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", stock=" + stock + ", precio="
				+ precio + "]\n";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
