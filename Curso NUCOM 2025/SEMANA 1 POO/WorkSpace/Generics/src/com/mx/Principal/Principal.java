package com.mx.Principal;

import com.mx.Entidad.Herramienta;
import com.mx.Entidad.Ropa;
import com.mx.Implementacion.Implementacion;

public class Principal {

	
	public static void main(String[] args) {
		
		//ROPA La T se puede sustituir por lo que sea que queramos ejemplo ropa
		
		Implementacion<Ropa> prendas = new Implementacion<Ropa>();
		
		
		//guardamos los datos de prendas 
		
		prendas.guardar(new Ropa(2, "PANTALON", "NUEVA MARCA",20,800));
		prendas.guardar(new Ropa(1, "PLAYERA", "NIKE",20,800));
		
		
		//MOSTRAR
		prendas.mostrar();
		
		//buscar
		
		Ropa aux = null;
		aux = prendas.buscar(0);
		System.out.println("prenda encontrada = " + aux);
		
		//herramienta
		
		Implementacion<Herramienta> h = new Implementacion<Herramienta>();
		//crear
		
		Herramienta h1 = new Herramienta("MARTILLO","METAL",65.0,"NEUVO");
		Herramienta h2 = new Herramienta("MARTILLO","METAL",65.0,"NEUVO");
		
		
		//guardamos 
		
		h.guardar(h1);
		h.guardar(h2);
		
		//mostrar
		h.mostrar();
	}
}
