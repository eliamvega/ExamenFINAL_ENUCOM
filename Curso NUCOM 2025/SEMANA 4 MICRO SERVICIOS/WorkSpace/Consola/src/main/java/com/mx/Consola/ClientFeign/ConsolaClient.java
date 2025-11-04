package com.mx.Consola.ClientFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.Consola.Entidad.Accesorios;

@FeignClient(name = "Accesorios", url="http://localhost:8008", path="/accesorios")
public interface ConsolaClient {

	@GetMapping(value = "/consola")
	public List<Accesorios> porAccesorio(@RequestParam int consolaId);
}
