package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        final int MAX=20;
        double[] arr = new double[MAX];
        double numero;
        int n = 0;
        System.out.printf("Introduza um número\n");
        numero = ler.nextDouble();
        while (numero > 0 && n<MAX) {
            arr[n++] = numero;
            System.out.printf("Introduza um número\n");
            numero = ler.nextDouble();
        }

        if (n > 0) {
            double min = arr[0];
            int qtd = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    qtd = 1;
                } else {
                    if (arr[i] == min) {
                        qtd++;
                    }
                }
            }
            System.out.printf("Menor número introduzido=%.2f\n",min);
            System.out.printf("Número de ocorrencias=%d",qtd);
        }
        else
            System.out.printf("Não foram introduzidos números possitivos");
    }
}