package org.example;

import java.util.Scanner;

public class Exe3Circulo {
    public static void main(String[] args) {
        double xc,yc,x,y,r,dist;
        int cont = 0;
        Scanner ler= new Scanner(System.in);

        System.out.println("Introduza a coordenada x do centro do círculo:");
        xc = ler.nextDouble();
        System.out.println("Introduza a coordenada y do centro do círculo:");
        yc = ler.nextDouble();
        do {
            System.out.println("Introduza o raio do círculo:");
            r = ler.nextDouble();
        } while(r <=0);
        do{
            System.out.println("Introduza a coordenada x do ponto:");
            x = ler.nextDouble();
            System.out.println("Introduza a coordenada y do ponto:");
            y = ler.nextDouble();
            dist= distancia(xc,yc,x,y);
            if (dist<= r && dist!=0) {
                cont++;
            }
        } while(dist!=0);
      //  while(x != xc || y != yc);

        System.out.printf("Foram introduzidos %d pontos dentro do circulo",cont);
    }

    public static double distancia(double x1,double y1,double x2,double y2) {
        return Math.pow(Math.pow(x2-x1,2) + Math.pow(y2-y1,2),0.5);

    }

}
