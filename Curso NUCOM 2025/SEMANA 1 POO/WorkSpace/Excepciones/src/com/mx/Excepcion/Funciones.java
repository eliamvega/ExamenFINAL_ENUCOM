package com.mx.Excepcion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Funciones {

	
	//CREAR UN METODO CON EXCEPCION NO VERIFICADA
	
	public void dividir (int a , int b) {
		
		System.out.println(a + " / " + b + " = " + (a/b));
	}
	
	// crear un metodo con una excepcion verificada
	
	public void leerArchivo(String url) throws Exception {
		
		String linea;
		
		File archivo = new File(url);
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		while((linea = br.readLine()) != null) {
			System.out.println(linea);
		}
	}
}
