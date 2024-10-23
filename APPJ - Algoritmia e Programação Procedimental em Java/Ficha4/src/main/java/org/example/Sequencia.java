package org.example;

import java.util.Scanner;

public class Sequencia {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double num, mediaPares, somaTotal = 0;
        int cont = 0;

        do {
            System.out.println("Insira um número positivo");
            num = input.nextDouble();
        } while (num <= 0);

        while (num > 0) {
            //  somaTotal += soma(num);
            somaTotal = somaTotal + soma(num);
            cont++;
            System.out.println("Insira um número positivo");
            num = input.nextDouble();
        }

        if (cont != 0) {
            mediaPares = somaTotal / cont;
            System.out.printf("A média da soma dos divisores pares dos números introduzidos é %.2f", mediaPares);
        } else {
            System.out.println("Não foi introduzido nenhum número com divisores pares");
        }

    }

    public static double soma(double n) {
        double somaTotal = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0 && i % 2 == 0) {
                somaTotal += i;
            }
        }
        return somaTotal;
    }
}