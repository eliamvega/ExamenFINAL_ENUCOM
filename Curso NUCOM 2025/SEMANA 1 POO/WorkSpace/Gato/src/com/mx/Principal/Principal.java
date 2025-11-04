package com.mx.Principal;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String [] args) {
		//gatitos
		
		Gato g1 = new Gato("MICHITO", "GRANDE", 8 , "BLANCO CON NEGRO");
		Gato g2 = new Gato("MICHI", "CHICA", 2 , "BLANCO CON NARANJA");
		Gato g3 = new Gato("RAUL", "AZTECA", 4 , "BLANCO CON GRIS");
		Gato g4 = new Gato("SOLOVINO", "RUSO", 9 , "BLANCO CON AZUL");
		Gato g5 = new Gato("SOLOSEFUE", "CAPUCHINO", 8 , "BLANCO CON ROJO");
		
		//CREAR LISTA
		List<Gato> Gatos = new ArrayList<Gato>();
		
		//objeto auxiliar
				Gato aux = null;
		
		//agregar gatos
		
		Gatos.add(g1);
		Gatos.add(g2);
		Gatos.add(g3);
		Gatos.add(g4);
		Gatos.add(g5);
		
		//buscar
		aux = Gatos.get(2);
	System.out.println("Gato encontrado: " + aux);
		
	//eliminar
	aux = Gatos.get(2);
	Gatos.remove(2);
	System.out.println("Se elimino al Gato: " + aux.getNombre() + " DE LA RAZA " + aux.getRaza());
	System.out.println(Gatos);
	
	//vaciar la lista
	
			Gatos.clear();
			
			//validar si la lista contiene elementos
			
			if(Gatos.isEmpty()) {
				System.out.println("NO EXISTE ELEMENTOS EN LA LISTA" + Gatos);
			} else {
				System.out.println("HAY "+ Gatos.size() + "Gatos.");
			}
				
	}

}
