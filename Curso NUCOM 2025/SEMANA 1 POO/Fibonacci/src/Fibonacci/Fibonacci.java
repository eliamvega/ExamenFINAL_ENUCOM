package Fibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 50; // cantidad de números a generar
        long a = 0; // primer número de Fibonacci
        long b = 1; // segundo número de Fibonacci

        System.out.println("Los primeros 50 números de Fibonacci son:");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            long siguiente = a + b;
            a = b;
            b = siguiente;
        }
    }
}
