package Creditos;

public class Credito {

    public String nome;
    public String profissao;
    public double montante;
    public int prazo;

    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final String PROFISSAO_POR_OMISSAO = "sem profissao";
    private static final double MONTANTE_POR_OMISSAO = -1;
    private static final int PRAZO_POR_OMISSAO = -1;

    public Credito(String nome, String profissao, double montante, int prazo) {
        this.nome = nome;
        this.profissao = profissao;
        this.montante = montante;
        this.prazo = prazo;
    }

    public Credito() {
        this.nome = NOME_POR_OMISSAO;
        this.profissao = PROFISSAO_POR_OMISSAO;
        this.montante = MONTANTE_POR_OMISSAO;
        this.prazo = PRAZO_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Credito{" +
                "nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                ", montante=" + montante +
                ", prazo=" + prazo +
                '}';
    }
}
