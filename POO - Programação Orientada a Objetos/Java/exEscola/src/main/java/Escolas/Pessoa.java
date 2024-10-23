package Escolas;

public abstract class Pessoa {

    private String nome;
    private int numeroId;

    public Pessoa() {
    }

    public Pessoa(String nome, int numeroId) {
        this.nome = nome;
        this.numeroId = numeroId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    @Override
    public String toString() {
        return String.format("Nome:%n%s %nNumero ID: %d", this.nome, this.numeroId);
    }
}