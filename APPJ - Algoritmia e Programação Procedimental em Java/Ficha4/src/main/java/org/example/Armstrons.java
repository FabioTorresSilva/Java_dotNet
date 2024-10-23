package org.example;

import java.util.Scanner;

public class Armstrons {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int limiteMaximo;

        do {
            System.out.printf("Introduza um número limite\n");
            limiteMaximo = ler.nextInt();
        } while (limiteMaximo <= 0);

        System.out.printf("Números de Armstrong abaixo do número %d\n", limiteMaximo);
        for (int i = 0; i < limiteMaximo; i++) {
            if (eNumeroDeArmstrong(i)) {
                System.out.println(i);
            }

        }
    }
//========================================================

    public static boolean eNumeroDeArmstrong(int numero) {
        // 92761 = 1^5 + 6^5 + 7^5 + 2^5 + 9^5
        //184 = 4^3 + 8^3 + 1^3

        int potencia = String.valueOf(numero).length();
        int aux = numero;
        int soma = 0;

        while (aux != 0) {
            int algarismo = aux % 10;
            aux /= 10;
            soma += Math.pow(algarismo, potencia);
        }
        return (soma == numero);
    }
}
