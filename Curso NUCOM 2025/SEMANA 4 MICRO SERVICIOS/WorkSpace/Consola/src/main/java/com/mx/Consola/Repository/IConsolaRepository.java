package com.mx.Consola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Consola.Domain.Consola;

public interface IConsolaRepository extends JpaRepository<Consola, Integer> {
	
	Consola findByNombreIgnoringCaseContainingAndTipoIgnoringCaseContaining(String nombre, String tipo);
	
	

}