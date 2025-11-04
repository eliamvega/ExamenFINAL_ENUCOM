package com.mx.Herencia;

public class Perro extends Animal {

	private String raza;
	private String nombre;
	 
	
	public Perro() {
		
	}
public void sonido() {
	System.out.println("gua gua");
}

	public Perro(String especie, String habitat, double peso, int edad, double tamaño, String raza, String nombre) {
		super(especie, habitat, peso, edad, tamaño);
		this.raza = raza;
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Perro [especie=" + especie + ", habitat=" + habitat + ", peso=" + peso + ", edad=" + edad + ", tamaño="
				+ tamaño + ", raza=" + raza + ", nombre=" + nombre + "]";
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
