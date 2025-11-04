package com.mx.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Perfil {

	
	@GetMapping("perfil")
	public String  perfil() {
		return "Controlador de perfil";
	}
}
