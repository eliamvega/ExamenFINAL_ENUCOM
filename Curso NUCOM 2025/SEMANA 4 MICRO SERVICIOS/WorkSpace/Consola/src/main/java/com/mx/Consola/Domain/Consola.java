package com.mx.Consola.Domain;

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
//lombok: que es una biblioteca que genera codigo repetitivo de manera automatica
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Consola {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsola;
	private String nombre;
	private String tipo;
	private int lanzamiento;
	private double precio;
	private int productoraId;
}