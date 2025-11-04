package com.mx.Principal;

public interface IMetodos<T> {
	
	void guardar (T entidad);
	
	T buscar (int indice);
	
	void actualizar(int indice,T entidad);
	
	void eliminar(int indice);
	
	void mostrar();
	

}
