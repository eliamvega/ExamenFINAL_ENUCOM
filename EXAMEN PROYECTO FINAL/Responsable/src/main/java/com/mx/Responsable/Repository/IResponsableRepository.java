package com.mx.Responsable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Responsable.Dominio.Responsable;

public interface IResponsableRepository extends JpaRepository<Responsable, Integer>{
	//paso 0
List<Responsable> findByVeterinariaId(int veterinariaId);
}
