package com.mx.UsuarioService.Dominio;

import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "USUARIO")
@Data
public class Usuario {

	 //ID_USUARIO NUMBER(10) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	    //NOMBRE VARCHAR2(50),
	    //APP VARCHAR2(50),
	   // APM VARCHAR2(50),
	   // SEXO CHAR(1) CHECK (SEXO IN ('M', 'F')),
	   // CORREO VARCHAR2(100),
	   // FECHA_NACIMIENTO DATE,
	   // FECHA_CREACION DATE DEFAULT SYSDATE,
	  //  ROL_ID NUMBER(10)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String nombre;
	private String app;
	private String apm;
	private String sexo;
	//Solo almacena la fecha (año, mes, dia)
    private Date fechaNacimiento;
// Almacena fecha y hora completa
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    private String correo;
    private Long rolId;
 
}
