package com.mx.Cliente.Controller;

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

import com.mx.Cliente.Dominio.Cliente;
import com.mx.Cliente.Service.IClienteServiceImp;


@RestController
@RequestMapping(path = "api/cliente")
//@CrossOrigin("*")


public class ClienteWS {

	
	@Autowired
	private IClienteServiceImp service;
	
	
	//http://localhost:8070/api/cliente/listar
		@GetMapping("/listar")
	    public ResponseEntity<List<Cliente>> listar() {
	        List<Cliente> clientes = service.listar();
	        return clientes.isEmpty()
	            ? ResponseEntity.noContent().build()
	            : ResponseEntity.ok(clientes);
	    }
		
		
		 @PostMapping("/guardar")
		    public ResponseEntity<String> guardar(@RequestBody Cliente c) {
		        try {
		            service.guardar(c);
		            return ResponseEntity.status(HttpStatus.CREATED)
		                    .body("Cliente creado con éxito."); // solo texto
		        } catch (Exception e) {
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                    .body("Error al crear cliente: " + e.getMessage());
		        }
		    }
		 @PutMapping("/editar")
		    public ResponseEntity<String> editar(@RequestBody Cliente c) {
			 Cliente existente = service.buscar(c);
		        if (existente == null) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                .body("No existe el cliente con ID: " + c.getIdCliente());
		        }
		        service.editar(c);
		        return ResponseEntity.ok("Cliente actualizado: " + c.getIdCliente());
		    }
		 
		 @DeleteMapping("/eliminar")
		    public ResponseEntity<String> eliminar(@RequestBody Cliente cliente) {
			 Cliente encontrado = service.buscar(cliente);
		        if (encontrado != null) {
		            service.eliminar(encontrado);
		            return ResponseEntity.ok("Cliente eliminado: " + cliente.getIdCliente());
		        }
		        return ResponseEntity.status(HttpStatus.NOT_FOUND)
		            .body("No se encontró ningun cliente con ID: " + cliente.getIdCliente());
		    }
		 @PostMapping("/buscar")
		    public ResponseEntity<?> buscar(@RequestBody Cliente cliente) {
			 Cliente encontrado = service.buscar(cliente);
		        if (encontrado == null) {
		            return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                .body("No se encontró ningun cliente con ID: " + cliente.getIdCliente());
		        }
		        return ResponseEntity.ok(encontrado);
		    }
		 
		 //paso 1
		 
		 @GetMapping("/Veterinaria")
		 public ResponseEntity<List<Cliente>> listarC(@RequestParam int veterinariaId){
			 List<Cliente> C = service.buscarVeterinaria(veterinariaId);
			 return ResponseEntity.ok(C);
			 
		 }
}
