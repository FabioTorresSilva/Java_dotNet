package org.example;

/*
D - Combinacoes e permutacoes

Faca um programa em Java que calcule a quantidade de combinacoes e permutacoes possiveis de um conjunto de elementos.

combinacoes de m elementos, n a n (m>=n).
             m!
C(m,n) = -----------
          n! (m-n)!

arranjos de m elementos, n a n (m>=n).
            m!
P(m,n) = ---------
          (m-n)!
//.................................................
Vamos considerar o conjunto A = {1,2,3,4,5}

* As combinacoes (Os subconjuntos) de 2 elementos que podemos formar sao:
{1,2}, {1,3}, {1,4} ,{1,5} ,{2,3} ,{2,4} ,{2,5} ,{3,4}, {3,5}, {4,5}

* Agora vamos formar todos os arranjos possiveis de 2 elementos distintos do conjunto A.

(1,2) (1,3) (1,4) (1,5) (2,3) (2,4) (2,5) (3,4) (3,5) (4,5)
(2,1) (3,1) (4,1) (5,1) (3,2) (4,2) (5,2) (4,3) (5,3) (5,4)

Porque (1,2) != (2,1) ; (1,3) != (3,1) , etc.

 */


import java.util.Scanner;

public class CombPerm {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.printf("Introduza a quantidade de elementos do conjunto de dados (m)\n");
        int m = ler.nextInt();
        System.out.printf("Introduza a quantidade de elementos que queremos combinar\n");
        int n = ler.nextInt();
        if (m >= n) {
            System.out.printf("C(%d,%d)=%d\n", m, n, combinacoes(m, n));
            System.out.printf("A(%d,%d)=%d", m, n, arranjos(m, n));
        } else
            System.out.printf("m não pode ser inferior a n");

    }
//========================================================

    public static int fatorial(int n) {
        int resultado = 1;

        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
//========================================================

    public static int combinacoes(int m, int n) {

        return fatorial(m) / (fatorial(n) * fatorial(m - n));
    }
//========================================================

    public static int arranjos(int m, int n) {

        return fatorial(m) / fatorial(m - n);
    }

}