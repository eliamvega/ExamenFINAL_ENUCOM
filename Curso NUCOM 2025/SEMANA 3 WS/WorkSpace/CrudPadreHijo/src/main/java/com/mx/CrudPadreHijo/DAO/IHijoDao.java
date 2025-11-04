package com.mx.CrudPadreHijo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.CrudPadreHijo.Dominio.Hijo;

public interface IHijoDao extends JpaRepository<Hijo, Integer>{

	//metodo personalizado
	@Query(value = "SELECT * FROM HIJO WHERE UPPER(HOBBIE) = UPPER(:hobbie)", nativeQuery = true)
	List<Hijo> porHobbie(String hobbie);

	Hijo findByNombreIgnoringCaseContainingAndApellidoIgnoringCaseContaining(String nombre, String apellido);
}
