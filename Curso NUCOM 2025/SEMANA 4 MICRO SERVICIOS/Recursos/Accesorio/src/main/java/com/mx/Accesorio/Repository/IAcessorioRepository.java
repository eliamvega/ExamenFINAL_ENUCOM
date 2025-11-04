package com.mx.Accesorio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Accesorio.Domain.Accesorio;

public interface IAcessorioRepository extends JpaRepository<Accesorio, Integer>{

	Optional<Accesorio> findByNombreIgnoreCaseContaining(String nombre);

}
