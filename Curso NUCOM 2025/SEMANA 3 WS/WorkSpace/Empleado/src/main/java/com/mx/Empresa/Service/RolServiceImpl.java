package com.mx.Empresa.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.EmpresaEmpleado.Dominio.Rol;
import com.mx.EmpresaEmpleado.DAO.RolDao;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolDao dao;

    @Override
    public List<Rol> listar() {
        return dao.findAll();
    }

    @Override
    public Rol guardar(Rol rol) {
        return dao.save(rol);
    }

    @Override
    public Rol buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        dao.deleteById(id);
    }
}
