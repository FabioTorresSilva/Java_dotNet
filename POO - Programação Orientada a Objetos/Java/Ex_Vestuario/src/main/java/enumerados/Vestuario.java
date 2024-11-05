package enumerados;

public class Vestuario {
    private int codigo;
    private String designacao;
    private Tamanho tamanho;

    public enum Tamanho {Xs,S,M,L,Xl};

    private static final int CODIGO_POR_OMISSAO = -1;
    private static final String DESIGNACAO_POR_OMISSAO = "sem designação";
    private static final Tamanho TAMANHO_POR_OMISSAO = Tamanho.M;

    public Vestuario(int codigo, String designacao, Tamanho tamanho) {
        this.codigo = codigo;
        this.designacao = designacao;
        this.tamanho = tamanho;
    }

    public Vestuario(){
        codigo= CODIGO_POR_OMISSAO;
        designacao = DESIGNACAO_POR_OMISSAO;
        tamanho = TAMANHO_POR_OMISSAO;
    }

    public Vestuario(Vestuario v) {
        this.codigo = v.codigo;
        this.designacao = v.designacao;
        this.tamanho = v.tamanho;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDesignacao() {
        return designacao;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return String.format("Vestuario: codigo=%s, designacao=%s, tamanho=%s",codigo, designacao,tamanho);
    }
}

