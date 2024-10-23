package org.example;

import java.util.Scanner;

public class Ex2Prof {
    public static void main(String[] args) {
        final int TAMANHO = 20;
        String[] nomes = new String[TAMANHO];
        int[] vencimentos = new int[TAMANHO];
        int nElems;
        Scanner ler = new Scanner(System.in);

        nElems = lerFuncionarios(nomes, vencimentos);

        listarNomesVencimentoInfMed(nomes, vencimentos, nElems);
        System.out.println("Valor a comparar");
        double valor = ler.nextDouble();
        double perc = percentagemVencInf(vencimentos, nElems, valor);
        System.out.format("Percentagem de funcionários com vencimentos inferiores a %.2f = %.2f%%%n", valor, perc);
    }

    private static double percentagemVencInf(int[] vencimentos, int nElems, double valor) {
        int cont = 0;
        for (int x = 0; x < nElems; x++) {
            if (vencimentos[x] < valor) {
                cont++;
            }
        }
        return (cont * 100) / (double) nElems;
        //  return (double) (cont*100)/ nElems;
    }

    private static void listarNomesVencimentoInfMed(String[] nomes, int[] vencimentos, int nElems) {
        boolean flag = false;
        System.out.println("Nomes dos funcionários com vencimentos inferiores à média");
        double mediaVenc = mediaVencimentos(vencimentos, nElems);

        for (int x = 0; x < nElems; x++) {
            if (vencimentos[x] < mediaVenc) {
                System.out.println(nomes[x]);
                flag = true;
            }
        }
        if (flag == false)
            System.out.printf("Os funcionários têm todos o mesmo vencimento e por isso não faz sentido calcular a média");
    }

    private static double mediaVencimentos(int[] vencimentos, int nElems) {
        int soma = 0;

        for (int x = 0; x < nElems; x++) {
            soma += vencimentos[x];
        }
        return (double) soma / nElems;
    }

    private static int lerFuncionarios(String[] nomes, int[] vencimentos) {
        int nElems = 0;
        Scanner ler = new Scanner(System.in);

        System.out.printf("%dº nome", nElems + 1);
        String nome = ler.nextLine();
        while (!"fim".equalsIgnoreCase(nome) && nElems < nomes.length) {
            nomes[nElems] = nome;
            System.out.printf("%dº vencimento", nElems + 1);
            vencimentos[nElems] = ler.nextInt();
            ler.nextLine();
            nElems++;
            System.out.printf("%dº nome", nElems + 1);
            nome = ler.nextLine();
        }
        return nElems;
    }
}
