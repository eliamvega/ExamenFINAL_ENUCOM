package Entidad;

public class Herramienta {

	private int codigo;
	private String nombre;
	private String marca;
	private String usos;
	private int stock;
	private double precio;

	public Herramienta() {
		
	}

	public Herramienta(int codigo, String nombre, String marca, String usos, int stock, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.usos = usos;
		this.stock = stock;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Herramienta [codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", usos=" + usos
				+ ", stock=" + stock + ", precio=" + precio + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUsos() {
		return usos;
	}

	public void setUsos(String usos) {
		this.usos = usos;
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
