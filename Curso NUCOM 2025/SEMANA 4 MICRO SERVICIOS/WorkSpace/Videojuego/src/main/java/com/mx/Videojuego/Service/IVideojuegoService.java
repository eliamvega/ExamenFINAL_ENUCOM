package com.mx.Videojuego.Service;

import java.util.List;

import com.mx.Videojuego.Dominio.Videojuego;

public interface IVideojuegoService {

	Videojuego guardar(Videojuego j );
	
	List <Videojuego> listar();
	
	void eliminar(int idVideojuego);
	
	Videojuego buscar(int idVideojuego);
}
