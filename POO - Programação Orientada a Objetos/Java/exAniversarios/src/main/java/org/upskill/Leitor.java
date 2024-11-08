package org.upskill;

import java.util.Scanner;

public final class Leitor {

    private Leitor() {}

    public static Data lerDataValidaDaConsola() {
        Scanner scanner = new Scanner(System.in);
        int ano = 0, mes = 0, dia = 0;

        while (true) {
            try {
                System.out.print("Insira o ano: ");
                ano = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Insira o mês: ");
                mes = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Insira o dia: ");
                dia = Integer.parseInt(scanner.nextLine().trim());

                Data data = new Data(ano, mes, dia);
                System.out.println("Data válida inserida.");
                return data;

            } catch (NumberFormatException e) {
                System.out.println("Erro: Insira apenas números.");
            } catch (MesInvalidoException e) {
                System.out.println("Erro: Mês inválido. O mês deve estar entre 1 e 12.");
            } catch (DiaInvalidoException e) {
                System.out.println("Erro: Dia inválido para o mês/ano fornecido.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }
}
