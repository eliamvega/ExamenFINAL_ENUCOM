package com.mx.Electrodomestico;

public class Electrodomestico {

	private String marca;
    private String modelo;
    private String color;
    private double voltaje;
    private double potencia; // en watts
    private double precio;
	
	 public Electrodomestico() {
		}
public Electrodomestico (String modelo) {
	this.modelo = modelo;
}
	 
	public Electrodomestico(String marca, String modelo, String color, double voltaje, double potencia, double precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.voltaje = voltaje;
		this.potencia = potencia;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Electrodomestico [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", voltaje=" + voltaje
				+ ", potencia=" + potencia + ", precio=" + precio + "]\n";
	}

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

	public double getVoltaje() {
		return voltaje;
	}

	public void setVoltaje(double voltaje) {
		this.voltaje = voltaje;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	 
	 
}
