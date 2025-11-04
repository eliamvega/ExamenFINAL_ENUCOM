package com.mx.Accesorios.Service;

import java.util.List;

import com.mx.Accesorios.Dominio.Accesorios;

public interface IAccesoriosService {
	
	Accesorios guardar(Accesorios a);
	
	List<Accesorios> listar();
	
	Accesorios buscar (int idAccesorios);
	
	void eliminar(int idAccesorios);

}
