/**
 *
 * @author ISEP-DEI-PPROG
 */
package exposicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exposicao implements Comparable<Exposicao> {

    private String designacao;
    private int ano;
    private List<Quadro> listaQuadros;

    private static final String DESIGNACAO_POR_OMISSAO = "sem designaçao";
    private static final int ANO_POR_OMISSAO = 0;

    public Exposicao(String designacao, int ano, List<Quadro> listaQuadros) {
        this.designacao = designacao;
        this.ano = ano;
        this.listaQuadros = new ArrayList<>(listaQuadros);
    }

    public Exposicao(String designacao, int ano) {
        this.designacao = designacao;
        this.ano = ano;
        listaQuadros = new ArrayList<>();
    }

    public Exposicao() {
        designacao = DESIGNACAO_POR_OMISSAO;
        ano = ANO_POR_OMISSAO;
        listaQuadros = new ArrayList<>();
    }

    public Exposicao(Exposicao outraExposicao) {
        designacao = outraExposicao.designacao;
        ano = outraExposicao.ano;
//          listaQuadros = new ArrayList(outraExposicao.listaQuadros);
        listaQuadros = new ArrayList();
        for (Quadro quad : outraExposicao.listaQuadros) {
            listaQuadros.add(new Quadro(quad));
        }
    }

    public String getDesignacao() {
        return designacao;
    }

    public int getAno() {
        return ano;
    }

    public List<Quadro> getListaQuadros() {
        return new ArrayList<>(listaQuadros);
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setListaQuadros(List<Quadro> listaQuadros) {
        this.listaQuadros = new ArrayList<>(listaQuadros);
    }

    @Override
    public String toString() {
        return String.format("EXPOSIÇÃO%nDesignação:%s%nAno:%d%n%s",
                designacao,
                ano,
                listaQuadrosToString());
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Exposicao outraExposicao = (Exposicao) outroObjeto;
        AlfabAutorAlfabDesig criterio = new AlfabAutorAlfabDesig();

        List<Quadro> listaQuadrosTemp = new ArrayList(listaQuadros);
        Collections.sort(listaQuadrosTemp, criterio);
        List<Quadro> listaQuadrosTemp2 = new ArrayList(outraExposicao.listaQuadros);
        Collections.sort(listaQuadrosTemp2, criterio);

        return designacao.equalsIgnoreCase(outraExposicao.designacao)
                && ano == outraExposicao.ano
                && listaQuadrosTemp.equals(listaQuadrosTemp2);
    }

    public boolean adicionarQuadro(Quadro quadro) {
        return listaQuadros.contains(quadro) ? false : listaQuadros.add(quadro);
    }

    public boolean removerQuadro(Quadro quadro) {
        return listaQuadros.remove(quadro);
    }

    @Override
    public int compareTo(Exposicao outraExposicao) {
        return ano - outraExposicao.ano;
    }

    private String listaQuadrosToString() {
        List<Quadro> listaQuadrosTemp = new ArrayList(listaQuadros);
        Collections.sort(listaQuadrosTemp);
        StringBuilder s = new StringBuilder();
        for (Quadro q : listaQuadrosTemp) {
            s.append(q.toString());
            s.append("\n");
        }
        return s.toString();
    }
}