package com.mx.Responsable.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mx.Responsable.Dominio.Responsable;
import com.mx.Responsable.Service.IResponsableServiceImp;

@RestController
@RequestMapping(path = "api/responsable")
//@CrossOrigin("*")

public class ResponsableWS {
	
	@Autowired
	private IResponsableServiceImp service;
	
	//http://localhost:8060/api/responsable/listar
		@GetMapping("/listar")
	    public ResponseEntity<List<Responsable>> listar() {
	        List<Responsable> responsables = service.listar();
	        return responsables.isEmpty()
	            ? ResponseEntity.noContent().build()
	            : ResponseEntity.ok(responsables);
	    }
	
	 @PostMapping("/guardar")
	    public ResponseEntity<String> guardar(@RequestBody Responsable r) {
	        try {
	            service.guardar(r);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body("Responsable creado con éxito."); // solo texto
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al crear responsable: " + e.getMessage());
	        }
	    }
	 @PutMapping("/editar")
	    public ResponseEntity<String> editar(@RequestBody Responsable r) {
		 Responsable existente = service.buscar(r);
	        if (existente == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("No existe el responsable con ID: " + r.getIdResponsable());
	        }
	        service.editar(r);
	        return ResponseEntity.ok("Responsable actualizado: " + r.getIdResponsable());
	    }
	 
	 @DeleteMapping("/eliminar")
	    public ResponseEntity<String> eliminar(@RequestBody Responsable responsable) {
		 Responsable encontrado = service.buscar(responsable);
	        if (encontrado != null) {
	            service.eliminar(encontrado);
	            return ResponseEntity.ok("Responsable eliminado: " + responsable.getIdResponsable());
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .body("No se encontró ningun responsable con ID: " + responsable.getIdResponsable());
	    }
	 @PostMapping("/buscar")
	    public ResponseEntity<?> buscar(@RequestBody Responsable responsable) {
		 Responsable encontrado = service.buscar(responsable);
	        if (encontrado == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("No se encontró ningun responsable con ID: " + responsable.getIdResponsable());
	        }
	        return ResponseEntity.ok(encontrado);
	    }
//paso 1
	 @GetMapping("/Veterinaria")
	 public ResponseEntity<List<Responsable>> listarV(@RequestParam int veterinariaId) {
		 List<Responsable> V = service.buscarVeterinaria(veterinariaId);
		 return ResponseEntity.ok(V);
	 }
}
