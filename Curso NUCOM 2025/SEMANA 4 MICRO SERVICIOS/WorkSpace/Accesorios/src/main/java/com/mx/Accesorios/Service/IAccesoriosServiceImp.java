package com.mx.Accesorios.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Accesorios.Dominio.Accesorios;
import com.mx.Accesorios.Repository.IAccesoriosRepository;


@Service
public class IAccesoriosServiceImp implements IAccesoriosService {
	
	@Autowired
	private IAccesoriosRepository repository;

	@Override
	public Accesorios guardar(Accesorios a) {
		// TODO Auto-generated method stub
		return repository.save(a);
	}

	@Override
	public List<Accesorios> listar() {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(Sort.Direction.ASC, "idAccesorios"));
	}

	@Override
	public Accesorios buscar(int idAccesorios) {
		// TODO Auto-generated method stub
		return repository.findById(idAccesorios).orElse(null);
	}

	@Override
	public void eliminar(int idAccesorios) {
		// TODO Auto-generated method stub
		repository.deleteById(idAccesorios);
	}
	
	public Accesorios validacion(String nombre, String modelo) {
		return repository.findByNombreIgnoringCaseContainingAndModeloIgnoringCaseContaining(nombre, modelo);
	}
	public List<Accesorios> porAccesorio(int consolaId){
		return repository.findByConsolaId(consolaId);
	}
	
	}


