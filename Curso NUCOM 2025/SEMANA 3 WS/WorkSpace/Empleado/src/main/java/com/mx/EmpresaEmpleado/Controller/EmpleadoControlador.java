package com.mx.EmpresaEmpleado.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mx.Empresa.Service.EmpleadoService;
import com.mx.EmpresaEmpleado.Dominio.Empleado;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoControlador {

    @Autowired
    EmpleadoService service;

    @GetMapping("/listar")
    public List<Empleado> listar() {
        return service.listar();
    }

    @PostMapping("/guardar")
    public Empleado guardar(@RequestBody Empleado empleado) {
        return service.guardar(empleado);
    }

    @GetMapping("/buscar/{id}")
    public Empleado buscar(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @PutMapping("/editar")
    public Empleado editar(@RequestBody Empleado empleado) {
        return service.editar(empleado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
