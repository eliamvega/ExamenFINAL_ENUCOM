package com.mx.Excepcion;

public class Persona {

	
	//atributos
	private int edad;
	// constructores
	
	public void setEdad(int edad) {
		
		if (edad < 18 || edad > 100) {
			//excepcion personalizada 
			throw new EdadInvalidadException("EDAD FUERA DEL RANGO PARA EL REGISTRO. " + edad);
		}
		System.out.println("EDAD AGREGADA CORRECTAMENTE : " + edad + "AÑOS ");
	}
	
	
}
