package com.mxProfesionista;

public class Profesionista {

	
	protected String carrera;
	protected String trabajo;
	protected String universidad;
	protected int años;
	
	public Profesionista () {
	}

	public void sonido() {
		System.out.println("LA FRASE DEL PROFESIONISTA : ");
	}
	public Profesionista(String carrera, String trabajo, String universidad, int años) {
		super();
		this.carrera = carrera;
		this.trabajo = trabajo;
		this.universidad = universidad;
		this.años = años;
	}

	@Override
	public String toString() {
		return "Profesionista [carrera=" + carrera + ", trabajo=" + trabajo + ", universidad=" + universidad + ", años="
				+ años + "]";
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public int getAños() {
		return años;
	}

	public void setAños(int años) {
		this.años = años;
	}
	
	
	
	
	
}
