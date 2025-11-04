package com.mx.Veterinaria.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Veterinaria.Dominio.Veterinaria;

public interface IVeterinariaRepository extends JpaRepository<Veterinaria, Integer> {
	

}
