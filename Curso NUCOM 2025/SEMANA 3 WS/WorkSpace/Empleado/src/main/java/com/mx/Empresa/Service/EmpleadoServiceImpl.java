package com.mx.Empresa.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.EmpresaEmpleado.Dominio.Empleado;
import com.mx.EmpresaEmpleado.DAO.EmpleadoDao;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoDao dao;

    @Override
    public List<Empleado> listar() {
        return dao.findAll();
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return dao.save(empleado);
    }

    @Override
    public Empleado buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Empleado editar(Empleado empleado) {
        return dao.save(empleado);
    }
}