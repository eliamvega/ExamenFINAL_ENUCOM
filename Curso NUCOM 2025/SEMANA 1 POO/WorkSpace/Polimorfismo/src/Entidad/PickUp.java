package Entidad;

public class PickUp extends Vehiculo {

	
	private int capacidadCarga;

	public PickUp(String marca, int modelo, String version, int capacidadCarga) {
		super(marca, modelo, version);
		this.capacidadCarga = capacidadCarga;
	}
	public String mostrarDatos() {
		return "Vehiculo[ marca: " + this.marca + ", version: " + this.version + ", modelo: " + this.modelo + ", capacidad de carga : " + this.capacidadCarga + "]"; 
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	
	
	
	
}
