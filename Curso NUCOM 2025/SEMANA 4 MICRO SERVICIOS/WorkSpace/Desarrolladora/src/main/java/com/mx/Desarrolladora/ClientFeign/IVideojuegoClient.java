package com.mx.Desarrolladora.ClientFeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.Desarrolladora.Entidad.Videojuego;
//OPENFEIGN SIMPLIFICA LLAMADAS HTTP ENTRE MICROSERVICIOS POR MEDIO DE INTERFECES
//ES UNA ALTERNATIVA A REST TEMPLATE, QUE SE INTEGRA CIB EUREKA, SE UTILIZA LA ANATACION @FeignClient ES MAS FACIL DE USAR PORQUE ES NATIVA 
@FeignClient(name = "Videojuegos-MS", url= "http://localhost:8014", path = "/v")
public interface IVideojuegoClient {

	//LA INTERFACE SOLO TIENE METODOS ABSTRACTOS, OSEA QUE NO LLEVA IMPLEMENTACION 
	//CONTROLADOR A CONSUMIR (FIRMA O CABECEO DEL CONTROLADOR Y SU METODO HTTP)                 
	//FIRMA O LA CABECERA DEL CONTROLADOR O UN METODO ABSTRACTO = MODIFICADOR DE ACCESO COMO (PRIVATE, PUBLIC) + VALOR DE RETORNO + NOMBRE + PARAMETRO
	
	
	@GetMapping(value = "/des")// METODO HTTP
	public List<Videojuego> porDesarrolladora(@RequestParam int desarrolladoraId);//CABECERA
	
	




}
