package Entidad;

public class Ropa {

	private String nombre;
	private String color;
	private int stock;
	private double precio;
	
	public Ropa() {
		
	}

	public Ropa(String nombre, String color, int stock, double precio) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.stock = stock;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Ropa [nombre=" + nombre + ", color=" + color + ", stock=" + stock + ", precio=" + precio + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
}
