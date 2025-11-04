package com.mx.Desarrolladora.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Desarrolladora.ClientFeign.IVideojuegoClient;
import com.mx.Desarrolladora.Dao.IDesaDAO;
import com.mx.Desarrolladora.Dominio.Desarrolladora;
import com.mx.Desarrolladora.Entidad.Videojuego;

@Service
public class DesServiceImpl implements IDesService {

    @Autowired
    private IDesaDAO dao;

    @Override
    public void guardar(Desarrolladora d) {
        dao.save(d);
    }

    @Override
    public void editar(Desarrolladora d) {
        dao.save(d); // save actualiza si ya existe
    }

    @Override
    public void eliminar(Desarrolladora d) {
        dao.delete(d);
    }

    @Override
    public List<Desarrolladora> mostrar() {
        return dao.findAll();
    }

    @Override
    public Desarrolladora buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }
    
    public List<Desarrolladora> porPais(String pais) {
        return dao.findByPaisIgnoreCaseContaining(pais);
    }
    
    
    public boolean porNombre(String nombre) {
    	Desarrolladora encontrado = dao.findByNombreIgnoreCaseContaining(nombre);
    if(encontrado !=null) {
    	return true;
    }else {
    	return false;
    }
    	
    	
    	
    }
    
    
    
    //INYECTO EL FEIGN
    @Autowired
    private IVideojuegoClient vFeignClient;
    
    public List<Videojuego> traerVideojuegos(int desarrolladoraId){
    	return vFeignClient.porDesarrolladora(desarrolladoraId);
    }
    
    public HashMap<String, Object> desYVideojuegos(int idDesarrolladora){
    	HashMap<String, Object> hash = new HashMap<>();
    	Desarrolladora encontrado = dao.findById(idDesarrolladora).orElse(null);
    	if (encontrado == null) {
    		hash.put("mensaje", "No existe la desarrolladora" + idDesarrolladora);
    		
    	} else {
    		hash.put("Desarrolladora", encontrado);
    		List<Videojuego> v = vFeignClient.porDesarrolladora(idDesarrolladora);
    		if (v.isEmpty()) {
    			hash.put("mensaje2", "no existen videojuegos desarrollados");
    			
    		}else {
    			hash.put("Videojuegos", v);
    	}
    }
    	return hash;
    }
    
    
}
