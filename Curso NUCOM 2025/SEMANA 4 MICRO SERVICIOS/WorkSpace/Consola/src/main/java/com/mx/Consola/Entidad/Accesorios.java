package com.mx.Consola.Entidad;

import lombok.Data;

@Data
public class Accesorios {
	private int idAccesorios;
	private String nombre;
	private String modelo;
	private String conexion;
	private String material;
	private String color;
	private double precio;
	private int consolaId;
}
