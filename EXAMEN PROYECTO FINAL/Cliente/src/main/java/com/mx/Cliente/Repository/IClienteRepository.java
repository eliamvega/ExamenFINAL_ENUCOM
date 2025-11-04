package com.mx.Cliente.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Cliente.Dominio.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	//paso 0}
	
	List<Cliente> findByVeterinariaId(int veterinariaId);
}
