package com.mx.Accesorio.Controller;

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

import com.mx.Accesorio.Domain.Accesorio;
import com.mx.Accesorio.Service.AccesorioServiceImp;



@RestController
@RequestMapping (path = "/accesorio")
@CrossOrigin
public class AccesorioWS {

	

	@Autowired
	private AccesorioServiceImp service;
	
	//URI : http://localhost:8012/consola
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Accesorio> accesorios = service.listar();
		return (accesorios.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(accesorios);
		
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Accesorio a){
		Accesorio existe = service.validacion( a.getNombre());
		if (existe != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			} else {
				existe = service.guardar(a);
				return ResponseEntity.status(HttpStatus.CREATED).body(existe);
			}
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Accesorio a){
		Accesorio actual = service.guardar(a);
	return ResponseEntity.ok(actual);
		
	}
	@DeleteMapping
	public ResponseEntity<?> eliminar(@RequestParam int idAccesorio){
		service.eliminar(idAccesorio);
		return ResponseEntity.noContent().build();	
		}
}
