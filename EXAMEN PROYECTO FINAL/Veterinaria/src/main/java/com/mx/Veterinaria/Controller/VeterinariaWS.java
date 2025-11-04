package com.mx.Veterinaria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Veterinaria.DTO.Responsable;
import com.mx.Veterinaria.Dominio.Veterinaria;
import com.mx.Veterinaria.Service.IVeterinariaServiceImp;

@RestController
@RequestMapping(path = "api/veterinaria")
//@CrossOrigin("*")
public class VeterinariaWS {

	
	@Autowired
	private IVeterinariaServiceImp service;
	
	//http://localhost:8080/api/veterinaria/listar
	@GetMapping("/listar")
	public ResponseEntity<List<Veterinaria>> listar() {
	    List<Veterinaria> veterinarias = service.listar();
	    return veterinarias.isEmpty()
	        ? ResponseEntity.noContent().build()
	        : ResponseEntity.ok(veterinarias);
	}
			
			
			 @PostMapping("/guardar")
			    public ResponseEntity<String> guardar(@RequestBody Veterinaria v) {
			        try {
			            service.guardar(v);
			            return ResponseEntity.status(HttpStatus.CREATED)
			                    .body("Veterinaria creada con éxito."); // solo texto
			        } catch (Exception e) {
			            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			                    .body("Error al crear veterinaria: " + e.getMessage());
			        }
			    }
			 @PutMapping("/editar")
			    public ResponseEntity<String> editar(@RequestBody Veterinaria v) {
				 Veterinaria existente = service.buscar(v);
			        if (existente == null) {
			            return ResponseEntity.status(HttpStatus.NOT_FOUND)
			                .body("No existe la veterinaria con ID: " + v.getIdVeterinaria());
			        }
			        service.editar(v);
			        return ResponseEntity.ok("Veterinaria actualizada: " + v.getIdVeterinaria());
			    }
			 
			 @DeleteMapping("/eliminar")
			    public ResponseEntity<String> eliminar(@RequestBody Veterinaria veterinaria) {
				 Veterinaria encontrado = service.buscar(veterinaria);
			        if (encontrado != null) {
			            service.eliminar(encontrado);
			            return ResponseEntity.ok("Veterinaria eliminada: " + veterinaria.getIdVeterinaria());
			        }
			        return ResponseEntity.status(HttpStatus.NOT_FOUND)
			            .body("No se encontró ninguna veterinaria con ID: " + veterinaria.getIdVeterinaria());
			    }
			 @PostMapping("/buscar")
			    public ResponseEntity<?> buscar(@RequestBody Veterinaria veterinaria) {
				 Veterinaria encontrado = service.buscar(veterinaria);
			        if (encontrado == null) {
			            return ResponseEntity.status(HttpStatus.NOT_FOUND)
			                .body("No se encontró ninguna veterinaria con ID: " + veterinaria.getIdVeterinaria());
			        }
			        return ResponseEntity.ok(encontrado);
			    }
			 
			 //paso 5
			 @GetMapping("/responsables")
			 public List<Responsable> listarResponsablesExternos(@RequestParam int veterinariaId) {
			     return service.obtenerResponsables(veterinariaId);
			 }
			 
			 @GetMapping("/detalle/{idVeterinaria}")
			 public ResponseEntity<?> detalle(@PathVariable int idVeterinaria) {
			     return ResponseEntity.ok(service.detalleVeterinaria(idVeterinaria));
			 }
			 
}
