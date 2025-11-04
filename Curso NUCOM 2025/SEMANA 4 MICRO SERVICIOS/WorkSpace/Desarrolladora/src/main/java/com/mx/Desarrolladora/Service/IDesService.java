package com.mx.Desarrolladora.Service;

import java.util.List;
import com.mx.Desarrolladora.Dominio.Desarrolladora;

// Interfaz específica para Desarrolladora
public interface IDesService {

    void guardar(Desarrolladora d);

    void editar(Desarrolladora d);

    void eliminar(Desarrolladora d);

    List<Desarrolladora> mostrar();

    Desarrolladora buscar(Integer id);
}
