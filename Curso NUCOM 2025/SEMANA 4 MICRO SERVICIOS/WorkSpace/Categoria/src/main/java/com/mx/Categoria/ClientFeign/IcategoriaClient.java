package com.mx.Categoria.ClientFeign;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Categoria.Entidad.Videojuego;









@FeignClient(name = "videojuego-ms", url = "http://localhost:8014", path = "/v")
public interface IcategoriaClient {

    @GetMapping("/categoria/{categoriaId}")
    List<Videojuego> porCategoria(@PathVariable("categoriaId") int categoriaId);

}
