package ordenacaotrocadireta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double numeros []= new double[5];

        preencheVet(numeros);
        ordTrocaDireta(numeros);
        mostravetor(numeros);
    }

    private static void preencheVet(double [] numeros) {
        Scanner ler = new Scanner(System.in);

        for (int i = 0;i<numeros.length;i++) {
            System.out.printf("%dº número:", i+1);
            numeros[i] = ler.nextDouble();
        }
    }

    public static void ordTrocaDireta(double [] vet){
        double aux;
        for (int i = 0;i<vet.length-1;i++)
            for (int j = i+1;j<vet.length;j++)
                if (vet[i] > vet[j]) {
                    aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                }
    }

    public static void mostravetor(double [] vet){
          for (int i = 0;i<vet.length;i++)
            System.out.printf("%.2f\t", vet[i]);
    }
}
