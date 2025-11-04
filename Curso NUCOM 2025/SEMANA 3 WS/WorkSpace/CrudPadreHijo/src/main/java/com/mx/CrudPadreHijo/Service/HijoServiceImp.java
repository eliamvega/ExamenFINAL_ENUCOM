package com.mx.CrudPadreHijo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.CrudPadreHijo.DAO.IHijoDao;
import com.mx.CrudPadreHijo.Dominio.Hijo;



@Service
public class HijoServiceImp implements IMetodos<Hijo> {

	//inyeccion
	@Autowired
	private IHijoDao dao;

	@Override
	public void guardar(Hijo h) {
		// TODO Auto-generated method stub
		dao.save(h);
	}

	@Override
	public void editar(Hijo entidad) {
		// TODO Auto-generated method stub
		dao.save(entidad);
	}

	@Override
	public void eliminar(Hijo entidad) {
		// TODO Auto-generated method stub
		dao.delete(entidad);
	}

	@Override
	public List<Hijo> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idHijo"));
	}

	@Override
	public Hijo buscar(Hijo entidad) {
		// TODO Auto-generated method stub
		return dao.findById(entidad.getIdHijo()).orElse(null);
	}
	
	//buscra nombre y apellido
	public Hijo porNombreYApellido(String nombre, String apellido) {
		return dao.findByNombreIgnoringCaseContainingAndApellidoIgnoringCaseContaining(nombre, apellido);
	}

	public List<Hijo> porHobbie(String hobbie) {
		// TODO Auto-generated method stub
		return null;
	}
	


}