package org.example;

import java.util.Scanner;

public class Circulo {
    public static void main(String[] args) {
        double xCentro, yCentro, xA, yA, r, dist;
        int cont = 0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Introduza a coordenada x do seu centro:");
        xCentro = ler.nextDouble();
        System.out.println("Introduza a coordenada y do seu centro:");
        yCentro = ler.nextDouble();
        do {
            System.out.println("Introduza o raio da sua circunferencia:");
            r = ler.nextDouble();
        } while (r <= 0);
        do {
            System.out.println("Introduza a coordenada x do ponto:");
            xA = ler.nextDouble();
            System.out.println("Introduza a coordenada y do ponto:");
            yA = ler.nextDouble();
            dist = Math.sqrt((Math.pow((xA - xCentro), 2)) + (Math.pow((yA - yCentro), 2)));
            if (dist <= r && dist != 0) {
                cont++;
            }
        } while (dist != 0);
        //  while(xA != xCentro || yA != yCentro);

        System.out.printf("Foram introduzidos %d pontos dentro do circulo", cont);
    }
}
