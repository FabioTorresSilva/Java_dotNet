package org.upskill.vencimentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainVencimentos {

    public static void main(String[] args) {
        TrabalhadorComissao tc = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 20, 30);
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);

        List<Trabalhador> trabalhador = new ArrayList<>();
        trabalhador.add(tc);
        trabalhador.add(tp);
        trabalhador.add(th);

        System.out.println("### Trabalhadores ###");
        listar(trabalhador);

        Comparator<Trabalhador> crescente = new Comparator<Trabalhador>() {
            @Override
            public int compare(Trabalhador t1, Trabalhador t2) {
                double trabalhador1 = t1.calcularVencimento();
                double trabalhador2 = t2.calcularVencimento();

                return Double.compare(trabalhador1, trabalhador2);
            }
        };

        System.out.println("\n\t# Trabalhadores ordem Crescente Vencimento #");
        Collections.sort(trabalhador, crescente);
        listar(trabalhador);

        Comparator<Trabalhador> decrescente = new Comparator<Trabalhador>() {
            @Override
            public int compare(Trabalhador t1, Trabalhador t2) {
                double trabalhador1 = t1.calcularVencimento();
                double trabalhador2 = t2.calcularVencimento();

                return Double.compare(trabalhador2, trabalhador1);

            }
        };
        System.out.println("\n\t# Trabalhadores ordem descrescente Vencimento #");
        Collections.sort(trabalhador, Collections.reverseOrder(crescente));
        listar(trabalhador);

        Comparator<Trabalhador> alfabetica = new Comparator<Trabalhador>() {
            @Override
            public int compare(Trabalhador t1, Trabalhador t2) {
                String trabalhador1 = t1.getNome();
                String trabalhador2 = t2.getNome();

                return trabalhador2.compareTo(trabalhador1);
            }
        };
        System.out.println("\n\t# Trabalhadores ordem Alfabetica #");
        Collections.sort(trabalhador, Collections.reverseOrder(alfabetica));
        listar(trabalhador);
    }

    private static void listar(List<Trabalhador> trabalhador) {
        for (Trabalhador trab : trabalhador) {
            if (trab != null) {
                System.out.printf("%s, vencimento = %.2f€%n", trab.getNome(),
                        trab.calcularVencimento());
            }
        }
    }
}