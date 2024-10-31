package org.upskill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Exposicao implements Comparable<Exposicao> {
    String designacao;
    int anoRealizacao;
    List<Quadro> quadros;

    public Exposicao(String designacao, int anoRealizacao, List<Quadro> quadros) {
        this.designacao = designacao;
        this.anoRealizacao = anoRealizacao;
        this.quadros = new ArrayList<>(quadros);
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public List<Quadro> getQuadros() {
        return quadros;
    }

    public void setQuadros(List<Quadro> quadros) {
        this.quadros = quadros;
    }

    public int getAnoRealizacao() {
        return anoRealizacao;
    }

    public void setAnoRealizacao(int anoRealizacao) {
        this.anoRealizacao = anoRealizacao;
    }

    public boolean addQuadro(Quadro quadro) {
        return quadros.add(quadro);
    }

    public boolean removerQuadro(Quadro quadro) {
        return quadros.remove(quadro);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) return true;
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) return false;
        Exposicao exposicao = (Exposicao) outroObjeto;
        return this.anoRealizacao == exposicao.anoRealizacao &&
                Objects.equals(designacao, exposicao.designacao) &&
                Objects.equals(quadros, exposicao.quadros);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<Quadro> quadrosOrdenados = new ArrayList<>(quadros);
        Collections.sort(quadrosOrdenados);
        for (Quadro quadro : quadrosOrdenados) {
            sb.append(quadro.toString()).append("\n");
        }
        return String.format("Designação: %s%nAno: %d%nQuadros:%n%s", this.designacao, this.anoRealizacao, sb.toString());
    }

    @Override
    public int compareTo(Exposicao outraExposicao) {
        return Integer.compare(this.anoRealizacao, outraExposicao.anoRealizacao);
    }
}