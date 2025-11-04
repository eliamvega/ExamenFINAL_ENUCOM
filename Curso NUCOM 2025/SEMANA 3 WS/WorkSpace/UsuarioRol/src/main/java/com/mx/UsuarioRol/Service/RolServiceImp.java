package com.mx.UsuarioRol.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.UsuarioRol.DAO.IRolDao;
import com.mx.UsuarioRol.Dominio.Rol;

@Service
public class RolServiceImp implements IMetodos<Rol> {

    @Autowired
    private IRolDao dao;

    // Ahora devuelve el objeto guardado para poder obtener el ID
    @Override
    public Rol guardar(Rol r) {
        return dao.save(r);
    }

    @Override
    public void editar(Rol entidad) {
        dao.save(entidad);
    }

    @Override
    public void eliminar(Rol entidad) {
        dao.delete(entidad);
    }

    @Override
    public List<Rol> listar() {
        return dao.findAll(Sort.by(Sort.Direction.ASC, "idRol"));
    }

    @Override
    public Rol buscar(Rol entidad) {
        if (entidad.getIdRol() != null) {
            return dao.findById(entidad.getIdRol()).orElse(null);
        }
        return null;
    }

    // Nuevo método para buscar por privilegio
    public Rol buscarPorPrivilegio(String privilegio) {
        return dao.findByPrivilegio(privilegio);
    }
}