package com.mx.Principal;

import com.mx.Entidad.Fruta;
import com.mx.Entidad.Juguete;
import com.mx.Imprementacion.ImpFruta;
import com.mx.Imprementacion.ImpJuguete;

public class Principal {

	
	
	public static void main(String[] args) {
		
		Fruta f1 = new Fruta("MANGO", "AMARILLO", "VERANO",2.0,355.54);
		Fruta f2 = new Fruta("MANZANA", "ROJA", "OTOÑO", 5.0, 15.75);
		Fruta f3 = new Fruta("BANANA", "AMARILLO", "VERANO", 5.0, 15.75);
		
		//IMP
		ImpFruta impF = new ImpFruta();
		//guardamos
		impF.guardar(f1.getNombre(), f1);
		impF.guardar(f2.getNombre(), f2);
		impF.guardar(f3.getNombre(), f3);
		
		//mostrar
		impF.mostrar();
		//buscar
		Fruta auxF = null;
		auxF = (Fruta) impF.buscar("MANZANA");
		System.out.println("FRUTA LOCALIZADA : " + auxF);
		
		//eliminar
		auxF = (Fruta) impF.buscar("BANANA");
		impF.eliminar("BANANA");
		System.out.println("LA FRUTA ELIMINADA : " + auxF.getNombre());
		
		impF.contar();
		
		Juguete j1 = new Juguete(2, "LEGO STAR WARS", "LEGO", 35, 749.99);
		Juguete j2 = new Juguete(1, "MAX STEEL", "MATEL", 28, 299.90);
		Juguete j3 = new Juguete(2, "MUÑECO MINECRAFT", "LEGO", 35, 749.99);
		
		//imp
		ImpJuguete impJ = new ImpJuguete();
		
		impJ.guardar(j1.getCodigo(), j1);
		impJ.guardar(j2.getCodigo(), j2);
		impJ.guardar(j3.getCodigo(), j3);
		
		//mostrar
		
		impJ.mostrar();
		
		impJ.contar();
		
	}
}
