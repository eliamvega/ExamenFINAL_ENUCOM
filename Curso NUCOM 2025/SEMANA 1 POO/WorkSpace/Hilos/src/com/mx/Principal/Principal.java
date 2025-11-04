package com.mx.Principal;

public class Principal {

	
	public static void main(String[] args) {
		
		
		Hilo2 miHilo = new Hilo2("HILO 2");
		
		//INICIAR HILO2
		
		miHilo.start();
	Thread hilo3 = new Thread(new Hilo3("HILO 3"));
	
	hilo3.start();
	
	System.out.println("FIN DE LA EJECUCION DEL HILO PRINCIPAL");
	}
}
