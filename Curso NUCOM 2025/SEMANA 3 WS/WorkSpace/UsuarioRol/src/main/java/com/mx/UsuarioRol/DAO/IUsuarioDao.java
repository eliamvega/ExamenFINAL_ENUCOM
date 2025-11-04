package com.mx.UsuarioRol.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.UsuarioRol.Dominio.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
    // Usamos Long porque idUsuario es Long en la entidad Usuario
}
