package org.example;

import java.util.Scanner;

public class ExA4_4_10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int x;
        do {
            System.out.println("Introduza um número");
            x = ler.nextInt();
            if (octal(x)) {
                System.out.printf("%d é octal.\n", x);
                System.out.printf("Decimal de %d é %d\n", x, octalToDecimal(x));
            }
        } while (octal(x));
        System.out.printf("%d não é octal.", x);
    }

    public static boolean octal(int x) {
        boolean octal = true;
        while (x != 0) {
            if (x % 10 >= 0 && x % 10 < 8) {
                x /= 10;
            } else {
                octal = false;
                break;
            }
        }
        return octal;
    }

    public static int octalToDecimal(int x) {
        int sum = 0;
        int pow = 0;
        while (x != 0) {
            sum += (int) ((x % 10) * Math.pow(8, pow));
            x /= 10;
            pow++;
        }
        return sum;
    }
}