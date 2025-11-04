package com.mx.Accesorios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Accesorios.Dominio.Accesorios;


public interface IAccesoriosRepository extends JpaRepository<Accesorios	, Integer>{
	
	Accesorios findByNombreIgnoringCaseContainingAndModeloIgnoringCaseContaining(String nombre, String modelo);
	
List<Accesorios> findByConsolaId(int consolaId);
}
