package Escolas;

public class AlunoBolseiro extends Aluno implements Pagavel {
    private int valorBolsa;

    public AlunoBolseiro() {
        super();
    }

    public AlunoBolseiro(String nome, int numeroId, int numeroMeca, int valorBolsa) {
        super(nome, numeroId, numeroMeca);
        this.valorBolsa = valorBolsa;
    }

    public int getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(int valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nValor Bolsa: %d", this.valorBolsa);
    }

    public double determinarCusto() {
        return this.valorBolsa;
    }
}
