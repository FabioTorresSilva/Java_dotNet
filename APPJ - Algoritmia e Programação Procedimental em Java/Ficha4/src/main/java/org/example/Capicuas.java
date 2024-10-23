package org.example;

import java.util.Scanner;

public class Capicuas {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int tentativas = 0;
        int num;
        boolean res;

        do {
            System.out.printf("Introduza um número\n");
            num = ler.nextInt();
            tentativas++;
            res = capicua(num);

        } while (res == false && tentativas < 100);

        if (res == true) {
            System.out.printf("O número %d é uma capicua", num);
        } else {
            System.out.println("Não foram introduzidas capicuas");
        }
    }

    //========================================================
    public static boolean capicua(int numero) {
        int aux = numero;
        int result = 0;

        while (aux != 0) {
            int algarismo = aux % 10;
            aux /= 10;
            result = result * 10 + algarismo;
        }
        return (result == numero);
    }
}
