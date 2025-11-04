package com.mxProfesionista;

public class IngenieroEnSistemas extends Profesionista {
	
	private String Lenguaje;
	private String programas;
	
	public IngenieroEnSistemas() {
	}
	
	public void sonido() {
		System.out.println("HOLA SOY EL DE SISTEMAS Y NO SE PROGRMAR :) ");
	}

	public IngenieroEnSistemas(String carrera, String trabajo, String universidad, int años, String lenguaje,
			String programas) {
		super(carrera, trabajo, universidad, años);
		Lenguaje = lenguaje;
		this.programas = programas;
	}

	@Override
	public String toString() {
		return "IngenieroEnSistemas [carrera=" + carrera + ", trabajo=" + trabajo + ", universidad=" + universidad
				+ ", años=" + años + ", Lenguaje=" + Lenguaje + ", programas=" + programas + "]";
	}

	public String getLenguaje() {
		return Lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		Lenguaje = lenguaje;
	}

	public String getProgramas() {
		return programas;
	}

	public void setProgramas(String programas) {
		this.programas = programas;
	}

	
	
}
