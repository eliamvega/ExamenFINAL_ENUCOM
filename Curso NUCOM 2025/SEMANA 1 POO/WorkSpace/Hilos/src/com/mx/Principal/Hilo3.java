package com.mx.Principal;

public class Hilo3 implements Runnable {

	private String nombre;
	
	public Hilo3(String nombre) {
		
	}
	
	
	public void run() {
		System.out.println("HILO 3 EJECUTANDOSE CON INTERFACE RUNNABLE");
	}
}
