package com.mx.RolService.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ROLES")
public class Rol {

	@Id
	@Column
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;
	
	@Column
	private String privilegio;
}
