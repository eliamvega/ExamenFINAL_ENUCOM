package com.mx.Electrodomestico;

import java.util.Scanner;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Implementacion imp = new Implementacion();
        Electrodomestico aux = null;

        // GUARDAMOS 
        imp.guardar(new Electrodomestico("LG", "REF123", "Plata", 110, 1500, 7500));
        imp.guardar(new Electrodomestico("Samsung", "MICRO456", "Negro", 220, 800, 2500));
        imp.guardar(new Electrodomestico("Whirlpool", "LAV789", "Blanco", 110, 1800, 9800));
        imp.guardar(new Electrodomestico("Mabe", "ESTUF321", "Gris", 220, 2000, 5600));

        int opcion = 0;

        do {
            menu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println(" ALTA DE ELECTRODOMESTICO:");
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Modelo (clave única): ");
                    String modelo = scanner.nextLine();

                    System.out.print("Color: ");
                    String color = scanner.nextLine();

                    System.out.print("Voltaje: ");
                    double voltaje = scanner.nextDouble();

                    System.out.print("Potencia: ");
                    double potencia = scanner.nextDouble();

                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    aux = new Electrodomestico(marca, modelo, color, voltaje, potencia, precio);
                    imp.guardar(aux);
                    break;

                case 2:
                    System.out.println(" LISTA DE ELECTRODOMESTICOS:");
                    imp.mostrar();
                    break;

                case 3:
                    System.out.println(" BUSCAR:");
                    System.out.println("1. Por modelo (clave)");
                    System.out.println("2. Por marca");
                    int subOpcion = scanner.nextInt();
                    scanner.nextLine();

                    if (subOpcion == 1) {
                        System.out.print("Ingresa el modelo: ");
                        String clave = scanner.nextLine();
                        Electrodomestico encontrado = imp.buscarPorClave(clave);
                        System.out.println(encontrado != null ? encontrado : " No se encontro.");
                    } else if (subOpcion == 2) {
                        System.out.print("Ingresa la marca: ");
                        String m = scanner.nextLine();
                        List<Electrodomestico> lista = imp.buscarPorMarca(m);
                        if (lista.isEmpty()) {
                            System.out.println(" No se encontraron electrodomésticos con esa marca.");
                        } else {
                            for (Electrodomestico e : lista) {
                                System.out.println(e);
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println(" ELIMINAR:");
                    System.out.println("1. Por modelo (clave)");
                    System.out.println("2. Por marca");
                    System.out.println("3. Eliminar todos");
                    int tipoEliminacion = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoEliminacion == 1) {
                        System.out.print("Ingresa el modelo: ");
                        String clave = scanner.nextLine();
                        aux = new Electrodomestico();
                        aux.setModelo(clave);
                        imp.eliminar(aux);
                    } else if (tipoEliminacion == 2) {
                        System.out.print("Ingresa la marca: ");
                        String m = scanner.nextLine();
                        imp.eliminarPorMarca(m);
                    } else if (tipoEliminacion == 3) {
                        imp.eliminarTodo();
                    }
                    break;

                case 5:
                    System.out.print(" EDITAR: Ingresa el modelo a editar: ");
                    String modeloEditar = scanner.nextLine();
                    Electrodomestico editado = imp.buscarPorClave(modeloEditar);
                    if (editado != null) {
                        System.out.println("EDITANDO: " + editado);
                        System.out.print("Nueva marca: ");
                        editado.setMarca(scanner.nextLine());

                        System.out.print("Nuevo color: ");
                        editado.setColor(scanner.nextLine());

                        System.out.print("Nuevo voltaje: ");
                        editado.setVoltaje(scanner.nextDouble());

                        System.out.print("Nueva potencia: ");
                        editado.setPotencia(scanner.nextDouble());

                        System.out.print("Nuevo precio: ");
                        editado.setPrecio(scanner.nextDouble());
                        scanner.nextLine();

                        imp.editar(editado);
                    } else {
                        System.out.println(" No se encontró ese modelo.");
                    }
                    break;

                case 6:
                    System.out.println("TOTAL: Hay " + imp.contar() + " electrodomesticos.");
                    break;

                case 7:
                    System.out.println("Finalizando programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    public static void menu() {
        System.out.println("\nMENU DE ELECTRODOMESTICOS:");
        System.out.println("1. Alta (no repetir clave)");
        System.out.println("2. Mostrar");
        System.out.println("3. Buscar");
        System.out.println("4. Eliminar");
        System.out.println("5. Editar");
        System.out.println("6. Contar");
        System.out.println("7. Salir");
        System.out.print("Elige una opcion: ");
    }
}
