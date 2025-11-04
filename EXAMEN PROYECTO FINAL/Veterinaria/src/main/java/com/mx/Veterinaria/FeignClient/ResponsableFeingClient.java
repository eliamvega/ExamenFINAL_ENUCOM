package com.mx.Veterinaria.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.mx.Veterinaria.DTO.Responsable;


//paso conexcion 3

@FeignClient(name = "responsable", url = "http://localhost:8060/api/responsable")
public interface ResponsableFeingClient {

	@GetMapping("/Veterinaria")
	public List<Responsable> listarV(@RequestParam("veterinariaId") int veterinariaId);
}

