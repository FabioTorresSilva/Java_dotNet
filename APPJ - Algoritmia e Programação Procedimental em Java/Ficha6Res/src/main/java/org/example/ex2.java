package org.example;

/*
a)  Desenvolva um método em Java que recebe como argumento uma matriz de números inteiros e
apresente ao utilizador os elementos da(s) coluna(s) com maior média aritmética.
b) Elabore um programa em Java para testar o método desenvolvido na alínea a). Deverá usar um
método para preencher a matriz.
*/

import java.util.Scanner;

public class ex2 {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int linhas, colunas;

        System.out.println("Qual o número de linhas e colunas da matriz ?");
        linhas = ler.nextInt();
        colunas = linhas;
        int[][] mat = new int[linhas][colunas];

        inserirElementos(mat);
    }

    public static void inserirElementos(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("[%d,%d]=", i + 1, j + 1);
                m[i][j] = ler.nextInt();
            }
        }
    }

    public static void mediaColuna(int[][] m) {
        int maxMedia = 0;
        int somas = 0;
        int auxSomas = 0;
        // este loop vê qual a media maior encontrada
        for (int j = 0; j < m.length; j++) { // Para cada coluna
            int soma = 0;
            for (int i = 0; i < m.length; i++) { // Para cada linha
                auxSomas += m[i][j]; // Adiciona o valor da linha atual da coluna
            }
            if (auxSomas > soma) {
                soma = auxSomas;
                maxMedia = soma / m.length;
            }
        }
        //este loop procura por os elementos com essa media
        for (int j = 0; j < m.length; j++) {
            int soma = 0;
            for (int i = 0; i < m.length; i++) {
                soma += m[i][j]; // Sum the values of the current column again
            }
            double media = (double) soma / m.length; // Calculate the average again
            if (media == maxMedia) {
                System.out.printf("Coluna %d\n", j + 1);
            }
        }
    }
}
