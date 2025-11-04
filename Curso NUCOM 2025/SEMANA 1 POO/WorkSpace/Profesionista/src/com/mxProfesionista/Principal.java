package com.mxProfesionista;


public class Principal {
	
	public static void main(String[] args) {
		
Ingeniero ingeniero = new Ingeniero ("INGENIERO EN SISTEMAS ","PROGRAMADOR","TEC ORIZABA",10,10,"APPLE");
		
Enfermera enfermera = new Enfermera ("ENFERMERIA ","ENFERMERA","UV ENFERMERIA",10,"REGIONAL RIO BLANCO","COVID");


		System.out.println(ingeniero);
		ingeniero.sonido();
		
		System.out.println(enfermera);
		enfermera.sonido();
	}

}
