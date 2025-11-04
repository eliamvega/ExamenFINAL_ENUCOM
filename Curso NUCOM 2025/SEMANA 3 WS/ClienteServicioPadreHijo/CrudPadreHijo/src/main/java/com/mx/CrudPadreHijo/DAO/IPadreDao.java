package com.mx.CrudPadreHijo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.CrudPadreHijo.Dominio.Padre;



@Repository
public interface IPadreDao extends JpaRepository<Padre, Integer> {
	
	Padre findByNombreIgnoringCaseContainingAndApellidoIgnoringCaseContaining(String nombre, String apellido);
}
