package org.example;

import java.util.Scanner;

/*
C - Calcular angulos de um triangulo

a) Faca um metodo (calcAng) que calcule um angulo interno de um triangulo (em graus),
sendo dadas as medidas dos tres lados desse triangulo.

b) Pedidas as medidas de tres lados, verifique se elas sao validas e se e possivel formar um triangulo.
Em caso afirmativo calcule todos os angulos internos desse triangulo.
Para isso chame tres vezes o metodo desenvolvido na alinea anterior.

Nota: Os resultados deverao ser apresentados em linhas separadas e apenas os valores
dos angulos arredondados as unidades. No caso de o triangulo nao ser possivel, a mensagem devera ser: "impossivel".
 */

public class Angulos {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.printf("Introduza o comprimento de um lado do triangulo\n");
        int a = ler.nextInt();
        System.out.printf("Introduza o comprimento de um lado do triangulo\n");
        int b = ler.nextInt();
        System.out.printf("Introduza o comprimento de um lado do triangulo\n");
        int c = ler.nextInt();

        if ((a > 0 && b > 0 && c > 0) && ((a < b + c) && (b < a + c) && (c < a + b))) {
            System.out.println("a=" + a);
            System.out.println("b=" + b);
            System.out.println("c=" + c);
            System.out.println("ang(a,b)=" + calcAng(a, b, c));
            System.out.println("ang(a,c)=" + calcAng(a, c, b));
            System.out.println("ang(b,c)=" + calcAng(b, c, a));
        } else {
            System.out.println("impossivel");
        }
    }

    //========================================================
    public static int calcAng(int a, int b, int c) {
        double formula = (a * a + b * b - c * c) / (double) (2 * a * b);
        double resultadoRadianos = Math.acos(formula);
        return (int) (resultadoRadianos * 180 / Math.PI);
    }
}


