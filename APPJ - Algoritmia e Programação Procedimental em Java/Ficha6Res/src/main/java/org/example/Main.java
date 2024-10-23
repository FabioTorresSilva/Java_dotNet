package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int MAX_LINHAS= 3;
        final int MAX_COLUNAS=4;
        int[][] numeros = new int [MAX_LINHAS][MAX_COLUNAS];

        leMatriz(numeros);

    }

    public static void leMatriz(int[][]numeros) {
        Scanner ler = new Scanner(System.in);
        for(int linha = 0; linha < numeros.length; linha++){
            for(int col = 0; col< numeros[0].length;col++){
                System.out.printf("%4d\t", numeros[linha][col]);
            }
            System.out.printf("\n");
        }
    }
}