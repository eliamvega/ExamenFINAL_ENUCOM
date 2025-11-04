package com.mx.Desarrolladora.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.Desarrolladora.Dominio.Desarrolladora;
import com.mx.Desarrolladora.Entidad.Videojuego;
import com.mx.Desarrolladora.Service.DesServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/desarrolladora")
@CrossOrigin("*")
public class DesarrolladoraWS {

    @Autowired
    private DesServiceImpl service;

    // URI: http://localhost:8010/desarrolladora
    @Operation(summary = "Listar desarrolladoras", description = "Lista todas las desarrolladoras desde la base de datos")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Desarrolladora> des = service.mostrar();
        return des.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(des);
    }

    // Guardar - http://localhost:8010/desarrolladora
    @Operation(summary = "Guardar desarrolladora", description = "Crea y almacena una nueva desarrolladora en la base de datos")
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Desarrolladora d) {
        Desarrolladora encontrado = service.buscar(d.getIdDesarrolladora());

        if (encontrado == null) {
            if (service.porNombre(d.getNombre())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("{\"mensaje\":\"El nombre ya existe: " + d.getNombre() + "\"}");
            } else {
                service.guardar(d);
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body("{\"mensaje\":\"Desarrolladora " + d.getNombre() + " almacenada con éxito.\"}");
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("{\"mensaje\":\"ID inválido, ya existe.\"}");
        }
    }

 // Buscar por ID usando POST - http://localhost:8010/desarrolladora/id
    @Operation(summary = "Buscar por ID" , description = "Busca desarrolladora mediante su ID desde la base de datos y la muestra")
    @PostMapping("/id") 
    public ResponseEntity<?> buscarPorId(@RequestBody Desarrolladora d) {
        Desarrolladora encontrado = service.buscar(d.getIdDesarrolladora());
        return (encontrado == null) 
            ? ResponseEntity.notFound().build() 
            : ResponseEntity.ok(encontrado);
    }

    // Eliminar - http://localhost:8010/desarrolladora
    @Operation(summary = "Eliminar desarrolladora", description = "Elimina una desarrolladora mediante su ID desde la base de datos")
    @DeleteMapping
    public ResponseEntity<?> eliminar(@RequestBody Desarrolladora d) {
        service.eliminar(d);
        return ResponseEntity.noContent().build();
    }

    // Editar - http://localhost:8010/desarrolladora
    @Operation(summary = "Editar desarrolladora", description = "Edita una desarrolladora existente en la base de datos y la actualiza")
    @PutMapping
    public ResponseEntity<?> editar(@RequestBody Desarrolladora d) {
        if (service.porNombre(d.getNombre())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("{\"mensaje\":\"El nombre de la desarrolladora ya existe: " + d.getNombre() + "\"}");
        } else {
            service.guardar(d);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("{\"mensaje\":\"ACTUALIZACIÓN EXITOSA***\"}");
        }
    }

    // Buscar por país - http://localhost:8010/desarrolladora/pais/{pais}
    @Operation(summary = "Buscar por pais ", description = "Busca desarrolladora por pais")
    @GetMapping("/pais/{pais}")
    public ResponseEntity<?> porpais(@PathVariable String pais) {
        return ResponseEntity.ok(service.porPais(pais));
    }

    // Verificar existencia por nombre - http://localhost:8010/desarrolladora/nombre/{nombre}
    @Operation(summary = "Buscar por nombre", description = "Busca desarrolladora por nombre")
    @GetMapping("/nombre/{nombre}")
    public boolean existePorNombre(@PathVariable String nombre) {
        return service.porNombre(nombre);
    }
    
    //MOSTRAR VIDEOJUEGOS
    //http://localhost:8010/desarrolladora/videojuegos
    @Operation(summary = "Listar desarrolladora y videojuegos", description = "Lista desarrolladora y sus videojuegos asociados")
    @GetMapping("videojuegos/{videojuegoId}")
    public ResponseEntity<?> videojuegos(@PathVariable int videojuegoId){
    	//List<Videojuego> v = service.traerVideojuegos(videojuegoId);
    	//return (v.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(v);
    HashMap<String, Object> hash = service.desYVideojuegos(videojuegoId);
    return ResponseEntity.ok(hash);
    
    
    
    }
}
