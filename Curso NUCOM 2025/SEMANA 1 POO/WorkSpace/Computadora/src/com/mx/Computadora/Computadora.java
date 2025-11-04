package com.mx.Computadora;

public class Computadora {

private String marca;
private int modelo;
private String compañia;
private double precio;

public Computadora () {
	
}

public Computadora(String marca, int modelo, String compañia, double precio) {
	super();
	this.marca = marca;
	this.modelo = modelo;
	this.compañia = compañia;
	this.precio = precio;
}

@Override
public String toString() {
	return "Computadora [marca=" + marca + ", modelo=" + modelo + ", compañia=" + compañia + ", precio=" + precio + "]\n";
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public int getModelo() {
	return modelo;
}

public void setModelo(double modelo2) {
	this.modelo = (int) modelo2;
}

public String getCompañia() {
	return compañia;
}

public void setCompañia(String compañia) {
	this.compañia = compañia;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}


}
