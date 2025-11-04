package com.mx.Empleado.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.Empleado.Dominio.Empleado;
import com.mx.Empleado.Service.EmpleadoServiceImp;

@RestController
@RequestMapping(path = "api/empleado")
public class EmpleadoWS {

    @Autowired
    private EmpleadoServiceImp service;

    // LISTAR TODOS
    @GetMapping
    public List<Empleado> listar() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscar(@PathVariable Integer id) {
        Empleado emp = new Empleado();
        emp.setIdEmpleado(id);
        Empleado encontrado = service.buscar(emp);
        if (encontrado != null) {
            return ResponseEntity.ok(encontrado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GUARDAR NUEVO
    @PostMapping
    public Empleado guardar(@RequestBody Empleado empleado) {
        return service.guardar(empleado);
    }

    // EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> editar(@PathVariable Integer id, @RequestBody Empleado empleado) {
        Empleado existente = service.buscar(new Empleado() {{ setIdEmpleado(id); }});
        if (existente != null) {
            empleado.setIdEmpleado(id); // asegurar que actualiza el correcto
            service.editar(empleado);
            return ResponseEntity.ok(empleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR POR ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        Empleado emp = new Empleado();
        emp.setIdEmpleado(id);
        Empleado existente = service.buscar(emp);
        if (existente != null) {
            service.eliminar(existente);
            return ResponseEntity.ok("Empleado eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ELIMINAR TODOS
    @DeleteMapping
    public ResponseEntity<String> eliminarTodos() {
        service.listar().forEach(service::eliminar);
        return ResponseEntity.ok("Todos los empleados fueron eliminados");
    }
    
    //paso 1
    @GetMapping("/Area")
    public ResponseEntity<List<Empleado>> listarA(@RequestParam int areaId){
    	List<Empleado> A = service.buscarArea(areaId);
    	return ResponseEntity.ok(A);
    }
}
