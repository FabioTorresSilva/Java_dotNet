package org.example;

import java.util.Scanner;

/*
F - Volume de solidos de revolucao

Faca um programa que permita determinar volumes de solidos de revolucao (cilindro, cone e esfera).
Para cada solido será introduzido o tipo de solido e as respetivas dimensoes. O programa termina quando o tipo de solido for a palavra "fim".
Implemente o programa de forma modular.

OBS:
V esfera = 4/3 PI R3
V cilindro = PI R2 Altura
V cone = 1/3 PI R2 Altura
 */

public class Solidos {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        String tipoDeSolido;
        double raio, altura;

        do {
            System.out.printf("Introduza o sólido (esfera, cilindro e cone)\n");
            tipoDeSolido = ler.nextLine();
        }
        while (!tipoDeSolido.equalsIgnoreCase("fim") && !tipoDeSolido.equalsIgnoreCase("esfera") && !tipoDeSolido.equalsIgnoreCase("cilindro") && !tipoDeSolido.equalsIgnoreCase("cone"));

        while (!tipoDeSolido.equalsIgnoreCase("fim")) {

            switch (tipoDeSolido) {
                case "esfera":
                    System.out.printf("Introduza o raio\n");
                    raio = Double.parseDouble(ler.nextLine());
                    System.out.printf("volume da esfera:%.2f\n", volumeDaEsfera(raio));
                    break;
                case "cilindro":
                    System.out.printf("Introduza o raio\n");
                    raio = Double.parseDouble(ler.nextLine());
                    System.out.printf("Introduza a altura\n");
                    altura = Double.parseDouble(ler.nextLine());
                    System.out.printf("volume do cilindro:%.2f\n", volumeDoCilindro(raio, altura));
                    break;
                case "cone":
                    System.out.printf("Introduza o raio\n");
                    raio = Double.parseDouble(ler.nextLine());
                    System.out.printf("Introduza a altura\n");
                    altura = Double.parseDouble(ler.nextLine());
                    System.out.printf("volume do cone:%.2f\n", volumeDoCone(raio, altura));
                    break;
                default:
                    System.out.printf("Sólidos permitidos: esfera, cilindro e cone");
                    break;
            }

            System.out.printf("Introduza o sólido (esfera, cilindro e cone)\n");
            tipoDeSolido = ler.nextLine();
        }
    }

    //========================================================
    public static double volumeDaEsfera(double raio) {
        return 4.0 / 3.0 * Math.PI * Math.pow(raio, 3.0);
    }

    //========================================================
    public static double volumeDoCilindro(double raio, double altura) {
        return Math.PI * Math.pow(raio, 2.0);
    }

    //========================================================
    public static double volumeDoCone(double raio, double altura) {
        return 1.0 / 3.0 * Math.PI * Math.pow(raio, 2.0);
    }

}
