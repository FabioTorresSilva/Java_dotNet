package org.example;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String[] funcionarios = new String[20];
        int[] vencimentos = new int[20];
        int contador = 0;
        System.out.printf("Valor Testar\n");
        double valorUser= ler.nextDouble();
        ler.nextLine();

        while (contador < 20) {
            System.out.printf("Nome do Funcionário? %d",contador+1);
            funcionarios[contador] = ler.nextLine();
            if (funcionarios[contador].equalsIgnoreCase("Fim")) {
                break;
            }
            System.out.printf("Vencimento do Funcionário? %d",contador +1);
            vencimentos[contador] = ler.nextInt();
            ler.nextLine();
            contador++;
        }
        salarioMenorMedia(vencimentos,funcionarios);
        percentagemVencimentoInf(vencimentos, valorUser);
    }

    public static void salarioMenorMedia(int[] vencimentos, String[] funcionarios) {
        double somaVencimentos = 0;
        for (int i = 0; i < vencimentos.length; i++) {
            somaVencimentos += vencimentos[i];
        }

        double mediaSalarial = somaVencimentos / vencimentos.length;

        boolean[] aux = new boolean[20];

        for (int i = 0; i < vencimentos.length; i++) {
            if (vencimentos[i] < mediaSalarial) {
                aux[i] = true;
            }
        }

        for (int i = 0; i < vencimentos.length; i++) {
            if (aux[i]) {
                System.out.printf("Funcionario Salario Inf %s\n", funcionarios[i]);
            }
        }
    }

    //% rend inf à media
    public static void percentagemVencimentoInf(int[] vencimentos, double valorUser) {

        boolean[] aux = new boolean[20];

        for (int i = 0; i < vencimentos.length; i++) {
            if (vencimentos[i] < valorUser) {
                aux[i] = true;
            }
        }
        double contInfMedia = 0;
        for (int i = 0; i < vencimentos.length; i++) {
            if (aux[i]) {
                contInfMedia ++;
            }
        }
        System.out.printf("Percentagem Funcionarios com Salario Menor que a Media Salarial: %.2f", (contInfMedia/vencimentos.length)*100);
    }
}
