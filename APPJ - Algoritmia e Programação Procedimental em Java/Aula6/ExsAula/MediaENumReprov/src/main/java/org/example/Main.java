package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        double[] arr;
        int n;

        do {
            System.out.printf("Introduza a quantidade de números a introduzir\n");
            n = ler.nextInt();
        } while (n <=0);

        arr = new double[n];
        for(int i=0; i<n; i++) {
            System.out.printf("Introduza um número\n");
            arr[i] = ler.nextDouble();
        }

        double soma=0;
        int reprovacoes=0;
        for (int i = 0; i < n; i++) {
            soma += arr[i];
            if(arr[i] < 10)
                reprovacoes++;
        }

        System.out.printf("media=%.1f%n",soma/n);
        System.out.printf("reprovacoes=%d",reprovacoes);

    }
}