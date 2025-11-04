package com.mx.Area.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Area.DTO.Empleado;
import com.mx.Area.Dominio.Area;
import com.mx.Area.FeignClient.EmpleadoFeignClient;
import com.mx.Area.Repository.IAreaRepository;

@Service
public class IAreaServiceImp implements IMetodos<Area> {

    @Autowired
    private IAreaRepository repo;

    @Override
    public Area guardar(Area a) {
        return repo.save(a);
    }

    @Override
    public void editar(Area entidad) {
        repo.save(entidad);
    }

    @Override
    public void eliminar(Area entidad) {
        repo.delete(entidad);
    }

    @Override
    public List<Area> listar() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "idArea"));
    }

    @Override
    public Area buscar(Area entidad) {
        if (entidad.getIdArea() != null) {
            return repo.findById(entidad.getIdArea()).orElse(null);
        }
        return null;
    }

    // FEIGN CLIENT
    @Autowired
    private EmpleadoFeignClient rep;

    public List<Empleado> obtenerEmpleados(int areaId) {
        return rep.listarA(areaId);
    }

    // -------------------------------
    // NUEVO MÉTODO: AREA + EMPLEADOS
    // -------------------------------
    public Map<String, Object> obtenerAreaConEmpleadosMap(Integer areaId) {
        Area area = repo.findById(areaId).orElse(null);
        if (area == null) return null;

        List<Empleado> empleados = rep.listarA(areaId);

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("area", area);
        resultado.put("empleados", empleados);

        return resultado;
    }
}
