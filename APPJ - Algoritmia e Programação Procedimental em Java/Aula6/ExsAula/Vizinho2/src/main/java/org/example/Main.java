package org.example;

import java.util.Scanner;

public class Main {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[7];
        ler(arr);
        verResultados(arr);
    }

    public static void ler(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Introduza um número inteiro");
            arr[i] = ler.nextInt();
        }
    }

    public static void verResultados(int[] arr) {
        boolean existe=false;
        System.out.println("Resultado:");
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.println(arr[i]);
                existe=true;
            }
        }
        if (existe ==false)
            System.out.printf("Nenhum número introduzido é maior que os seus vizinhos");
    }

}