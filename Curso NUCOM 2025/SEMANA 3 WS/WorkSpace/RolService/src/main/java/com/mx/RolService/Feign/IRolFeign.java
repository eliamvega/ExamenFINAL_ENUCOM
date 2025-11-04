package com.mx.RolService.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.mx.RolService.DTO.UsuarioDTO;



@FeignClient(name = "UsuarioService")
public interface IRolFeign {

	
//SE TRAERA EL METODO BUSCAR POR ROL ID DESDE USUARIOS
	//PASO 2
	
	 @GetMapping("/api/usuario/por-rol/{rolId}")
	    List<UsuarioDTO> obtenerUsuariosPorRol(@PathVariable("rolId") Long rolId);
}
