package com.mx.Empleado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Empleado.Dominio.Empleado;
import java.util.List;


public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	//paso 0
	List<Empleado> findByAreaId(int areaId);

}
