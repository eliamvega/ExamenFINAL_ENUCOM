package com.mx.Empresa.Service;

import java.util.List;
import com.mx.EmpresaEmpleado.Dominio.Empleado;

public interface EmpleadoService {
    List<Empleado> listar();
    Empleado guardar(Empleado empleado);
    Empleado buscar(Integer id);
    void eliminar(Integer id);
    Empleado editar(Empleado empleado);
}