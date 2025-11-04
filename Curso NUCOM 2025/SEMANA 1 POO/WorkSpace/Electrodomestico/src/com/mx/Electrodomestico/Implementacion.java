package com.mx.Electrodomestico;

import java.util.ArrayList;
import java.util.List;

public class Implementacion implements IMetodos {

    private List<Electrodomestico> lista = new ArrayList<>();

    @Override
    public void guardar(Electrodomestico e) {
        for (Electrodomestico elec : lista) {
            if (elec.getModelo().equalsIgnoreCase(e.getModelo())) {
                System.out.println(" Ya existe un electrodoméstico con ese modelo.");
                System.out.println("No se registro tu demanda");
                return;
            }
        }
        lista.add(e);
        System.out.println(" Electrodoméstico guardado con éxito.");
    }

    @Override
    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println(" No hay electrodomésticos para mostrar.");
        } else {
            for (Electrodomestico e : lista) {
                System.out.println(e);
            }
        }
    }

    public Electrodomestico buscarPorClave(String modelo) {
        for (Electrodomestico e : lista) {
            if (e.getModelo().equalsIgnoreCase(modelo)) {
                return e;
            }
        }
        return null;
    }

    public List<Electrodomestico> buscarPorMarca(String marca) {
        List<Electrodomestico> resultados = new ArrayList<>();
        for (Electrodomestico e : lista) {
            if (e.getMarca().equalsIgnoreCase(marca)) {
                resultados.add(e);
            }
        }
        return resultados;
    }

    @Override
    public void editar(Electrodomestico actualizado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getModelo().equalsIgnoreCase(actualizado.getModelo())) {
                lista.set(i, actualizado);
                System.out.println(" Electrodoméstico actualizado.");
                return;
            }
        }
        System.out.println(" No se encontró el modelo para editar.");
    }

    @Override
    public void eliminar(Electrodomestico e) {
        boolean eliminado = lista.removeIf(elem -> elem.getModelo().equalsIgnoreCase(e.getModelo()));
        if (eliminado) {
            System.out.println(" Electrodoméstico eliminado.");
        } else {
            System.out.println(" No se encontró el modelo para eliminar.");
        }
    }

    public void eliminarPorMarca(String marca) {
        boolean eliminado = lista.removeIf(e -> e.getMarca().equalsIgnoreCase(marca));
        if (eliminado) {
            System.out.println(" Se eliminaron los electrodomésticos con la marca: " + marca);
        } else {
            System.out.println(" No se encontró la marca para eliminar.");
        }
    }

    public void eliminarTodo() {
        lista.clear();
        System.out.println(" Todos los electrodomésticos han sido eliminados.");
    }

    public int contar() {
        return lista.size();
    }

	@Override
	public void crear(Electrodomestico e) {
		// TODO Auto-generated method stub
		
	}
}
		
	


