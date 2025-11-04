package com.mx.Videojuego.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Videojuego.DAO.IVideojuegoDAO;
import com.mx.Videojuego.Dominio.Videojuego;

@Service
public class VideoJuegoServiceImp implements IVideojuegoService{

	
	@Autowired
	private IVideojuegoDAO dao;

	@Override
	public Videojuego guardar(Videojuego j) {
		// TODO Auto-generated method stub
		return dao.save(j);
	}

	@Override
	public List<Videojuego> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idVideojuego"));
	}

	@Override
	public void eliminar(int idVideojuego) {
		// TODO Auto-generated method stub
		dao.deleteById(idVideojuego);
	}

	@Override
	public Videojuego buscar(int idVideojuego) {
		// TODO Auto-generated method stub
		return dao.findById(idVideojuego).orElse(null);
	}
	public List<Videojuego> porCategoria(int categoriaId){
		return dao.findByCategoriaId(categoriaId);
	}
	
	public List<Videojuego> porDesarrolladora(int desarrolladoraId){
		return dao.findByDesarrolladoraId(desarrolladoraId);
	}
}
