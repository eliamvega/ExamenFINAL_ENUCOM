package com.mx.Videojuego;

import java.util.ArrayList;
import java.util.List;

//se va a implementar la interfaz IMetodos -------> va la logica de todo el programa
	public class Implementacion implements IMetodos{

		
		private List<Videojuego> videojuegos = new ArrayList<Videojuego>();
	@Override
	public void crear(Videojuego v) {
		videojuegos.add(v);
		
	}

	@Override
	public void listar() {
		if (videojuegos.isEmpty()) {
			System.out.println("NO HAY VIDEOJUEGOS PARA MOSTRAR.");
		}else {
			System.out.println(videojuegos);
		}
		
		
	}

	@Override
	public void actualizar(int indice, Videojuego v) {
		videojuegos.set(indice, v);
	
		
	}

	@Override
	public void eliminar(int indice) {
	videojuegos.remove(indice);
		
	}
	public Videojuego buscar(int indice) {
		return videojuegos.get(indice);
	}
	public int contar() {
		return videojuegos.size();
	
	}
		public void mostrarIndice() {
		for (int i = 0; i < videojuegos.size();i++) {
			System.out.println("Indice: [ " + i + "], nombre: " + videojuegos.get(i).getNombre());
			
		}
	
	
	
	}
	}
		
	
