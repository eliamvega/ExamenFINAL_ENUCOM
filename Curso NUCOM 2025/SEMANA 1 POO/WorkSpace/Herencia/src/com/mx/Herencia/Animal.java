package com.mx.Herencia;

public class Animal {

	
	protected String especie;
	protected String habitat;
	protected double peso;
	protected int edad;
	protected double tamaño;
	
	public Animal() {
		
	}
	public void sonido () {
		System.out.println("EL SONIDO DEL ANIMAL.");
	}

	public Animal(String especie, String habitat, double peso, int edad, double tamaño) {
		super();
		this.especie = especie;
		this.habitat = habitat;
		this.peso = peso;
		this.edad = edad;
		this.tamaño = tamaño;
	}

	@Override
	public String toString() {
		return "Animal [especie=" + especie + ", habitat=" + habitat + ", peso=" + peso + ", edad=" + edad + ", tamaño="
				+ tamaño + "]";
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getTamaño() {
		return tamaño;
	}

	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}
	
}
