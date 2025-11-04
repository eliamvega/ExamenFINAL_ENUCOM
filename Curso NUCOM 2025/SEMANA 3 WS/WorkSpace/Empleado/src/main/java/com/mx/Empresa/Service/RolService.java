package com.mx.Empresa.Service;


import java.util.List;
import com.mx.EmpresaEmpleado.Dominio.Rol;

public interface RolService {
    List<Rol> listar();
    Rol guardar(Rol rol);
    Rol buscar(Integer id);
    void eliminar(Integer id);
}

