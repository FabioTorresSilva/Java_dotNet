package org.example;

import java.util.Scanner;

//Lê nums e retorna media aritmetica
public class Ex1Autonomo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double [] vetor = new double [4];
        int contador = 0;
        while (contador < vetor.length) {
            System.out.printf("Insira até 50 numeros (-1 para sair). Numero %d?",contador+1);
            vetor[contador] = ler.nextDouble();
            if (vetor[contador] == -1) {
                break;
            }
            contador++;
        }
        System.out.printf("media vetor %.2f", mediaVetor(vetor));

    }
    
    public static double mediaVetor(double [] vetor){
        double somaValoresVetor = 0;
        for(int i = 0 ; i< vetor.length; i++){
            somaValoresVetor += vetor[i];
        }
        return somaValoresVetor/vetor.length;
    }
}
