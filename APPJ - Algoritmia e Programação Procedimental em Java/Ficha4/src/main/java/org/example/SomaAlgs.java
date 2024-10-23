package org.example;

import java.util.Scanner;

public class SomaAlgs{

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int numero, soma = 0, algarismo;

        numero = ler.nextInt();
        while (numero != 0) {
            algarismo = numero % 10;
            numero /= 10;
            if (algarismo % 2 == 0)
                soma += algarismo;
        }
        System.out.println(soma);
    }
}


