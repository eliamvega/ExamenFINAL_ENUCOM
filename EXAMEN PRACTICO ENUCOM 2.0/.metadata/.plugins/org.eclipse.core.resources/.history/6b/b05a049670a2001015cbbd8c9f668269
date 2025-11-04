package com.mx.Area.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.Area.Dominio.Area;
import com.mx.Area.Service.IAreaServiceImp;

@RestController
@RequestMapping(path = "api/area")
public class AreaWS {

    @Autowired
    private IAreaServiceImp service;

    // LISTAR TODOS
    @GetMapping
    public List<Area> listar() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Area> buscar(@PathVariable Integer id) {
        Area are = new Area();
        are.setIdArea(id);
        Area encontrado = service.buscar(are);
        if (encontrado != null) {
            return ResponseEntity.ok(encontrado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GUARDAR NUEVO
    @PostMapping
    public Area guardar(@RequestBody Area area) {
        return service.guardar(area);
    }

    // EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<Area> editar(@PathVariable Integer id, @RequestBody Area area) {
        Area existente = service.buscar(new Area() {{ setIdArea(id); }});
        if (existente != null) {
            area.setIdArea(id); // asegurar que actualiza el correcto
            service.editar(area);
            return ResponseEntity.ok(area);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        Area are = new Area();
        are.setIdArea(id);
        Area existente = service.buscar(are);
        if (existente != null) {
            service.eliminar(existente);
            return ResponseEntity.ok("Area eliminada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR TODOS
    @DeleteMapping
    public ResponseEntity<String> eliminarTodos() {
        service.listar().forEach(service::eliminar);
        return ResponseEntity.ok("Todas las areas fueron eliminadas");
    }

    // NUEVO ENDPOINT: AREA + EMPLEADOS
    @GetMapping("/{id}/empleados")
    public ResponseEntity<Map<String, Object>> getAreaConEmpleados(@PathVariable Integer id) {
        Map<String, Object> resultado = service.obtenerAreaConEmpleadosMap(id);
        if (resultado == null || resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }
}
