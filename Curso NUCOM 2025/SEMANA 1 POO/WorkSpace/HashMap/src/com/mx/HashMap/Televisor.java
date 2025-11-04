package com.mx.HashMap;

public class Televisor {

	private String modelo; //clave String es una clase contenedora por defecto
	private String marca;
	private int pulgadas;//INTEGER
	private String tipo;
	private double precio;// Double, boolean ------> Boolean
	
	public Televisor() {
		
	}
	public Televisor(String modelo) {
		this.modelo = modelo;
	}

	public Televisor(String modelo, String marca, int pulgadas, String tipo, double precio) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.pulgadas = pulgadas;
		this.tipo = tipo;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Televisor [modelo=" + modelo + ", marca=" + marca + ", pulgadas=" + pulgadas + ", tipo=" + tipo
				+ ", precio=" + precio + "]\n";
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

}
