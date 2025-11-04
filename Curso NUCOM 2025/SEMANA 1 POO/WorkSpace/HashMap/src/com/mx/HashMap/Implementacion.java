package com.mx.HashMap;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;

public class Implementacion implements IMetodos{

	
	/*Hashmap -------> Importa java.util
	 * <key, value> ----------> key: clase contenedora de la clave, value: clase contenedora del valor
	 * nombre del hashmap
	 * =
	 * new
	 * llamada al contenedor
	 */
	
	private HashMap<String, Televisor> hash = new HashMap<String, Televisor>();

	@Override
	public void guardar(Televisor t) {
		hash.put(t.getModelo(), t);
		
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
		
	}

	@Override
	public void editar(Televisor t) {
		hash.replace(t.getModelo(), t);
		
	}
	
	@Override
	public void eliminar(Televisor t) {
	hash.remove(t.getModelo());
		
	}
	public Televisor buscar(Televisor t) {
		return hash.get(t.getModelo());
		}
	public void contar () {
		System.out.println("HAY " + hash.size() + "TELEVISORES. ");
	}
	public Televisor buscarClave(String clave) {
		return hash.get(clave);
	}
	public Televisor eliminarClave(String clave) {
		return hash.get(clave);
	}
	
	
	public HashMap< String, Televisor> mostrarClaves(){
	//primera forma
		//for(Televisor t: hash.values()) {
		//	System.out.println("CLAVE : " + t.getModelo());
	//	}
	
		//segunda forma
		
		//Iterator iterador = hash.entrySet().iterator();
		//while(iterador.hasNext());
		//Entry<String, Televisor> entry = (Entry<String, Televisor>) iterador.next();
		//System.out.println("CLAVE : " + entry.getKey());
		
		//tercera forma 
		
		//for (String key: hash.keySet()) {
			
		//	System.out.println("CLAVE : " + key);
		//}
		
		
		//cuarta forma 
		//hash.forEach((key,value) ->{
			//System.out.println("CLAVE : " + key);
		//});
		
		//String cbuscar = "Lhttg";
		//if(hash.containsKey(cbuscar)) {//true si existe el valor y false si no existe
		//	System.out.println("SE HA ENCONTRADO UN VALOR CON LA CLAVE: " + cbuscar);
	//	} else {
		//	System.out.println("NO EXISTE TV CON MODELO " + cbuscar);
		//}
		
		//buscar todas cla tv lg
		HashMap<String, Televisor> aux = new HashMap<String, Televisor>();
		String marca ="SONY";
		for (Televisor t: hash.values()) {
			if(marca.equalsIgnoreCase(t.getMarca())) {//lg coincida con cada objeto en su campo marca
				aux.put(t.getModelo(), t);
			}
		}
		return aux;
		}
}
