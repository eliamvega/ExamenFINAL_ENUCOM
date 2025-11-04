package com.mx.RolService.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class UsuarioDTO {
	 private Long idUsuario;
	    private String nombre;
	    private String app;
	    private String apm;
	    private String sexo;
	    private Date fechaNacimiento;
	    private Date fechaCreacion;
	    private String correo;
	    private Long rolId;
}
