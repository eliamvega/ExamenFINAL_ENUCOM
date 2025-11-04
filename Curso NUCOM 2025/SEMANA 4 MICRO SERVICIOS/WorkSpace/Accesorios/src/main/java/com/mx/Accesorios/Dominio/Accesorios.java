package com.mx.Accesorios.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Accesorios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//AUTO GENERAR EL ID
	private int idAccesorios;
	private String nombre;
	private String modelo;
	private String conexion;
	private String material;
	private String color;
	private double precio;
	private int consolaId;
	
	
	

}
