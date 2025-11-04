package com.mx.Empleado.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Empleado.Dominio.Empleado;
import com.mx.Empleado.Repository.IEmpleadoRepository;
@Service
public class EmpleadoServiceImp implements IMetodos<Empleado>{

	
	@Autowired
	private IEmpleadoRepository repo;
	
	
	@Override
	public Empleado guardar(Empleado T) {
		return repo.save(T);
	}

	@Override
	public void editar(Empleado entidad) {
		repo.save(entidad);
		
	}

	@Override
	public void eliminar(Empleado entidad) {
		repo.delete(entidad);
		
	}

	@Override
	public List<Empleado> listar() {
		
		return repo.findAll(Sort.by(Sort.Direction.ASC,"idEmpleado"));
	}

	@Override
	public Empleado buscar(Empleado entidad) {
		if (entidad.getIdEmpleado() != null) {
			return repo.findById(entidad.getIdEmpleado()).orElse(null);
		}
		return null;
	}
	//paso 0.1
	public List<Empleado> buscarArea(int areaId ){
		return repo.findByAreaId(areaId);
	}

}
