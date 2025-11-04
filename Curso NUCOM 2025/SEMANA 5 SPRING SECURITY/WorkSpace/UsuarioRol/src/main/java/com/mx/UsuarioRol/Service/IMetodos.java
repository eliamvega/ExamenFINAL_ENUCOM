package com.mx.UsuarioRol.Service;

import java.util.List;

public interface IMetodos<T> {
	
	T guardar(T entidad);
	
	void editar(T entidad);
	
	void eliminar(T entidad);
	
	List<T> listar();
	
	T buscar(T entidad);
}