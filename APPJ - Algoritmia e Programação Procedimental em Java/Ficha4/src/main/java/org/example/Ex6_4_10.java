package org.example;

import java.util.Scanner;

public class Ex6_4_10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int num, n;
        do {
            System.out.println("Diga quantas vezes quer calcular a persistência de números:");
            n = ler.nextInt();
        } while (n <= 0);
        for (int i = 1; i <= n; i++) {
            do {
                System.out.println("Introduza um número:");
                num = ler.nextInt();
            } while (num <= 0);
            System.out.printf("A persistência de %d é %d.\n", num, persist(num));
        }
    }

    public static int persist(int x) {
        int cont = 0;
        while (x / 10 != 0) {
            int prod = 1;
            int l = String.valueOf(x).length();
            for (int i = 1; i <= l; i++) {
                prod *= (x % 10);
                x = x / 10;
            }
            x = prod;
            cont++;
        }
        return cont;
    }
}