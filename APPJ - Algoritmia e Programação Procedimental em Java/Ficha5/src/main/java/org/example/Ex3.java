package org.example;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        /*
        a) 100 nomes possiveis
        usario escolhe de entre 3 opcoes, Ler nomes , nome enigma ou temrinar
        lê opcao pretendida
        se ler nomes, lê uma serie de nomes introduzidas pelo user, armazenando-os,
        se ler nome, pede nome
        se terminar, termina programa.

        enquanto n for escolhida terminar programa volta a pedir uma opcao
        */

        int n = 0;
        String nomes[] = new String[100];
        Scanner ler = new Scanner(System.in);
        String m = " 1-Ler Nomes\n2-Enigma Nome\n3-Terminar\n\nEscolha uma opção: ";
        char op;
        do {
            System.out.println(m);
            op = ler.next().charAt(0);
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    System.out.println("Nome:");
                    String nome = ler.nextLine();
                    n = enigma(nomes, nome, n);
                    break;
                case '3':
                    break;
                default:
            }
        } while (op != '3');
    }

    private static int lerNomes(String[] vec) {
        // Lê uma sequência de nomes terminada com a palavra FIM.
        // Armazena os nomes em vec e retorna o número desses nomes.
        int numeroNomesIntroduzidos = 0;
        String[] nomesIntroduzidos = new String[100];
        Scanner ler = new Scanner(System.in);

        while (numeroNomesIntroduzidos <= nomesIntroduzidos.length) {
            System.out.print("Digite um nome (ou FIM para terminar): ");
            String nome = ler.nextLine();
            if( nome.equalsIgnoreCase("FIM")){
                break;
            }
            vec[numeroNomesIntroduzidos] = nome;
            numeroNomesIntroduzidos++;
        }
        return numeroNomesIntroduzidos;
    }

    private static String[] listar(String[] vec, int n) {
        // Apresenta os primeiros n elementos de vec
        String[] auxArray = new String[n];
        if(n> vec.length){
            System.out.printf("n demasiado elevado");
        }else{
            for(int i = 0; i < n; i++){
                System.out.printf("%s", vec[i]);
                auxArray[i]=vec[i];
            }
        }

        return auxArray;
    };

    private static int enigma(String[] nomes, String nome, int n) {
        int i = 0;
        while (i < n && !nomes[i].equalsIgnoreCase(nome)) {
            i++;
        }
        if (i == n)
            return n;
        else {
            for (int j = i; j < n - 1; j++)
                nomes[j] = nomes[j + 1];
            return --n;
        }
    }
}



