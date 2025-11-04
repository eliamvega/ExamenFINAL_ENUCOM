package com.mx.Herencia;

public class Principal {

	
	public static void main(String[] args) {
		Perro perro = new Perro("PERRO","DOMESTICO",1.5,2,.80,"FRENCH","FIRULAIS");
		
		System.out.println(perro);
		perro.sonido();
	}
	}
