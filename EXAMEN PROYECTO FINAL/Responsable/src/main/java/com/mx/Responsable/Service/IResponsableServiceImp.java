package com.mx.Responsable.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Responsable.Dominio.Responsable;
import com.mx.Responsable.Repository.IResponsableRepository;

@Service
public class IResponsableServiceImp implements IMetodos<Responsable> {
	
	@Autowired
	private IResponsableRepository repo;

	@Override
	public Responsable guardar(Responsable m) {
		return repo.save(m);
	}

	@Override
	public void editar(Responsable entidad) {
		repo.save(entidad);
		
	}

	@Override
	public void eliminar(Responsable entidad) {
		repo.delete(entidad);
		
		
	}

	@Override
	public List<Responsable> listar() {
		
		return repo.findAll(Sort.by(Sort.Direction.ASC,"idResponsable"));
	}

	@Override
	public Responsable buscar(Responsable entidad) {
		if (entidad.getIdResponsable() != null) {
			return repo.findById(entidad.getIdResponsable()).orElse(null);
		}
		return null;
	}
	//paso 0.1
	public List<Responsable> buscarVeterinaria(int veterinariaId){
		return repo.findByVeterinariaId(veterinariaId);
	}
	

}
