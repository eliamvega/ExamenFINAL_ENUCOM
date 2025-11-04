package com.mx.Accesorios.Controller;


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
import com.mx.Accesorios.Dominio.Accesorios;
import com.mx.Accesorios.Service.IAccesoriosServiceImp;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path="/accesorios")
@CrossOrigin("*")
public class AccesoriosWS {

   
	@Autowired
	private IAccesoriosServiceImp service;

    
	
	//URI http://localhost:8008/accesorios
	@Operation(summary = "Listar accesorios", description = "Lista todos los accesorios de la base de datos ")
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Accesorios> accesorios = service.listar();
		return(accesorios.isEmpty())? ResponseEntity.noContent().build() : ResponseEntity.ok(accesorios);
	}
	@Operation(summary = "Guardar accesorio", description = "Crea y almacena un nuevo accesorio en la base de datos")
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Accesorios a){
		Accesorios existe = service.validacion(a.getNombre(), a.getModelo());
		if(existe != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}else {
			existe = service.guardar(a);
			return ResponseEntity.status(HttpStatus.CREATED).body(existe);
		}
	}
	@Operation(summary = "Editar accesorio", description = "Edita un accesorio existente en la base de datos y lo actualiza")
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Accesorios a){
		Accesorios actual = service.guardar(a);
		return ResponseEntity.ok(actual);
	}
	@Operation(summary = "Eliminar accesorio", description = "Elimina un accesorio mediante su ID de la base de datos")
	@DeleteMapping
	public ResponseEntity<?> eliminar(@RequestParam int idAccesorios){
		service.eliminar(idAccesorios);
		return ResponseEntity.noContent().build();
	}
@Operation(summary = "Buscar por ID", description = "Busca un accesorio por su ID en la base de datos y lo muestra")
	@PostMapping("buscar")
	public ResponseEntity<?> buscar(@RequestParam int idAccesorios){
		Accesorios encontrado = service.buscar(idAccesorios);
		return(encontrado != null)? ResponseEntity.ok(encontrado) : ResponseEntity.notFound().build();
	}
	
	@Operation(summary = "Buscar accesorio y su consola", description = "Buscar accesorio y su consola ")
	@GetMapping(value = "/consola")
	public ResponseEntity<?> porAccesorio(@RequestParam int consolaId){
		List<Accesorios> a = service.porAccesorio(consolaId);
		return ResponseEntity.ok(a);
	}
}
	 
