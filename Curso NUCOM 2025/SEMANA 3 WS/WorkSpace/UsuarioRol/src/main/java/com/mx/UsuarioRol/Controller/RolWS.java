package com.mx.UsuarioRol.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.mx.UsuarioRol.Dominio.Rol;
import com.mx.UsuarioRol.Service.RolServiceImp;

@RestController
@RequestMapping(path = "api/rol")
@CrossOrigin(origins = "*")
public class RolWS {

    @Autowired
    private RolServiceImp service;

    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listar() {
        List<Rol> roles = service.listar();
        return roles.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(roles);
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Rol r) {
        try {
            if (service.buscarPorPrivilegio(r.getPrivilegio()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El rol con privilegio '" + r.getPrivilegio() + "' ya existe.");
            }
            Rol rolGuardado = service.guardar(r);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body("Rol creado con ID: " + rolGuardado.getIdRol());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar el rol: " + e.getMessage());
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<Map<String, String>> editar(@RequestBody Rol r) {
        Map<String, String> response = new HashMap<>();

        Rol existente = service.buscar(r);
        if (existente == null) {
            response.put("mensaje", "❌ El rol con ID " + r.getIdRol() + " no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        service.editar(r);
        response.put("mensaje", "✅ Rol actualizado con ID: " + r.getIdRol());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Map<String, Object>> eliminar(@RequestBody Rol rol) {
        Rol encontrado = service.buscar(rol);
        Map<String, Object> response = new HashMap<>();

        if (encontrado != null) {
            service.eliminar(encontrado);
            response.put("mensaje", "Rol eliminado con éxito ✅");
            response.put("idEliminado", rol.getIdRol());
            return ResponseEntity.ok(response);
        }

        response.put("mensaje", "❌ No se encontró rol con ID: " + rol.getIdRol());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestBody Rol rol) {
        Rol encontrado = service.buscar(rol);
        return encontrado == null
            ? ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontro rol con ID: " + rol.getIdRol())
            : ResponseEntity.ok(encontrado);
    }
}
