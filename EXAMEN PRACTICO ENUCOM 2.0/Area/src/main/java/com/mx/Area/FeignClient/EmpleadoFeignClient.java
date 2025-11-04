package com.mx.Area.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.Area.DTO.Empleado;

//paso 3 

@FeignClient(name = "empleado", url = "http://localhost:8060/api/empleado")
public interface EmpleadoFeignClient {
	
@GetMapping("/Area")
public List<Empleado> listarA(@RequestParam("areaId") int areaId);
}
