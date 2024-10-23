package org.example;

/*
A - Palindromo

Faca um programa que leia uma sequencia de palavras ate encontrar um palindromo
*palavra cuja leitura da esquerda para a direita é igual à da direita para a esquerda.
O programa deve mostrar a quantidade de palavras lidas que antecedem o palindromo.
NOTA: Utilize um metodo para verificar se uma palavra é palindromo.
 */


import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String palavra = "";
        int qtdPavarasLidas = 0;

        while (palavra.isEmpty() || !palindromo(palavra)) {
            System.out.printf("Introduza uma palavra \n");
            palavra = ler.next();
            qtdPavarasLidas++;
        }
        System.out.printf("Foram introduzidas %d palavras antes de ser introduzido um palindromo", qtdPavarasLidas - 1);

    }
//========================================================

    public static boolean palindromo(String palavra) {
        palavra = palavra.toLowerCase();

        int indiceDaEsquerda = 0;
        int indiceDaDireita = palavra.length() - 1;
        while (indiceDaEsquerda < indiceDaDireita) {
            if (palavra.charAt(indiceDaEsquerda) != palavra.charAt(indiceDaDireita)) {
                return false;
            }
            indiceDaEsquerda++;
            indiceDaDireita--;
        }
        return true;

    }
}