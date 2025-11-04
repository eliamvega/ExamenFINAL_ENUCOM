package com.mx.Entidad;

public class Herramienta {
	    private String nombre;
	    private String tipo;  
	    private Double precio;
	    private String descripcion;
	    
		public Herramienta() {
			}

		public Herramienta(String nombre, String tipo, Double precio, String descripcion) {
			super();
			this.nombre = nombre;
			this.tipo = tipo;
			this.precio = precio;
			this.descripcion = descripcion;
		}

		@Override
		public String toString() {
			return "Herramienta [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", descripcion="
					+ descripcion + "]";
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
			this.precio = precio;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		
}
