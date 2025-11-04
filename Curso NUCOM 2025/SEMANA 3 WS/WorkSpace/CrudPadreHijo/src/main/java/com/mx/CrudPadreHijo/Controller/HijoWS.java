package com.mx.CrudPadreHijo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.CrudPadreHijo.Dominio.Hijo;
import com.mx.CrudPadreHijo.Service.HijoServiceImp;

@RestController
@RequestMapping(path = "api/hijo")
@CrossOrigin
public class HijoWS {

    @Autowired
    private HijoServiceImp service;

    // Listar todos los hijos
    @GetMapping(path = "/listar")
    public ResponseEntity<?> listar() {
        List<Hijo> hijos = service.listar();
        if (hijos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(hijos);
    }

    // Guardar un hijo
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> guardar(@RequestBody Hijo h) {
        Hijo existente = service.buscar(h);
        if (existente == null) {
            service.guardar(h);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body("SE HA ALMACENADO EL HIJO " + h.getIdHijo());
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("EL HIJO CON EL ID " + h.getIdHijo() + " YA EXISTE, NO SE HA ALMACENADO");
        }
    }

    // Editar un hijo
    @PutMapping(path = "/editar")
    public ResponseEntity<?> editar(@RequestBody Hijo h) {
        Hijo encontrado = service.buscar(h);
        if (encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("EL HIJO " + h.getIdHijo() + " NO EXISTE. NO SE EDITÓ");
        } else {
            service.editar(h);
            return ResponseEntity.ok("SE HA ACTUALIZADO EL HIJO " + h.getIdHijo());
        }
    }

    // Eliminar un hijo
    @DeleteMapping(path = "/eliminar")
    public ResponseEntity<?> eliminar(@RequestBody Hijo h) {
        service.eliminar(h);
        return ResponseEntity.noContent().build();
    }

    // Buscar un hijo por objeto (con id)
    @PostMapping(path = "/buscar")
    public ResponseEntity<?> buscar(@RequestBody Hijo h) {
        Hijo encontrado = service.buscar(h);
        if (encontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("EL HIJO " + h.getIdHijo() + " NO SE HA LOCALIZADO");
        }
        return ResponseEntity.ok(encontrado);
    }

    // Buscar hijos por hobbie
    @GetMapping(path = "/porHobbie")
    public ResponseEntity<?> porHobbie(@RequestParam String hobbie) {
        List<Hijo> encontrados = service.porHobbie(hobbie);
        if (encontrados == null || encontrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(encontrados);
    }
}