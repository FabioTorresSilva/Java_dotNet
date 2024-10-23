package org.example;

/*
I - Elemento de Fibonacci

Elabore um programa para determinar se um numero inteiro introduzido pelo utilizador
e um elemento da sucessao de Fibonacci e qual a sua posicao na sucessao.
Na sucessao de Fibonacci, o primeiro termo e zero (0), o segundo e um (1)
e qualquer um dos outros termos e a soma dos dois anteriores (0,1,1,2,3,5,8,13,21,34,55,89,144,...).

O resultado deve ser visualizado no seguinte formato:
"numero" : "posicao"


 */
/*
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, ...
*/


import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.printf("Introduza um número\n");
        int numero = ler.nextInt();

        if (eDeFibonacci(numero)) {
            System.out.printf("o número %d é um elemento da sucessao de Fibonacci", numero);
        } else {
            System.out.printf("o número %d é um elemento da sucessao de Fibonacci", numero);
        }
    }
//========================================================

    public static boolean eDeFibonacci(int numero) {
        int termo1 = 0;
        int termo2 = 1;

        if (numero < 0) {
            return false;
        }

        if (numero == termo1 || numero == termo2) {
            return true;
        }

        while ((termo1 + termo2) < numero) {
            int aux = termo1 + termo2;
            termo1 = termo2;
            termo2 = aux;
        }
        if ((termo1 + termo2) != numero) {
            return false;
        }
        return true;
    }

}
