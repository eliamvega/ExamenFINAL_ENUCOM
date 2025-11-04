package com.mx.Accesorio.Service;

import java.util.List;

import com.mx.Accesorio.Domain.Accesorio;



public interface IAccesorio {
Accesorio guardar (Accesorio a);
	
	List<Accesorio> listar();
	
	Accesorio buscar (int idAccesorio);
	
	void eliminar (int idAccesorio);
}
