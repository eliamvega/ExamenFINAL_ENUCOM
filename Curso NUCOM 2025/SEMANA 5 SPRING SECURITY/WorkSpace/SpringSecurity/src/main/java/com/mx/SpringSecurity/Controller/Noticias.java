package com.mx.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Noticias {

	@GetMapping("noticias")
	public String noticias() {
		return "Controlador de noticias";
	}
}
