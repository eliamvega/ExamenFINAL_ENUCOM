package com.mx.Imprementacion;

import java.util.HashMap;

import com.mx.Principal.IMetodos;

public class ImpGenerica implements IMetodos{

	
	
	protected HashMap<Object, Object> hash = new HashMap<Object, Object>(0);

	@Override
	public void guardar(Object key, Object value) {
	hash.put(key, value);
		
	}

	@Override
	public void mostrar() {
System.out.println(hash);
		
	}

	@Override
	public void editar(Object key, Object value) {
		hash.replace(key, value);
		
	}

	@Override
	public void eliminar(Object key) {
	hash.remove(key);
		
	}
	public Object buscar(Object key) {
		return hash.get(key);
	}
}
