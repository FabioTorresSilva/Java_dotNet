package org.upskill;

import java.util.Scanner;

public class Main {

    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int vitoriasJog1 = 0;
        int vitoriasJog2 = 0;
        int jogada = 0;
        Sinal jogadaJogador1;
        Sinal jogadaJogador2;
        int MAXVITORIAS = 3;


        while (vitoriasJog2 < MAXVITORIAS && vitoriasJog1 < MAXVITORIAS) {
            jogada++;
            System.out.println("Rodada" + jogada);
            System.out.println("Jogador 1");
            System.out.println("[1]Pedra [2]Papel [3]Tesoura");
            jogadaJogador1 = lerJogada(ler.nextInt());
            System.out.println("Jogador 2");
            System.out.println("[1]Pedra [2]Papel [3]Tesoura");
            jogadaJogador2 = lerJogada(ler.nextInt());

            if (jogadaJogador1 == jogadaJogador2) {
                System.out.println("Empate");
            } else if (jogadaJogador1.vence(jogadaJogador2)) {
                vitoriasJog1++;
                System.out.println("Jogador 1 vence rodada");
            } else if (jogadaJogador2.vence(jogadaJogador1)) {
                vitoriasJog2++;
                System.out.println("Jogador 2 vence rodada");
            }
        }
        if (vitoriasJog2 == 3) {
            System.out.println("Jogador 2 ganhou a partida");
        } else if (vitoriasJog1 == 3) {
            System.out.println("Jogador 1 ganhou a partida.");
        }
    }

    public static Sinal lerJogada(int escolha) {
        switch (escolha) {
            case 1:
                return Sinal.PEDRA;
            case 2:
                return Sinal.PAPEL;
            case 3:
                return Sinal.TESOURA;
            default:
                return null;
        }
    }
}