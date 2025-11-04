package com.mx.Videojuego;

import java.util.Scanner;

public class Principal {

	public static void main (String args []) {
		
		Videojuego v1 = new Videojuego("Mario Kart", "CARRERAS", "Nintendo", 2025, 1.700);
		Videojuego v2 = new Videojuego("Mario ", "CARRERAS", "Nintendo", 2025, 1.700);
		Videojuego v3 = new Videojuego("MINECRAFT", "SURVIVAL", "MOJANG", 2009, 1.500);
		Videojuego v4 = new Videojuego("Mario Broos", "Animado", "Nintendo", 1985, 1.500);
		
		//crear un auxiliar
		
		Videojuego aux = null;
		
		//instanciar la implementacion
		Implementacion imp = new Implementacion();
		
		//guardar elementos en la lista 
		
		imp.crear(v1);
		imp.crear(v2);
		imp.crear(v3);
		imp.crear(v4);
		/*
		//mostrar
		imp.listar();
		
		//buscar
		aux = imp.buscar(2);
		System.out.println("Videojuego " + aux);
		 
		//eliminar
		aux = imp.buscar(0);
		imp.eliminar(0);
		System.out.println("Videojuego eliminado " + aux.getNombre());
		
		//contar
		imp.contar();*/
		
		
		
		//crear variables locales 
		
		String nombre,genero,compañia;
		int estreno, indice, menuP = 0 ,menuE = 0 ;
		double precio;
		
		Scanner scanner = null;
		
		do {
			menu ();
			scanner = new Scanner(System.in);
			menuP = scanner.nextInt();
			
			switch(menuP) {
			case 1:
				System.out.println("***********************ALTA DE VIDEOJUEGO******************");
				System.out.println("llena los siguientes campos :");
				System.out.println("NOMBRE: ");
				scanner = new Scanner(System.in);
				nombre = scanner.nextLine();
				
				System.out.println("GENERO: ");
				scanner = new Scanner(System.in);
				genero = scanner.nextLine();
				
				System.out.println("COMPAÑIA : ");
				scanner = new Scanner(System.in);
				compañia = scanner.nextLine();
				
				System.out.println("ESTRENO: ");
				scanner = new Scanner(System.in);
				estreno = scanner.nextInt();
				
				System.out.println("PRECIO: ");
				scanner = new Scanner(System.in);
				precio = scanner.nextDouble();
				
				aux = new Videojuego(nombre, genero, compañia, estreno, precio);
				imp.crear(aux);
				System.out.println("SE HA AGREGADO AL VIDEO JUEGO" + aux.getNombre());
				break;
			case 2: System.out.println("**************MOSTRAR VIDEO JUEGOS*************");
			imp.listar();
			break;
			case 3:
				System.out.println("***************BUSCAR VIDEOJUEGOS**************");
			imp.mostrarIndice();
			System.out.println("INGRESA EL INDICE A BUSCAR");
			scanner = new Scanner(System.in);
			indice = scanner.nextInt();
			aux = imp.buscar(indice);
			System.out.println("VIDEOJUEGO LOCALIZADO " + aux);
break;
			case 4 : 
				System.out.println("*******ELIMINAR POR INDICE********");
				imp.mostrarIndice();
				System.out.println("Ingresa el indice a eliminar");
				scanner = new Scanner(System.in);
				indice = scanner.nextInt();
				System.out.println("SE HA ELIMINADO EL VIDEJO JUEGO");
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
System.out.println("1. GENERO" + "\n2. PRECIO" + "\n3. COMPAÑIA " + "\n4. REGRESAR" + "\nElija una opcion");
			scanner = new Scanner(System.in);
			menuE = scanner.nextInt();
		switch(menuE) {
		case 1:
			System.out.println("GENERO: ");
			scanner = new Scanner (System.in);
			genero = scanner.nextLine();
			aux.setGenero(genero);
			break;
		case 2:
			System.out.println("PRECIO: ");
			scanner = new Scanner (System.in);
			precio = scanner.nextDouble();
			aux.setPrecio(precio);
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
				System.out.println("TERMINO DE LA EJECICION.");
				break;
				default:
					System.out.println("ELIJA UNA OPCION VALIDA");

					}
				}while(menuP != 6);
				
			}	
		
	
	

	public static void menu () {
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

