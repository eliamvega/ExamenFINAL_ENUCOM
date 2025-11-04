package com.mx.Computadora;

import java.util.Scanner;


public class Principal {

	public static void main (String args []) {
		
		Computadora c1 = new Computadora ("INTEL", 2019, "INTEL", 25900);
		Computadora c2 = new Computadora ("ASUS", 2018, "INTEL", 25300);
		Computadora c3 = new Computadora ("HP", 2019, "INTEL", 25000);
		Computadora c4 = new Computadora ("GAMING", 2025, "INTEL", 20500);
		
		
		Computadora aux = null;
		
		Implementacion imp = new Implementacion();
		
		imp.crear(c1);
		imp.crear(c2);
		imp.crear(c3);
		imp.crear(c4);
		
		/*imp.listar ();
		
	aux = imp.buscar(2);
	System.out.println("computadora encontrada " + aux);
	
	aux = imp.buscar(0);
		imp.eliminar(0);
	System.out.println("Computadora eliminada " + aux.getMarca() + " " + aux.getModelo());
	
	imp.contar ();*/
		
		
		
		String marca, compañia;
		double precio;
		int modelo,menuP = 0, menuE = 0, indice;
		
		Scanner scanner = null;
		
		do {
			menu ();
			scanner = new Scanner(System.in);
			menuP = scanner.nextInt();
			
			switch (menuP) {
			case 1:
				
				System.out.println("***********************ALTA DE COMPUTADORAS******************");
				System.out.println("llena los siguientes campos :");
				System.out.println("MARCA: ");
				scanner = new Scanner(System.in);
				marca = scanner.nextLine();
				
				System.out.println("MODELO: ");
				scanner = new Scanner(System.in);
				modelo = scanner.nextInt();
				
				System.out.println("COMPAÑIA: ");
				scanner = new Scanner(System.in);
				compañia = scanner.nextLine();
				
				System.out.println("PRECIO: ");
				scanner = new Scanner(System.in);
				precio = scanner.nextDouble();
				
				aux = new Computadora(marca, modelo, compañia, precio);
				imp.crear(aux);
				System.out.println("SE HA AGREGADO UNA NUEVA COMPUTADORA" + aux.getMarca());
				break;
			case 2: System.out.println("**************MOSTRAR COMPUTADORAS *************");
			imp.listar();
			break;
			case 3:
				System.out.println("***************BUSCAR COMPUTADORAS**************");
			imp.mostrarIndice();
			System.out.println("INGRESA EL INDICE A BUSCAR");
			scanner = new Scanner(System.in);
			indice = scanner.nextInt();
			aux = imp.buscar(indice);
			System.out.println("COMPUTADORA LOCALIZADA " + aux);
           break;
			case 4 : 
				System.out.println("*******ELIMINAR POR INDICE********");
				imp.mostrarIndice();
				System.out.println("Ingresa el indice a eliminar");
				scanner = new Scanner(System.in);
				indice = scanner.nextInt();
				aux = imp.buscar(indice);
				imp.eliminar(indice);
				System.out.println("SE HA ELIMINADO LA COMPUTADORA");
				break;
			case 5:
				System.out.println("*****************EDITAR************");
				imp.mostrarIndice();
				System.out.println("INGRESA EL INDICE PARA EDITAR");
				scanner = new Scanner(System.in);
				indice = scanner.nextInt();
				if (indice < imp.contar() ) {
					aux = imp.buscar(indice);
					System.out.println("EDITARAS: " + aux);
					do {
					System.out.println("********MENU EDITAR********");	
System.out.println("1. MARCA" + "\n2. PRECIO" + "\n3. COMPAÑIA " + "\n4. REGRESAR" + "\nElija una opcion");
			scanner = new Scanner(System.in);
			menuE = scanner.nextInt();
		switch(menuE) {
		case 1:
			System.out.println("MARCA: ");
			scanner = new Scanner (System.in);
			marca = scanner.nextLine();
			aux.setMarca(marca);
			break;
		case 2:
			System.out.println("MODELO: ");
			scanner = new Scanner (System.in);
			modelo = scanner.nextInt();
			aux.setModelo(modelo);
			break;
		case 3:
			System.out.println("COMPAÑIA: ");
			scanner = new Scanner (System.in);
			compañia = scanner.nextLine();
			aux.setCompañia(compañia);
			break;
		case 4:
			System.out.println("ACTUALIZANDO...... ");
			imp.actualizar(indice, aux);
			System.out.println("REGRESANDO AL MENU PRINCIPAL");
			break;
			default:
			System.out.println("ERROR: OPCION INVALIDA, INTENTE NUEVAMENTE");
		}
					}while(menuE !=4);
				}else {
					System.out.println("NO EXISTE EL INDICE" + indice);
				}
			break;
			case 6:
				System.out.println("TERMINO DE LA EJECUCION.");
				break;
				default:
					System.out.println("ELIJA UNA OPCION VALIDA");

					}
				}while(menuP != 6);
				
			}	
			
			
			
		
			
		
		
		
	

	private static void menu() {
		System.out.println("*****************MENU PRINCIPAL**********");
		System.out.println("1. ALTA");
		System.out.println("2. MOSTRAR");
		System.out.println("3. BUSCAR");
		System.out.println("4. ELIMINAR");
		System.out.println("5. EDITAR");
		System.out.println("6. SALIR");
		System.out.println("ELIJA UNA OPCION");
		
	}
}
