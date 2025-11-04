package com.mx.Videojuego.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data //me crea todos los metodos repetitivos: constructores, get, set, y to String
public class Videojuego {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vj_seq")
	@SequenceGenerator(name ="vj_seq", sequenceName = "S_ID_VJ", allocationSize = 1)
	private int idVideojuego;
	private String nombre;
	private int  categoriaId;
	private double precio;
	private int desarrolladoraId;
	
}
