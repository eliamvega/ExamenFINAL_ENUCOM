package com.mx.Excepcion;

public class Principal {

	
	public static void main(String[] args) {
		
		Funciones f = new Funciones();
		
		try {
			f.dividir(23, 0);
		}catch(ArithmeticException e) {
		System.out.println("NO SE PUDO REALIZAR LA DIVISION: " + e.getMessage());
		}
		String url = "C:\\Users\\ElSipha\\Desktop\\Curso NUCOM 2025\\SEMANA 1 POO\\Excepciones.txt";
		try {
			
			f.leerArchivo(url);
		} catch (Exception e) {
		System.out.println("OCURRIO UN ERROR AL ACCEDER AL ARCHIVO.ERROR: " + e.getMessage());
		}finally {
			System.out.println("FIN DEL PROGRAMA");
		}
		
		//INSTANCIAR 
		Persona p = new Persona();
		
		try {
			p.setEdad(12);
			
		}catch(EdadInvalidadException e) {
			System.out.println("OCURRIO UN ERROR AL REGISTRAR LA EDAD.ERROR !  " + e.getMessage());
		}
		
	}
}
