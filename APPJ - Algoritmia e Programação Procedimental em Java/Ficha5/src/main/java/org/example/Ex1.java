package org.example;

import java.util.Scanner;

public class Ex1 {
    //a) A classe inigma, pede 10 numeros ao user
    // de seguida passa por esses numeros e faz a soma dos numeros pares encontrados
    // guarda o numero de ocorrencias par. Por fim se n tiver encontrado nenhum par dá op impossivel
    //senao mostra a media da soma dos numeros pares do array de 10 elementos
    // RESPOSTA: Faz um programa que retorne a media da soma dos pares de 10 algarismos.

    //b)
    public static void main(String[] args) {
        int i, s = 0, c = 0;
        int[] v = new int[10];
        Scanner ler = new Scanner(System.in);
        for (i = 0; i < v.length; i++) {
            System.out.println("Número ?");
            v[i] = ler.nextInt();
        }
        for (i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                s = s + v[i];
                c++;
            }
        }
        if (c != 0) {
            System.out.println(((double) s) / c);
            System.out.printf("Menor Valor introduzido: %d\n", menorDeVetor(v));
            System.out.printf("Ocurrencias desse numero: %d\n", ocurrenciasMenorValor(v, menorDeVetor(v)));
        } else {
            System.out.println("Operação impossível de realizar \n");
            System.out.printf("Menor Valor introduzido: %d\n", menorDeVetor(v));
            System.out.printf("Ocurrencias desse numero: %d\n", ocurrenciasMenorValor(v, menorDeVetor(v)));
        }
    }

    public static int menorDeVetor(int[] vec) {
        int menorValor = vec[0];

        for (int i = 1; i < vec.length; i++)
            if (menorValor > vec[i]) {
                menorValor = vec[i];
            }
        return (menorValor);
    }

    //c) OcurrenciasMenorNumero
    public static int ocurrenciasMenorValor(int[] vec, int menorValor) {
        int ocMenorValor = 0;
        for (int i = 0; i < vec.length; i++) {
            if (menorValor == vec[i]) {
                ocMenorValor++;
            }
        }
        return (ocMenorValor);
    }
}

