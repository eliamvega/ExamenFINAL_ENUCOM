package com.mx.Videojuego.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.mx.Videojuego.Dominio.Videojuego;

public interface IVideojuegoDAO extends JpaRepository<Videojuego, Integer>{

	@Procedure(procedureName = "RP_RESPALDO_VJ")
	public void respaldo();
	
	List<Videojuego> findByCategoriaId(int categoriaId);
	
	List<Videojuego> findByDesarrolladoraId(int desarrolladoraId);
	
	
}
