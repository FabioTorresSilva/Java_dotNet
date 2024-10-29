package org.upskill.vencimentos;

public abstract class Trabalhador {

    private String nome;

    private static final String NOME_POR_OMISSAO = "sem nome";

    public Trabalhador(String nome) {
        this.nome = nome;
    }

    public Trabalhador() {
        nome = Trabalhador.NOME_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Trabalhador outraFigura = (Trabalhador) outroObjeto;
        return this.nome.equalsIgnoreCase(outraFigura.nome);
    }

    public abstract float calcularVencimento();
}