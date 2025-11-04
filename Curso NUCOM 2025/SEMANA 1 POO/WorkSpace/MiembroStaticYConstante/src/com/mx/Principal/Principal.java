package com.mx.Principal;

public class Principal {

	//miembro static 
	
	public static String frase1 = "MIEMBRO STATIC";
	
	// CONTANTE
	
	public final String frase2 = "CONSTANTE O VARIABLE FINAL";
	
	
	//STATIC Y CONSTANTE
	
	public static final String frase3 = "MIEMBRO STATIC Y CONSTANTE";
	
	public static void main(String[] args) {
		
		frase1 = "HOLA MUNDO";
		System.out.println("frase1");
		
		//frase2 = "HOLA MUNDO DESDE FRASE 2";
		//System.out.println("frase2");
		
		//frase3= "HOLA MUNDO DESDE FRASE 3"
		System.out.println(frase3);
		
		//sumar(4,9);
		
		
	}
	
	
	public void sumar(int a, int b) {
		System.out.println(a + "+" + b + " = " + (a+b));
	}
}
