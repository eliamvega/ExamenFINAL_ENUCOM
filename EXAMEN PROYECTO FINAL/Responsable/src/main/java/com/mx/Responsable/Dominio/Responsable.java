package com.mx.Responsable.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "RESPONSABLES")
@Data
public class Responsable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idResponsable;
	
	@Column
	private String nombre;
	
	@Column
	private Long contacto;
	
	@Column
	private Integer veterinariaId;
	
	public Responsable () {}
	
	
	
	
}
