package com.mx.Principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main (String [] args ){
		
		//PELICULAS 
		
		Pelicula p1 = new Pelicula ("MINECRAFT", "ACCION Y FICCION", "ESPAÑOL", "3:30HRS",10.50,"10/07/2025");
		Pelicula p2 = new Pelicula ("STAR WARS", "ACCION Y FICCION", "INGLES Y ESPAÑOL", "2:30HRS", 5.65,"16/07/2025");
		Pelicula p3 = new Pelicula ("COMO ENTRENAR A TU DRAGON", "FAMILIAR", "ESPAÑOL", "2:30HRS",10.50,"19/07/2025");
		Pelicula p4 = new Pelicula ("FORMULA 1", "ACCION", "ESPAÑOL", "1:30HRS",7.50,"10/07/2025");
		Pelicula p5 = new Pelicula ("FUERZA REGIDA Y SU BANDA ", "ACCION", "ESPAÑOL ", "2:30HRS",10.50,"10/07/2025");
		Pelicula p6 = new Pelicula ("EL CHAVAL", "INFANTIL", "ESPAÑOL", "2:40HRS",8.50,"16/07/2025");
		
		Pelicula aux = null;
		
		//crear lista 
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		//VALIABLE LOCALES 
		//agregar 
		peliculas.add(p1);
		peliculas.add(p2);
		peliculas.add(p3);
		peliculas.add(p4);
		peliculas.add(p5);
		peliculas.add(p6);
		
		String nombre,categoria,lenguaje,duracion,fecha;
		double precio;
		int indice = 0, menuP = 0, menuE = 0;
		
		Scanner teclado =  null;
		do {
			System.out.println("*******************MENU PELICULAS*****************");
			System.out.println("1. AGREGAR");
			System.out.println("2. BUSCAR");
			System.out.println("3. MOSTRAR");
			System.out.println("4. ELIMINAR");
			System.out.println("5. EDITAR");
			System.out.println("6. SALIR");
			teclado = new Scanner(System.in);
			menuP = teclado.nextInt();
			
			
			switch(menuP) {
			
			case 1:
				System.out.println("********************ALTA DE PELICULA***************");
				System.out.println("INGRESA EL NOMBRE DE LA PELICULA");
				teclado = new Scanner(System.in);
				nombre = teclado.nextLine();
				
				System.out.println("INGRESA LA CATEGORIA DE LA PELICULA");
				teclado = new Scanner(System.in);
				categoria = teclado.nextLine();
				
				System.out.println("INGRESA EL LENGUAJE DE LA PELICULA ");
				teclado = new Scanner(System.in);
				lenguaje = teclado.nextLine();
				
				System.out.println("INGRESA LA DURACION DE LA PELICULA");
				teclado = new Scanner(System.in);
				duracion = teclado.nextLine();
				
				System.out.println("INGRESA EL PRECIO DE LA PELICULA");
				teclado = new Scanner(System.in);
				precio = teclado.nextDouble();
				
				System.out.println("INGRESA LA FECHA DE ESTRENO DE LA PELUCULA");
				teclado = new Scanner(System.in);
				fecha = teclado.nextLine();
				
				//crear el objeto aux
				
				aux = new Pelicula (nombre,categoria,lenguaje,duracion,precio,fecha);
				//agregarlo a la lista 
				peliculas.add(aux);
				
				System.out.println("LA PELICULA " + aux.getNombre() + " DE CATEGORIA " + aux.getCategoria() + "SE HA AGREGADO CORRECTAMENTE");
				break;
			case 2:
			    System.out.println("***********************BUSCAR PELICULAS***********************");
			    System.out.println("Ingresa el índice a buscar:");
			    teclado = new Scanner(System.in);
			    indice = teclado.nextInt();

			    try { //valida antes de entrar 
			        if (indice < 0 || indice >= peliculas.size()) {
			            throw new IndiceInvalidoException("El índice " + indice + " está fuera de rango.");
			        }

			        aux = peliculas.get(indice);
			        System.out.println("Película localizada: " + aux);
			        
			    } catch (IndiceInvalidoException e) {
			        System.out.println("INDICE INVALIDO: " + e.getMessage());
			    }
			    break;
			case 3:
				System.out.println("************************MOSTAR CELULARES*****************");
				System.out.println(peliculas);
			   
			    break;
			case 4:
				System.out.println("***************ELIMINAR PELICULA**************");
				System.out.println("Ingresa el indice a eliminar ");
				teclado = new Scanner(System.in);//limpia la variable
				try {
				indice = teclado.nextInt();// detecta lo que escribiste en teclado y lo almacena en la variable indice 
				}catch (InputMismatchException e) {
					System.out.println("OPCION INVALIDA NO PUEDES PODER OTRA COSA QUE NO SEA UN NUMERO VALIDO (0-5) " + e.getMessage());
				}
				try {
					
				aux = peliculas.get(indice);
				peliculas.remove(indice);
				}catch (IndexOutOfBoundsException e) {
					System.out.println("EL INDICE NO ES VALIDO VUELVE A INTENTARLO CON UN INDICE VALIDO " + e.getMessage());
					
				}
			try { 
				System.out.println("SE HA ELIMINADO LA SIGUINETE PELICULA" + " " + aux.getNombre() + "DE CATEGORIA" + aux.getCategoria() );
			}catch (NullPointerException e) {
				System.out.println("EL INDICE NO EXISTE POR LO TANTO NO SE ELIMINO LA PELICULA " + e.getMessage());
			}
				break;
			case 5: // por ejemplo: EDITAR
			    if (peliculas.isEmpty()) {
			        System.out.println("No hay películas registradas.");
			        break;
			    }

			    // Mostrar películas disponibles
			    System.out.println("Películas registradas:");
			    for (int i = 0; i < peliculas.size(); i++) {
			        System.out.println(i + ": " + peliculas.get(i));
			    }

			    // Seleccionar película a editar
			    System.out.println("Ingresa el índice de la película que deseas editar:");
			    teclado = new Scanner(System.in);
			    indice = teclado.nextInt();

			    if (indice >= 0 && indice < peliculas.size()) {
			        aux = peliculas.get(indice); // Selecciona la película
			    } else {
			        System.out.println("Índice inválido. Regresando al menú principal.");
			        break;
			    }

			    // Inicia el submenú de edición
			    do {
			        System.out.println("************************************* MENU EDITAR ****************************");
			        System.out.println("1. NOMBRE\n2. CATEGORÍA\n3. LENGUAJE\n4. REGISTRAR CAMBIOS\n5. OPCIÓN INVÁLIDA");

			        teclado = new Scanner(System.in);
			        menuE = teclado.nextInt();

			        switch (menuE) {
			            case 1:
			                if (aux != null) {
			                    System.out.println("Ingresa el nuevo nombre:");
			                    teclado.nextLine(); // Limpiar buffer
			                    nombre = teclado.nextLine();
			                    aux.setNombre(nombre);
			                    System.out.println("✅ EL NOMBRE SE HA ACTUALIZADO.");
			                }
			                break;

			            case 2:
			                if (aux != null) {
			                    System.out.println("Ingresa la categoría:");
			                    teclado.nextLine(); // limpiar buffer si venía de nextInt()
			                    categoria = teclado.nextLine();
			                    aux.setCategoria(categoria);
			                    System.out.println("✅ CATEGORÍA ACTUALIZADA.");
			                }
			                break;

			            case 3:
			                try {
			                    System.out.println("Ingresa un lenguaje (español, inglés o francés):");
			                    teclado.nextLine(); // limpiar buffer
			                    lenguaje = teclado.nextLine().toLowerCase().trim();

			                    if (!lenguaje.equals("español") && !lenguaje.equals("inglés") && !lenguaje.equals("francés")) {
			                        throw new LenguajeInvalidoException("Idioma no permitido.");
			                    }

			                    aux.setLenguaje(lenguaje);
			                    System.out.println("✅ LENGUAJE ACTUALIZADO.");
			                } catch (LenguajeInvalidoException e) {
			                    System.out.println("❌ ERROR: " + e.getMessage());
			                }
			                break;

			            case 4:
			                peliculas.set(indice, aux);
			                System.out.println("✅ CAMBIOS GUARDADOS. REGRESANDO AL MENÚ PRINCIPAL...");
			                break;

			            default:
			                System.out.println("❌ OPCIÓN NO VÁLIDA. INTENTA NUEVAMENTE.");
			        }
			    } while (menuE != 4);
			    break;
			case 6:
				System.out.println("SALIENDO DE LA APLICACION...................\n ¡HASTA PRONTO!");
			break;
			default:
				
			}
			
			
		}while (menuP != 6);
	}
	
	
}
