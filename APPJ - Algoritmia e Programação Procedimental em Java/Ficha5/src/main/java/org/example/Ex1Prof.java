package org.example;

import java.util.Scanner;

public class Ex1Prof {

    public static void main(String[] args) {
        int i, s = 0, c = 0, menorNum;
        int[] v = new int[10];
        Scanner ler = new Scanner(System.in);
        for (i = 0; i < v.length; i++) {
            System.out.println("Número?");
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

        } else
            System.out.println("Operação impossível de realizar\n");

        menorNum = menorNumero(v);
        System.out.printf("O menor numero é %d\n", menorNum);
        for (int j = 0; j < v.length; j++) {
            if (menorNum == v[j]) {
                System.out.printf("Na posição %d está armazenado o menor número\n", j + 1);
            }
        }
    }

    public static int menorNumero(int[] arr) {
        int menor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < menor) {
                menor = arr[i];
            }

        }

        return menor;
    }

}

