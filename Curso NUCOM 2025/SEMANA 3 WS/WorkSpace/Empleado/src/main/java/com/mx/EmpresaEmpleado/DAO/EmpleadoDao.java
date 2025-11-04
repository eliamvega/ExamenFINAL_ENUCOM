package com.mx.EmpresaEmpleado.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.EmpresaEmpleado.Dominio.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado, Integer>{

}
