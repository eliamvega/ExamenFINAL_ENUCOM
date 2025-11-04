package com.mx.Categoria.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Categoria.Domain.Categoria;
import com.mx.Categoria.Entidad.Videojuego;
import com.mx.Categoria.ClientFeign.IcategoriaClient;
import com.mx.Categoria.DAO.ICategoriaDAO;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private ICategoriaDAO dao;

    @Override
    public void guardar(Categoria c) {
        dao.save(c);
    }

    @Override
    public void editar(Categoria c) {
        
        dao.save(c);
    }

    @Override
    public void eliminar(Categoria c) {
        dao.delete(c);
    }

    @Override
    public List<Categoria> mostrar() {
        return dao.findAll();
    }

    @Override
    public Categoria buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    

    public Categoria buscarPorNombre(String nombre) {
        return dao.findByNombreIgnoreCaseContaining(nombre);
    }

    public List<Categoria> buscarPorGenero(String genero) {
        return dao.findByGeneroIgnoreCaseContaining(genero);
    }
    @Autowired
    private IcategoriaClient categoriaClient;
    public List<Videojuego> trearVideojuegos (int videojuegoId){
    	List<Videojuego> lista = categoriaClient.porCategoria(videojuegoId);
    	return lista;
    }
}
