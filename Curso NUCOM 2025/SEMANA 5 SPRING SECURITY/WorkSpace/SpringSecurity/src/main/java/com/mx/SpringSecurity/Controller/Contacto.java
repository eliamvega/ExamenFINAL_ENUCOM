package com.mx.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contacto {

	
	@GetMapping("contacto")
	public String contacto() {
		return  "Controlador de contacto";
	}
}
