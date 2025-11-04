package com.mx.Principal;

public class Gato {

	//ATRIBUTOS
	private String nombre;
	private String raza;
	private int 	edad;
	private String color;
	
	//constructor: INICIALIZAR LOS VALORES DE LOS ATRIBUTOS
	public Gato() {
		
	}
	public Gato(String nombre, String raza, int edad, String color) {
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.color = color;		
	}
	//mostrar el objeto en formato cadena
	public String toString () {
		return "Gato [nombre =" + this.nombre + ", raza =" + this.raza +", edad =" + this.edad + ", color = " + this.color + "]\n"; 
	}
	//GETTER:OBTENER EL VALOR DE LOS ATRIBUTOS Y SETTER: MODIFICAR O ESTABLECER EL VALOR DE LOS ATRIBUTOS.
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNOMBRE(String nombre) {
		this.nombre = nombre;
	}
	
	public String getRaza() {
		return this.raza;
	}
	
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getColor () {
		return this.color;
	}
	
	public void setColor (String color) {
		this.color = color;
	}
	
	public void sonido () {
		System.out.println("miau");
	}
	
}
