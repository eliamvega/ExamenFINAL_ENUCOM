package com.mx.Categoria.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Categoria.Domain.Categoria;


public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {
    List<Categoria> findByGeneroIgnoreCaseContaining(String genero);
    Categoria findByNombreIgnoreCaseContaining(String nombre);
}
