package com.mx.HashMap;

import java.util.HashMap;

public class Principal {

	
	public static void main(String[] args) {
		//televisor
		Televisor t1 = new Televisor("LALUPE", "LG", 32, "SMART TV", 6500 );
		Televisor t2 = new Televisor("LHG7778", "LG", 32, "SMART TV", 4500);
		Televisor t3 = new Televisor("50Qne", "Samsung", 55, "Smart TV", 9500);
		Televisor t4 = new Televisor("Lhttg", "Lg", 64, "Smart TV", 545.2);
		
		//aux
		Televisor aux = null;
		
		//implementacion
		
		Implementacion imp = new Implementacion();
	//guardamos
		imp.guardar(t1);
		imp.guardar(t2);
		imp.guardar(t3);
		imp.guardar(t4);
		
		//mostramos
		imp.mostrar();
		
		//buscamos -----> Lhttg
		//aux = new Televisor();
		//aux.setModelo("Lhttg");
		//aux = new Televisor"Lhttg", null, 0, null, 0);
		//aux = imp.buscar(aux);
		aux = imp.buscarClave("Lhttg");
		
		//eliminar
		
		aux = new Televisor("LALUPE");
		//aux = imp.eliminarClave("LALUPE");
		aux = imp.buscar(aux);
		imp.eliminar(aux);
		System.out.println("SE HA ALIMINADO LA TV: " + aux.getModelo());
		
		imp.mostrar();
		
		imp.contar();
		
		
	HashMap<String, Televisor> encontrados = new HashMap<String, Televisor>();
	encontrados = imp.mostrarClaves();
	if (encontrados.isEmpty()) {
		System.out.println("NO SE ENCONTRARON TELEVISORES CON ESA MARCA");
	}else {
		System.out.println(encontrados);
	}
	}
	
}
