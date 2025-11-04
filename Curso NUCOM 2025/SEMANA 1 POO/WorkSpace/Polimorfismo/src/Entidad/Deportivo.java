package Entidad;

public class Deportivo extends Vehiculo{

	private int numDeCilindros;

	public Deportivo(String marca, int modelo, String version, int numDeCilindros) {
		super(marca, modelo, version);
		this.numDeCilindros = numDeCilindros;
	}
	public String mostrarDatos() {
		return "Vehiculo[ marca: " + this.marca + ", version: " + this.version + ", modelo: " + this.modelo + ", numero de cilindros : " + this.numDeCilindros + "]"; 
	}
	public int getNumDeCilindros() {
		return numDeCilindros;
	}

	public void setNumDeCilindros(int numDeCilindros) {
		this.numDeCilindros = numDeCilindros;
	}
	
	
	
}
