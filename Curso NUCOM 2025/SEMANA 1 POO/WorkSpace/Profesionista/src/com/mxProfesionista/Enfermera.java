package com.mxProfesionista;

public class Enfermera extends Profesionista {

	
	private String hospital;
	private String vacuna;
	
	
	public Enfermera () {	
	}

	public void sonido () {
		System.out.println("HOLA SOY ENFERMERA Y ME DAN MIEDO LAS INYECCIONES ");
	}

	public Enfermera(String carrera, String trabajo, String universidad, int años, String hospital, String vacuna) {
		super(carrera, trabajo, universidad, años);
		this.hospital = hospital;
		this.vacuna = vacuna;
	}


	@Override
	public String toString() {
		return "Enfermera [carrera=" + carrera + ", trabajo=" + trabajo + ", universidad=" + universidad + ", años="
				+ años + ", hospital=" + hospital + ", vacuna=" + vacuna + "]";
	}


	public String getHospital() {
		return hospital;
	}


	public void setHospital(String hospital) {
		this.hospital = hospital;
	}


	public String getVacuna() {
		return vacuna;
	}


	public void setVacuna(String vacuna) {
		this.vacuna = vacuna;
	}
	
	
	
}
