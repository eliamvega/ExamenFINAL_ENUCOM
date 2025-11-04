package Entidad;

public class Principal {
	
	public static void main(String[] args) {
		
		//array
		
		Vehiculo[] vehiculos = new Vehiculo[4];
		
		//POLIMORFISMO 
		vehiculos[0] = new Vehiculo("VOLKSWAGEN", 2023, "NUEVO");
		vehiculos[1] = new Turismo("TOYOTA", 2026, "USADO",32);
		vehiculos[2] = new Deportivo("VOLKSWAGEN", 2013, "SEMI-NUEVO",8);
		vehiculos[3] = new PickUp("MERCEDES", 2023, "NUEVO",25);
	
		
		
		for (Vehiculo v: vehiculos) {
			System.out.println("**************");
			
			//SOBREESCRITURA DE METODOS
			System.out.println(v.mostrarDatos());
		}
	}

}
