package com.mx.Categoria.Service;

import java.util.List;
import com.mx.Categoria.Domain.Categoria;

public interface ICategoriaService {

    void guardar(Categoria c);

    void editar(Categoria c);

    void eliminar(Categoria c);

    List<Categoria> mostrar();

    Categoria buscar(Integer id);

    // Buscar por nombre
    Categoria buscarPorNombre(String nombre);

    // Buscar por género
    List<Categoria> buscarPorGenero(String genero);
}
