package com.mx.Desarrolladora.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Desarrolladora.Dominio.Desarrolladora;

public interface IDesaDAO extends JpaRepository<Desarrolladora, Integer> {

    // Busca por país ignorando mayúsculas y minúsculas, y usando LIKE
    List<Desarrolladora> findByPaisIgnoreCaseContaining(String pais);

    // Busca por nombre ignorando mayúsculas y minúsculas, y usando LIKE
    Desarrolladora findByNombreIgnoreCaseContaining(String nombre);
}
