package com.mx.Computadora;

public interface IMetodos {
// METODOS CRUD 
	public void crear (Computadora v);
	public void listar ();
	public void actualizar (int indice, Computadora v);
	public void eliminar (int indice);
}
