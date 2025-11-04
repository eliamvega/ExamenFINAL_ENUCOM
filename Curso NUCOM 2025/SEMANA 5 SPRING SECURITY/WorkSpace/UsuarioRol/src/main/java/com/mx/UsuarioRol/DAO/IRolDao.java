package com.mx.UsuarioRol.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.UsuarioRol.Dominio.Rol;

public interface IRolDao extends JpaRepository<Rol, Integer> {
    Rol findByPrivilegio(String privilegio); // Método para buscar por privilegio
}
