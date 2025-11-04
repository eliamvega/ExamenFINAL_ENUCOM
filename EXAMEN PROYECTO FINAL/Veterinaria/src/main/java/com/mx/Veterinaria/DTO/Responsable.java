package com.mx.Veterinaria.DTO;


import lombok.Data;

//paso 2
@Data

public class Responsable {
	
private Integer idResponsable;


	private String nombre;
	
	private Long contacto;
	
	private Integer veterinariaId;
}
