package Escolas;

public class Aluno extends Pessoa {

    private int numeroMeca;

    public Aluno() {
        super();
    }

    public Aluno(String nome,int numeroId, int numeroMeca) {
        super(nome,numeroId);
        this.numeroMeca = numeroMeca;
    }

    public int getNumeroMeca() {
        return numeroMeca;
    }

    public void setNumeroMeca(int numeroMeca) {
        this.numeroMeca = numeroMeca;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nNúmero Aluno:%n%s", this.numeroMeca);
    }
}