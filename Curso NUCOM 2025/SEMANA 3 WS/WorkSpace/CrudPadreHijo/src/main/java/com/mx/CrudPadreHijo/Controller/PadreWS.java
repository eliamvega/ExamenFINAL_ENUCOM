package com.mx.CrudPadreHijo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CrudPadreHijo.Dominio.Padre;
import com.mx.CrudPadreHijo.Service.PadreServiceImp;

@RestController
@RequestMapping(path = "api/padre")
@CrossOrigin
public class PadreWS {
	
    @Autowired
    private PadreServiceImp service;
	
    
    //url: http://localhost:8001/api/padre/listar
    
    //listar  http://localhost:8001/api/padre/listar
    @GetMapping(path = "/listar")
    public ResponseEntity<?> listar(){
    	List<Padre> padres = service.listar();
    	if(padres.isEmpty()) {
    		return ResponseEntity.noContent().build();
    	}else {
    		return ResponseEntity.ok(padres);
    	}
    }
    
    
    //guardar http://localhost:8001/api/padre/guardar
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> guardar(@RequestBody Padre p){
    	Padre nuevo = service.buscar(p);
    	if(nuevo == null) {
    		service.guardar(p);
    		return ResponseEntity.status(HttpStatus.CREATED).body("{\"mensaje\":\"SE HA ALMACENADO EL PADRE "  + p.getIdPadre()+".\"}");
    	}else {
    		return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"mensaje\":\"EL PADRE CON ID "+p.getIdPadre()+ " YA EXISTE NO SE HA ALMACENADO.\"}");
    	}
    }
    
    
    //editar http://localhost:8001/api/padre/editar
    @PutMapping(path= "/editar")
    public ResponseEntity<?> editar(@RequestBody Padre p){
    	Padre encontrado = service.buscar(p);
    	if(encontrado == null){
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"mensaje\":\"EL PADRE "+p.getIdPadre()+ "NO EXISTE.\"}");
    	}else {
    		return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\":\"SE HA ACTUALIZADO EL PADRE " +p.getIdPadre()+".\"}");
    	}
    }
    
    
    //eliminar http://localhost:8001/api/padre/eliminar
    @DeleteMapping(path = "/eliminar")
    public ResponseEntity<?> eliminar(@RequestBody Padre p){
    	service.eliminar(p);
    	return ResponseEntity.noContent().build();
    }
    
    //buscar  http://localhost:8001/api/padre/buscar
    @PostMapping(path = "/buscar")
    public ResponseEntity<?> buscar(@RequestBody Padre p){
    	Padre encontrado = service.buscar(p);
    	if(encontrado == null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("EL PADRE "+p.getIdPadre()+ " NO HA SIDO LOCALIZADO");
    	}else {
    		return ResponseEntity.ok(encontrado);
    	}
    }
    
    //buscra por nombre y apellido http://localhost:8001/api/padre/porNA 

    @GetMapping(path = "porNA")
    public ResponseEntity<?> porNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
    	Padre encontrado = service.porNombreYApellido(nombre, apellido);
    	if(encontrado != null) {
    		return ResponseEntity.ok(encontrado);
    	}else {
    		return ResponseEntity.noContent().build();
    	}
    }
    
}
