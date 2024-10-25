package org.upskill.vencimentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Empresa {
    private String nome;
    private String morada;
    private List<Trabalhador> trabalhadores;

    public Empresa(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
        this.trabalhadores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarTrabalhador(Trabalhador trabalhador) {
        if (!trabalhadores.contains(trabalhador)) {
            trabalhadores.add(trabalhador);
        } else {
            System.out.println("O trabalhador já está cadastrado na empresa.");
        }
    }

    Comparator<Trabalhador> trabalhador = new Comparator<Trabalhador>() {

        public int compare(Trabalhador t1, Trabalhador t2) {
            double v1 = t1.calcularVencimento();
            double v2 = t2.calcularVencimento();

            return Double.compare(v1, v2);
        }
    };

    public void ordenarTrabalhadoresPorVencimento() {
        Collections.sort(trabalhadores, trabalhador);
    }

    public void listarTrabalhadores() {
        for (Trabalhador trabalhador : trabalhadores) {
            System.out.println(trabalhador.getNome() + " - Vencimento: " + trabalhador.calcularVencimento());
        }
    }

    public void listarTrabalhadoresPorTipo(Class<?> tipo) {
        System.out.println("Trabalhadores do Tipo: " + tipo.getSimpleName());
        for (Trabalhador trabalhador : trabalhadores) {
            if (tipo.isInstance(trabalhador)) {
                System.out.println(trabalhador.getNome() + " - Vencimento: " + trabalhador.calcularVencimento());
            }
        }
    }

    public float calcularVencimentoTotal() {
        float vencimentoTotal = 0.0f;
        for (Trabalhador trabalhador : trabalhadores) {
            vencimentoTotal += trabalhador.calcularVencimento();
        }
        return vencimentoTotal;
    }

    @Override
    public String toString() {
        return "Empresa: " + nome + "\nMorada: " + morada + "\nNúmero de trabalhadores: " + trabalhadores.size();
    }
}
