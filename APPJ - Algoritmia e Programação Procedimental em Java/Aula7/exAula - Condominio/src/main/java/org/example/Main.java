package org.example;

import java.util.Scanner;

/*
I - Condom�nio
Considere um pr�dio de apartamentos com 3 entradas e 4 pisos, completamente ocupados.
Fa�a um programa modular que leia o nome do propriet�rio de cada um dos apartamentos.
De seguida, o programa deve ler um dado nome inserido pelo utilizador e indicar qual � a respetiva entrada e piso, no seguinte formato:
"nome=<nome>"
"entrada=<n� da entrada>"
"piso=<n� do piso>"

Caso n�o exista essa pessoa no pr�dio, deve imprimir a mensagem ?Nao existe?.

 */

public class Main {
    static Scanner ler = new Scanner(System.in);
    static final int ENTRADAS = 3;
    static final int PISOS = 4;

    public static void main(String[] args) {

        String[][] predio = new String[ENTRADAS][PISOS];
        lerNomesDosCondominos(predio);

        System.out.printf("Introduza o nome do propriet�rio\n");
        String nome = ler.nextLine();
        mostrarEntradaPisoNoPredio(predio, nome);
    }

    public static void lerNomesDosCondominos(String[][] predio) {
        for (int e = 0; e < ENTRADAS; e++) {
            for (int p = 0; p < PISOS; p++) {
                System.out.printf("Nome do propriet�rio da entrada=%d e piso=%d?\n",e+1,p+1);
                predio[e][p] = ler.nextLine();
            }
        }
    }

    public static void mostrarEntradaPisoNoPredio(String[][] predio, String nome) {
        boolean encontrou = false;

        for (int e = 0; e < ENTRADAS; e++) {
            for (int p = 0; p < PISOS; p++) {
                if (nome.equalsIgnoreCase(predio[e][p])) {
                    System.out.printf("nome=%s\n",nome);
                    System.out.printf("entrada=%d\n",e+1);
                    System.out.printf("piso=%d\n",p+1);
                    encontrou = true;
                    break;
                }
            }
        }
        if (!encontrou) {
            System.out.println("Nao mora no predio");
        }
    }
}