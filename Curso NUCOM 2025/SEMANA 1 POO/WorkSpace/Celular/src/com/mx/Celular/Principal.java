package com.mx.Celular;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Principal {
	
	public static void main(String[] args) {
	
		//celular
		Celular c1 = new Celular("MOTOROLA", "MOTOG50", "GRIS", 264, 8, 6800);
		Celular c2 = new Celular ("Nokia", "Lumia 55", "Rojo", 64, 4, 3200);
		Celular c3 = new Celular("IPHONE", "IPHONE 16 PRO MAX", "ROJO CARMECI", 350, 5, 8500);
		Celular c4=  new Celular("Motorola", "G24","Blanco", 256, 64, 8500 );
	
		//crear  la listaa
		List<Celular> celulares = new ArrayList<Celular>();
		
		//objeto auxiliar
		Celular aux = null;
		
		//Agregar los celulares
		
		celulares.add(c1);
		celulares.add(c2);
		celulares.add(c3);
		celulares.add(c4);
		/*
		//mostrar
		System.out.println("Celular encontrado: " + aux);
		
		//eliminar
		aux = celulares.get(1);
		celulares.remove(1);
		System.out.println("Se elimino el celular: " + aux.getMarca() + " " + aux.getModelo());
		System.out.println(celulares);
		
		//vaciar la lista
		
		celulares.clear();
		
		//validar si la lista contiene elementos
		
		if(celulares.isEmpty()) {
			System.out.println("NO EXISTE ELEMENTOS EN LA LISTA" + celulares);
		} else {
			System.out.println("HAY "+ celulares.size() + "celulares.");
		
		}	*/		
		
		//VARIABLE LOCALES
		String marca, modelo, color;
		int almacenamiento, ram, indice = 0, menuP = 0, menuE = 0;
		double precio;
		
		Scanner teclado = null;
		
		do {
			System.out.println("************************************MENU DE CELULAR***************************");
		System.out.println("1. AGREGAR");
		System.out.println("2. MOSTRAR");
		System.out.println("3. BUSCAR");
		System.out.println("4. ELIMINAR");
		System.out.println("5. EDITAR");
		System.out.println("6. S A L I R");
		System.out.println("ELIJA UNA OPCION VALIDA:");
		teclado = new Scanner(System.in);
		menuP = teclado.nextInt();
		
		switch(menuP) {
		case 1:
			System.out.println("***********************************ALTA DE CELULAR************************");
		System.out.println("Ingresa la marca");
		teclado = new Scanner(System.in);
		marca = teclado.nextLine();
		
		System.out.println("Ingresa el modelo del celular");
		teclado = new Scanner(System.in);
		modelo = teclado.nextLine();
		
		System.out.println("Ingresa el color");
		teclado = new Scanner(System.in);
		color = teclado.nextLine();
		
		System.out.println("Digita el almacenamiento");
		teclado = new Scanner(System.in);
		almacenamiento = teclado.nextInt();
		
		System.out.println("Digita la RAM");
		teclado = new Scanner(System.in);
		ram = teclado.nextInt();
		
		System.out.println("Digita el precio");
		teclado = new Scanner(System.in);
		precio = teclado.nextDouble();
		
		// crea el objeto 
		aux = new Celular(marca, modelo, color, almacenamiento, ram, precio);
		
		//agregarlo a la lista
		celulares.add(aux);
		
		System.out.println("EL CELULAR " + aux.getMarca() + " " + aux.getModelo() + "SE HA ALMACENADO CORRECTAMENTE.");
		break;
		case 2:
			System.out.println("************************MOSTAR CELULARES*****************");
			System.out.println(celulares);
			break;
		case 3:
			System.out.println("***********************BUSCAR CELULARES***********************");
		System.out.println("Ingresa el indice a buscar");
			teclado = new Scanner(System.in);
			indice = teclado.nextInt();
			aux = celulares.get(indice);
			System.out.println("Celular localizado" + aux);
			break;
		case 4:
			System.out.println("*************************ELIMINAR CELULAR*****************");
			System.out.println("Ingresa el indice para eliminar:");
			teclado = new Scanner(System.in);
			indice = teclado.nextInt();
			aux = celulares.get(indice);
			celulares.remove(indice);
			System.out.println("SE HA ELIMINADO EL CELULAR " + aux.getMarca() + "" + aux.getModelo());
			break;
		case 5: 
			System.out.println("**************************************EDITAR CELULAR**************************");
			System.out.println("Ingresa el indice a editar");
			teclado = new Scanner(System.in);
			indice = teclado.nextInt();
			
			do {
				System.out.println("************************************* MENU EDITAR****************************");
				System.out.println("1. COLOR" + "\n2. ALMACENAMINETO " + "\n3 PRECIO" + "\n4 REGISTRAR" + "\n5 Ingresa una opcion valida");
			teclado = new Scanner(System.in);
			menuE = teclado.nextInt();
			
			switch(menuE) {
			case 1:
				System.out.println("Ingresa el nuevo color");
				teclado = new Scanner(System.in);
			color = teclado.nextLine();
			aux.setColor(color);
			System.out.println("EL COLOR SE HA ACTUALIZADO.");
				break;
			case 2: 
				System.out.println("Ingresa el almacenamiento");
				teclado = new Scanner(System.in);
			almacenamiento = teclado.nextInt();
			aux.setAlmacenamiento(almacenamiento);
			System.out.println("ALMACENAMIENTO ACTUALIZADO.");
				break;
			case 3: 
				System.out.println("Ingresa el nuevo precio");
				teclado = new Scanner(System.in);
			precio = teclado.nextDouble();
			aux.setPrecio(precio);
			System.out.println("EL PRECIO SE HA ACTUALIZADO.");
				break;
			case 4: 
				System.out.println("ACTUALIZANDO...................");
				celulares.set(indice, aux);
				System.out.println("Regresando al menu principal");
				break;
				default:
					System.out.println("ERROR, OPCION INCORRECTA. ELIGE UNA OPCION VALIDA");
			}
			
			}while(menuE != 4); //cierre de segundo do-while 
			break;
		case 6:
			System.out.println("SALIENDO DE LA APLICACION...................\n ¡HASTA PRONTO!");
		break;
		default:
		}//cierre switch principal
		} while(menuP !=6); //cierre do-while principal
	}// cierre metodo main

}// cierre clase principal
