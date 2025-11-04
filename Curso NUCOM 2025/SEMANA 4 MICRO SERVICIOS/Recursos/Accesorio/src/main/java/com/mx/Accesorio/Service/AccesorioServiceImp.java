package com.mx.Accesorio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Accesorio.Domain.Accesorio;
import com.mx.Accesorio.Repository.IAcessorioRepository;


@Service
public class AccesorioServiceImp implements IAccesorio {

	
	@Autowired
	 private IAcessorioRepository repository;

	@Override
	public Accesorio guardar(Accesorio a) {
		// TODO Auto-generated method stub
		return repository.save(a);
	}

	@Override
	public List<Accesorio> listar() {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(Sort.Direction.ASC, "idAccesorio"));
	}

	@Override
	public Accesorio buscar(int idAccesorio) {
		// TODO Auto-generated method stub
		return repository.findById(idAccesorio).orElse(null);
	}

	@Override
	public void eliminar(int idAccesorio) {
		repository.deleteById(idAccesorio);
		
	}
	public Accesorio validacion(String nombre) {
	    return repository.findByNombreIgnoreCaseContaining(nombre).orElse(null);
	}

}