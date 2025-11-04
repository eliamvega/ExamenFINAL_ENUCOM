package com.mx.UsuarioService.Service;

import java.util.List;

import com.mx.UsuarioService.Dominio.Usuario;

public interface IMetodos<T> {
	
	T guardar(T entidad);

	void editar (T entidad);
	
	void eliminar (T entidad );
	
	List<T> listar ();
	
	T buscar (T entidad);
	
	 List<Usuario> buscarPorRolId(Long rolId);
	
}
