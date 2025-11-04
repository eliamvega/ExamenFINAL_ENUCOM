package Entidad;

public class Vehiculo {
protected String marca;
protected int modelo;
protected String version;

public Vehiculo() {
	
}

public Vehiculo(String marca, int modelo, String version) {
	super();
	this.marca = marca;
	this.modelo = modelo;
	this.version = version;
}

@Override
public String toString() {
	return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", version=" + version + "]";
}
public String mostrarDatos() {
	return "Vehiculo[ marca: " + this.marca + ", version: " + this.version + ", modelo: " + this.modelo + "]"; 
}
public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public int getModelo() {
	return modelo;
}

public void setModelo(int modelo) {
	this.modelo = modelo;
}

public String getVersion() {
	return version;
}

public void setVersion(String version) {
	this.version = version;
}	
	
	
	
}
