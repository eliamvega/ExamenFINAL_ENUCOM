package com.mx.Videojuego.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mx.Videojuego.Dominio.Videojuego;
import com.mx.Videojuego.Service.VideoJuegoServiceImp;

public class VideojuegoWSTest {

	
	@Mock
	private VideoJuegoServiceImp service;
	
	@InjectMocks
	private VideojuegoWS controller;
	
	private Videojuego v;
	
	//crear un metodo que se va activar cada que se realizar una prueba unitaria
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		v = new Videojuego();
		v.setIdVideojuego(1);
		v.setNombre("mario bros 3");
	}
	
	//prueba unitaria cundo en la base de datos existan registros
	@Test
	void testListarConDatos() {
		when(service.listar()).thenReturn(Arrays.asList(v));
		
		ResponseEntity<?> respuesta = controller.listar();
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		assertEquals(1,((List<?>)  respuesta.getBody()).size());
		verify(service).listar();
	}
	
	//prueba unitaria editar
	@Test
	void testEditar() {
		when(service.guardar(v)).thenReturn(v);
		ResponseEntity<?> respuesta = controller.editar(v);
		assertEquals(HttpStatus.OK, respuesta.getStatusCode());
		assertEquals(v, respuesta.getBody());
		verify(service).guardar(v);
	}
}
