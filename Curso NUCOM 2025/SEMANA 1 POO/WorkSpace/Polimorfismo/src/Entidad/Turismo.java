package Entidad;

public class Turismo extends Vehiculo{

	
	private int numAsientos;

	public Turismo(String marca, int modelo, String version, int numAsientos) {
		super(marca, modelo, version);
		this.numAsientos = numAsientos;
	}
	public String mostrarDatos() {
		return "Vehiculo[ marca: " + this.marca + ", version: " + this.version + ", modelo: " + this.modelo + ", numero de asientos: " + this.numAsientos + "]"; 
	}
	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}
	
	
}
