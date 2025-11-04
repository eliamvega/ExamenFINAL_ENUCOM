package com.mx.Consola.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Consola.ClientFeign.ConsolaClient;
import com.mx.Consola.Domain.Consola;
import com.mx.Consola.Entidad.Accesorios;
import com.mx.Consola.Repository.IConsolaRepository;


@Service
public class ConsolaServiceImp implements IConsolaService {

	@Autowired
	private IConsolaRepository repository;

	@Override
	public Consola guardar(Consola c) {
		// TODO Auto-generated method stub
		return repository.save(c);
	}

	@Override
	public List<Consola> listar() {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(Sort.Direction.ASC, "idConsola"));
	}

	@Override
	public Consola buscar(int idConsola) {
		// TODO Auto-generated method stub
		return repository.findById(idConsola).orElse(null);
	}

	@Override
	public void eliminar(int idConsola) {
		// TODO Auto-generated method stub
		repository.deleteById(idConsola);
	}

	public Consola validacion(String nombre, String tipo) {
		return repository.findByNombreIgnoringCaseContainingAndTipoIgnoringCaseContaining(nombre, tipo);
	}

	@Autowired
	private ConsolaClient cFeignClient;

	public List<Accesorios> traerAccesorios(int consolaId) {
		return cFeignClient.porAccesorio(consolaId);
	}

	public HashMap<String, Object> conYAccesorios(int idConsola) {
		HashMap<String, Object> hash = new HashMap<>();
		Consola encontrada = repository.findById(idConsola).orElse(null);
		if (encontrada == null) {
			hash.put("mensaje", "No existe la consola" + idConsola);
		} else {
			hash.put("Consola", encontrada);
			List<Accesorios> a = cFeignClient.porAccesorio(idConsola);
			if (a.isEmpty()) {
				hash.put("mensaje2", "no existen accesorios ");

			} else {
				hash.put("Accesorio", a);
			}
			
		}
		return hash;
	}
}
