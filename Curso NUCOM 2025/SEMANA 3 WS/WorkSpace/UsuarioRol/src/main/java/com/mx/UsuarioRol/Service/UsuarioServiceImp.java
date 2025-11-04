package com.mx.UsuarioRol.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.UsuarioRol.DAO.IUsuarioDao;
import com.mx.UsuarioRol.DAO.IRolDao;
import com.mx.UsuarioRol.Dominio.Rol;
import com.mx.UsuarioRol.Dominio.Usuario;

@Service
public class UsuarioServiceImp implements IMetodos<Usuario> {

    @Autowired
    private IUsuarioDao dao;

    @Autowired
    private IRolDao rolDao;
//“Este metodo este reescribiendo un metodo que ya existe en una clase o interfaz padre”.
    public Usuario guardar(Usuario u) {
        if (u.getRol() != null && u.getRol().getIdRol() != null) {
            Rol rol = rolDao.findById(u.getRol().getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            u.setRol(rol);
        } else {
            u.setRol(null); // Permitir usuario sin rol
        }
        return dao.save(u);
    }

    @Override
    public void editar(Usuario u) {
        if (u.getRol() != null && u.getRol().getIdRol() != null) {
            Rol rol = rolDao.findById(u.getRol().getIdRol())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            u.setRol(rol);
        } else {
            u.setRol(null);
        }
        dao.save(u);
    }

    @Override
    public void eliminar(Usuario entidad) {
        dao.delete(entidad);
    }

    @Override
    public List<Usuario> listar() {
    	//Significa que el orden sera ascendente.
        return dao.findAll(Sort.by(Sort.Direction.ASC, "idUsuario"));
    }

    @Override
    public Usuario buscar(Usuario entidad) {
        return dao.findById(entidad.getIdUsuario()).orElse(null);
    }
}
