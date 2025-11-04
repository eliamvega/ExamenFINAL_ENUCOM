package com.mx.Examen1;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Serie[] series = new Serie[5];
        Videojuego[] videojuegos = new Videojuego[5];

        // Crear series completas
        series[0] = new Serie("Breaking Bad", 5, "Drama", "Vince Gilligan");
        series[1] = new Serie("Stranger Things", "Duffer Brothers");
        series[2] = new Serie("Dark", 3, "Misterio", "Baran bo Odar");
        series[3] = new Serie("The Office", 9, "Comedia", "Greg Daniels");
        series[4] = new Serie("Friends", 10, "Comedia", "David Crane");

        // Crear videojuegos completos
        videojuegos[0] = new Videojuego("FIFA 24", 20, "Deportes", "EA Sports");
        videojuegos[1] = new Videojuego("Minecraft", 100, "Sandbox", "Mojang");
        videojuegos[2] = new Videojuego("Zelda TOTK", 80, "Aventura", "Nintendo");
        videojuegos[3] = new Videojuego("Fortnite", 60, "Battle Royale", "Epic Games");
        videojuegos[4] = new Videojuego("Call of Duty", 90, "Accion", "Activision");

        int opcion;

        do {
            System.out.println("\n******** MENU PRINCIPAL ********");
            System.out.println("1. Entregar un videojuego");
            System.out.println("2. Entregar una serie");
            System.out.println("3. Ver cuantos estan entregados y cuales son");
            System.out.println("4. Mostrar videojuego con mas horas");
            System.out.println("5. Mostrar serie con mas temporadas");
            System.out.println("6. Devolver una serie o videojuego");
            System.out.println("7. Mostrar todos los videojuegos");
            System.out.println("8. Mostrar todas las series");
            System.out.println("9. Salir");
            System.out.print("Elige una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Que videojuego quieres entregar? (0-4): ");
                    int posJuego = teclado.nextInt();
                    if (posJuego >= 0 && posJuego < videojuegos.length) {
                        videojuegos[posJuego].entregar();
                        System.out.println("Videojuego entregado.");
                    } else {
                        System.out.println("Posicion invalida.");
                    }
                    break;

                case 2:
                    System.out.print("Que serie quieres entregar? (0-4): ");
                    int posSerie = teclado.nextInt();
                    if (posSerie >= 0 && posSerie < series.length) {
                        series[posSerie].entregar();
                        System.out.println("Serie entregada.");
                    } else {
                        System.out.println("Posicion invalida.");
                    }
                    break;

                case 3:
                    int entregados = 0;
                    System.out.println("Videojuegos entregados:");
                    for (int i = 0; i < videojuegos.length; i++) {
                        if (videojuegos[i].isEntregado()) {
                            System.out.println("[" + i + "] " + videojuegos[i].getTitulo());
                            entregados++;
                        }
                    }
                    System.out.println("Series entregadas:");
                    for (int i = 0; i < series.length; i++) {
                        if (series[i].isEntregado()) {
                            System.out.println("[" + i + "] " + series[i].getTitulo());
                            entregados++;
                        }
                    }
                    System.out.println("Total entregados actualmente: " + entregados);
                    break;

                case 4:
                    Videojuego masHoras = videojuegos[0];
                    for (int i = 1; i < videojuegos.length; i++) {
                        if (videojuegos[i].compareTo(masHoras)                        ) {
                            masHoras = videojuegos[i];
                        }
                    }
                    System.out.println("Videojuego con mas horas estimadas:");
                    System.out.println(masHoras);
                    break;

                case 5:
                    Serie masTemporadas = series[0];
                    for (int i = 1; i < series.length; i++) {
                        if (series[i].compareTo(masTemporadas) > 0) {
                            masTemporadas = series[i];
                        }
                    }
                    System.out.println("Serie con mas temporadas:");
                    System.out.println(masTemporadas);
                    break;

                case 6:
                    System.out.print("Que deseas devolver? (1 = Videojuego, 2 = Serie): ");
                    int tipo = teclado.nextInt();
                    System.out.print("En que posicion (0-4)? ");
                    int pos = teclado.nextInt();
                    if (tipo == 1 && pos >= 0 && pos < videojuegos.length) {
                        videojuegos[pos].devolver();
                        System.out.println("Videojuego devuelto.");
                    } else if (tipo == 2 && pos >= 0 && pos < series.length) {
                        series[pos].devolver();
                        System.out.println("Serie devuelta.");
                    } else {
                        System.out.println("Tipo o posicion invalida.");
                    }
                    break;

                case 7:
                    System.out.println("Listado de todos los videojuegos:");
                    for (int i = 0; i < videojuegos.length; i++) {
                        System.out.println("[" + i + "] " + videojuegos[i]);
                    }
                    break;

                case 8:
                    System.out.println("Listado de todas las series:");
                    for (int i = 0; i < series.length; i++) {
                        System.out.println("[" + i + "] " + series[i]);
                    }
                    break;

                case 9:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 9);

        teclado.close();
    }
}