package com.mx.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Balance {

	@GetMapping("balance")
	public String balance() {
		return "Controlador de balance";
	}
}
