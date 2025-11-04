package com.mx.Veterinaria.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.Veterinaria.DTO.Cliente;

//paso 3 coneccion 
	@FeignClient(name = "cliente", url = "http://localhost:8070/api/cliente")
public interface ClienteFeignClient {
		
		@GetMapping("/Veterinaria")
		public List<Cliente> listarC(@RequestParam("veterinariaId") int veterinariaId);

	

		
		
		
	}

