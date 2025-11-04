package com.mx.Veterinaria.DTO;

import lombok.Data;

@Data
//paso 2
public class Cliente {
	
private Integer idCliente;
	
	private String nombre;
	
	private  String direccion;
	
	private Long contacto;

	private Integer veterinariaId;
}
