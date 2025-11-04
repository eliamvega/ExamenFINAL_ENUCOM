package com.mx.CrudPadreHijo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.CrudPadreHijo.DAO.IPadreDao;
import com.mx.CrudPadreHijo.Dominio.Padre;

@Service
public class PadreServiceImp implements IMetodos<Padre> {

	//inyeccion
	@Autowired
	private IPadreDao dao;

	@Override
	public void guardar(Padre p) {
		// TODO Auto-generated method stub
		dao.save(p);
	}

	@Override
	public void editar(Padre entidad) {
		// TODO Auto-generated method stub
		dao.save(entidad);
	}

	@Override
	public void eliminar(Padre entidad) {
		// TODO Auto-generated method stub
		dao.delete(entidad);
	}

	@Override
	public List<Padre> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idPadre"));
	}

	@Override
	public Padre buscar(Padre entidad) {
		// TODO Auto-generated method stub
		return dao.findById(entidad.getIdPadre()).orElse(null);
	}
	
	//buscra nombre y apellido
	public Padre porNombreYApellido(String nombre, String apellido) {
		return dao.findByNombreIgnoringCaseContainingAndApellidoIgnoringCaseContaining(nombre, apellido);
	}
	


}
