package com.mx.Implementacion;

import java.util.ArrayList;
import java.util.List;

import com.mx.Principal.IMetodos;

public class Implementacion<T> implements IMetodos<T> {

	
private List<T> listaGenerica =	new ArrayList<T>();
	
	

	


@Override
public void guardar(T entidad) {
	listaGenerica.add(entidad);
	
}

@Override
public T buscar(int indice) {
	return listaGenerica.get(indice);
}

@Override
public void actualizar(int indice,T entidad) {
	listaGenerica.set(indice, entidad);
	
	
}

@Override
public void eliminar(int indice) {
	listaGenerica.remove(indice);
	
	
}

@Override
public void mostrar() {
	System.out.println(listaGenerica);
	
}}
