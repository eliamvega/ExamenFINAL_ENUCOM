package com.mxProfesionista;

public class Ingeniero extends Profesionista {

	private int experiencia;
	private String lugaresdetrabajo;
	
	
	public Ingeniero () {
		
	}

	public void sonido() {
		System.out.println("HOLA SOY INGENIERO Y SOY MALISIMO PARA LAS MATEMATICAS ");
	}
	

	public Ingeniero(String carrera, String trabajo, String universidad, int años, int experiencia,
			String lugaresdetrabajo) {
		super(carrera, trabajo, universidad, años);
		this.experiencia = experiencia;
		this.lugaresdetrabajo = lugaresdetrabajo;
	}


	@Override
	public String toString() {
		return "Ingeniero [carrera=" + carrera + ", trabajo=" + trabajo + ", universidad=" + universidad + ", años="
				+ años + ", experiencia=" + experiencia + ", lugaresdetrabajo=" + lugaresdetrabajo + "]";
	}


	public int getExperiencia() {
		return experiencia;
	}


	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}


	public String getLugaresdetrabajo() {
		return lugaresdetrabajo;
	}


	public void setLugaresdetrabajo(String lugaresdetrabajo) {
		this.lugaresdetrabajo = lugaresdetrabajo;
	}
	
}
