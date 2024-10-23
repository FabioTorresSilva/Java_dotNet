package org.example;

public class Perf {

    public static void main(String[] args) {
        for (int y = 1; y <= 10000; y++) {
            if (ePerfeito(y)) {
                System.out.printf("%d é perfeito", y);
            }
        }
    }

    public static boolean ePerfeito(int numero) {
        int somaDiv = 0;
        for (int x = 1; x < numero; x++) {
            if (numero % x == 0) {
                somaDiv = somaDiv + x;
            }
        }
        return (numero == somaDiv);
    }
}