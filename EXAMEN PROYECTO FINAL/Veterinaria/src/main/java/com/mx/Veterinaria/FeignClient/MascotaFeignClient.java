package com.mx.Veterinaria.FeignClient;
//paso 3 conexion

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.Veterinaria.DTO.Mascota;

@FeignClient(name ="mascota" , url = "http://localhost:8050/api/mascota")
public interface MascotaFeignClient {
	@GetMapping("/Veterinaria")
	public List<Mascota> listarM (@RequestParam("veterinariaId") int veterinariaId);
	
	
	

}
