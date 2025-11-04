package com.mx.UsuarioService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.UsuarioService.Dominio.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	 List<Usuario> findByRolId(Long rolId);
}
