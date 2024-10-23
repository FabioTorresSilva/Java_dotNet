package org.example;

import java.util.Scanner;

public class Disciplinas {
    public static void main(String[] args) {
        int nDisciplinas, nAlunos, neg;

        Scanner ler = new Scanner(System.in);

        System.out.println("Insira o número de alunos");
        nAlunos = ler.nextInt();

        System.out.println("Insira o numero de disciplinas");
        nDisciplinas = ler.nextInt();

        ler.nextLine();//para consumir o enter que nao e consumido no nextInt()

        for (int i = 1; i <= nDisciplinas; i++) {
            String nomeDisp;
            System.out.println("\nNome da disciplina");
            nomeDisp = ler.nextLine();

            do {
                System.out.println("Quantidade de negativas");
                neg = ler.nextInt();
            } while (neg < 0 || neg > nAlunos);

            ler.nextLine();

            System.out.printf("Disciplina: %s\n", nomeDisp);
            System.out.printf("- Positivas: ");

            for (int i2 = 1; i2 <= nAlunos - neg; i2++) {
                System.out.printf("*");
            }
            System.out.println();
            System.out.printf("- Negativas: ");
            for (int i3 = 1; i3 <= neg; i3++) {
                System.out.printf("*");
            }
        }
    }
}
