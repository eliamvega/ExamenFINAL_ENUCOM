package com.mx.Consola.Service;

import java.util.List;

import com.mx.Consola.Domain.Consola;

public interface IConsolaService {

	
	Consola guardar (Consola c);
	
	List<Consola> listar();
	
	Consola buscar (int idConsola);
	
	void eliminar (int idConsola);
}
