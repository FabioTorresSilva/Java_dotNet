/**
 *
 * @author ISEP-DEI-PPROG
 */
package exposicao;

public class Quadro implements Comparable<Quadro> {

    private String designacao;
    private String autor;
    private int ano;

    private static final String DESIGNACAO_POR_OMISSAO = "sem designaçao";
    private static final String AUTOR_POR_OMISSAO = "sem autor";
    private static final int ANO_POR_OMISSAO = -1;

    public Quadro(String designacao, String autor, int ano) {
        this.designacao = designacao;
        this.autor = autor;
        this.ano = ano;
    }

    public Quadro(String autor, int ano) {
        designacao = DESIGNACAO_POR_OMISSAO;
        this.autor = autor;
        this.ano = ano;
    }

    public Quadro() {
        designacao = DESIGNACAO_POR_OMISSAO;
        autor = AUTOR_POR_OMISSAO;
        ano = ANO_POR_OMISSAO;
    }

    public Quadro(Quadro outroQuadro) {
        designacao = outroQuadro.designacao;
        autor = outroQuadro.autor;
        ano = outroQuadro.ano;
    }

    public String getDesignacao() {
        return designacao;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return String.format("QUADRO: Designação-%s Autor-%s Ano-%s",
                designacao,
                autor,
                ano);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Quadro outroQuadro = (Quadro) outroObjeto;
        return designacao.equalsIgnoreCase(outroQuadro.designacao)
                && autor.equalsIgnoreCase(outroQuadro.autor)
                && ano == outroQuadro.ano;
    }

    @Override
    public int compareTo(Quadro outroQuadro) {
        return autor.compareToIgnoreCase(outroQuadro.autor);
    }
}