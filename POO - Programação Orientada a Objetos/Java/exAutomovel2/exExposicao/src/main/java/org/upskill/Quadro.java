package org.upskill;

import java.util.Comparator;
import java.util.Objects;

public class Quadro implements Comparable<Quadro> {
    String designacao;
    String nomeAutor;
    int anoCriacao;

    public Quadro(String designacao, String nomeAutor, int anoCriacao) {
        this.designacao = designacao;
        this.nomeAutor = nomeAutor;
        this.anoCriacao = anoCriacao;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadro quadro = (Quadro) o;
        return anoCriacao == quadro.anoCriacao
               && Objects.equals(designacao, quadro.designacao)
               && Objects.equals(nomeAutor, quadro.nomeAutor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designacao, nomeAutor, anoCriacao);
    }

    @Override
    public String toString() {
        return String.format("Designação: %s%nAutor: %s%nAno: %d%n", this.designacao, this.nomeAutor, this.anoCriacao);
    }

    @Override
    public int compareTo(Quadro outroQuadro) {
        String nome1 = this.getNomeAutor();
        String nome2 = outroQuadro.getNomeAutor();
        return nome1.compareToIgnoreCase(nome2);
    }
}
