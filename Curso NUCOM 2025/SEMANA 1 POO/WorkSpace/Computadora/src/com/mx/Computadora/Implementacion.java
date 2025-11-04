package com.mx.Computadora;

import java.util.ArrayList;
import java.util.List;

//se va a implementar IMetodos 
public class Implementacion implements IMetodos {

	private List<Computadora> computadoras = new ArrayList<Computadora>();
	@Override
	public void crear(Computadora v) {
		computadoras.add(v);
		
	}

	@Override
	public void listar() {
		System.out.println(computadoras);
		
	}

	@Override
	public void actualizar(int indice, Computadora v) {
	    if (indice >= 0 && indice < computadoras.size()) {
	        computadoras.set(indice, v);
	    } else {
	        System.out.println("Índice inválido. No se puede actualizar.");
	    }
	}

	@Override
	public void eliminar(int indice) {
	    if (indice >= 0 && indice < computadoras.size()) {
	        computadoras.remove(indice);
	    } else {
	        System.out.println("Índice inválido. No se puede eliminar.");
	    }
	}

	public Computadora buscar(int indice) {
	    if (indice >= 0 && indice < computadoras.size()) {
	        return computadoras.get(indice);
	    } else {
	        System.out.println("Índice inválido. No se puede buscar.");
	        return null;
	    }
	}
	public int contar() {
		return computadoras.size();
	}

	public void mostrarIndice() {
		for (int i = 0; i < computadoras.size();i++) {
			System.out.println("Indice: [ " + i + "], nombre: " + computadoras.get(i).getMarca());
		
	}
	

}
}
