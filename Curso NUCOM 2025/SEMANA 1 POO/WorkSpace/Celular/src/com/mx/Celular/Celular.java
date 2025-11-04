package com.mx.Celular;

public class Celular {

	//Atributos
	private String marca;
	private String modelo;
	private String color;
	private int almacenamiento ;
	private int ram;
	private double precio;
	
	//Constructoress 
	public Celular () {
		
	}

	public Celular(String marca, String modelo, String color, int almacenamiento,int ran, double precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Celular [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", almacenamiento="
				+ almacenamiento + "ram = " + ram +" precio=" + precio + "]\n";
	}
	//GETTER:OBTENER EL VALOR DE LOS ATRIBUTOS Y SETTER: MODIFICAR O ESTABLECER EL VALOR DE LOS ATRIBUTOS.
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAlmacenamiento() {
		return almacenamiento;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
