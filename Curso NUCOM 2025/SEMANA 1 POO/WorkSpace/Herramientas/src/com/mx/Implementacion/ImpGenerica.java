package com.mx.Implementacion;

import java.util.ArrayList;
import java.util.List;

import Entidad.Par;
import Principal.IMetodos;

public class ImpGenerica implements IMetodos {

    protected List<Par> lista = new ArrayList<>();

    @Override
    public void guardar(Object key, Object value) {
        // Reemplaza si ya existe
        for (Par par : lista) {
            if (par.getClave().equals(key)) {
                par.setValor(value);
                return;
            }
        }
        // Si no existe, lo agrega
        lista.add(new Par(key, value));
    }

    @Override
    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("No hay elementos para mostrar.");
        } else {
            for (Par par : lista) {
                System.out.println(par);
            }
        }
    }

    @Override
    public void editar(Object key, Object value) {
        for (Par par : lista) {
            if (par.getClave().equals(key)) {
                par.setValor(value);
                return;
            }
        }
        System.out.println("Clave no encontrada para editar: " + key);
    }

    @Override
    public void eliminar(Object key) {
        Par aEliminar = null;
        for (Par par : lista) {
            if (par.getClave().equals(key)) {
                aEliminar = par;
                break;
            }
        }
        if (aEliminar != null) {
            lista.remove(aEliminar);
        } else {
            System.out.println("Clave no encontrada para eliminar: " + key);
        }
    }

    @Override
    public Object buscar(Object key) {
        for (Par par : lista) {
            if (par.getClave().equals(key)) {
                return par.getValor();
            }
        }
        return null;
    }
}
