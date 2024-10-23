package org.example;

import java.util.Scanner;

public class ex1 {

    public static void main(String[] args) {
        final int MAX_lINHAS = 3;
        final int MAX_COLUNAS = 4;
        int[][] numeros = new int[MAX_lINHAS][MAX_COLUNAS];

        leMatriz(numeros);
        imprimeMatriz(numeros);
        System.out.println("----------------------------------------------");
        linhasMaxPar(numeros);
    }

    public static void leMatriz(int[][] numeros) {
        Scanner ler = new Scanner(System.in);
        for (int linha = 0; linha < numeros.length; linha++) {
            for (int coluna = 0; coluna < numeros[0].length; coluna++) {
                System.out.printf("[%d,%d]=",linha+1,coluna+1);
                numeros[linha][coluna]=ler.nextInt();
            }
        }
    }

    public static void imprimeMatriz(int[][] numeros) {
        System.out.println("----------------------------------------------");
        for (int linha = 0; linha < numeros.length; linha++) {
            for (int col = 0; col < numeros[0].length; col++) {
                System.out.printf("%4d\t", numeros[linha][col]);
            }
            System.out.printf("\n");
        }
    }

    public static void linhasMaxPar(int[][] numeros) {
        int maisPares = 0, numPares;
        for (int linha = 0; linha < numeros.length; linha++) {
            numPares = 0;
            for (int coluna = 0; coluna < numeros[0].length; coluna++) {
                if (numeros[linha][coluna] % 2 == 0) {
                    numPares++;
                }
            }
            if (numPares > maisPares) {
                maisPares = numPares;
            }
        }
        if (maisPares != 0) {
            System.out.println("Linha(s) com maior número de números pares:");
            for (int linha = 0; linha < numeros.length; linha++) {
                numPares = 0;
                for (int coluna = 0; coluna < numeros[0].length; coluna++) {
                    if (numeros[linha][coluna] % 2 == 0) {
                        numPares++;
                    }
                }
                if (numPares == maisPares) {
                    System.out.println(linha + 1);
                }
            }
        }
        else {
            System.out.println("A matriz não tem números pares");
        }
    }

}


