package com.mx.Veterinaria.DTO;


import lombok.Data;
//paso 2

@Data
public class Mascota {

	
private Integer idMascota;
	
	
	private String nombre;
	

	private String raza;
	

	private Integer edad;
	

	private String razonCita;
	

	private Integer clienteId;
	
	
	private Integer responsableId;
	

	private Integer veterinariaId;
}
