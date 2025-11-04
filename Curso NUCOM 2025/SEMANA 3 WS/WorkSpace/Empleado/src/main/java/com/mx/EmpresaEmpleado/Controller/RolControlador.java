package com.mx.EmpresaEmpleado.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mx.Empresa.Service.RolService;
import com.mx.EmpresaEmpleado.Dominio.Rol;


@RestController
@RequestMapping("/api/rol")
@CrossOrigin(origins = "*")
public class RolControlador {

    @Autowired
    RolService servicio;

    @GetMapping("/listar")
    public List<Rol> listar() {
        return servicio.listar();
    }

    @PostMapping("/guardar")
    public Rol guardar(@RequestBody Rol rol) {
        return servicio.guardar(rol);
    }

    @GetMapping("/buscar/{id}")
    public Rol buscar(@PathVariable Integer id) {
        return servicio.buscar(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
    }
}