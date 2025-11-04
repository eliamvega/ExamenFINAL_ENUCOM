package com.mx.Principal;

public class Hilo2 extends Thread {

	private String nombre;
	
	public Hilo2(String nombre) {
		
		this.nombre = nombre;
	}
	
	public void run() {
		
		System.out.println("HILO 2 EJECUTANDOSE................");
	}
}
