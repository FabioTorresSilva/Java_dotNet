package Escolas;

public class ProfAssistente extends Professor{
    static private double modificador = 1;

    public ProfAssistente() {
        super();
    }

    public ProfAssistente(String nome, int numeroId) {
        super(nome, numeroId);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nVencimento:%n%s", this.getVencimentoBase());
    }

    @Override
    public double getModificador() {
        return modificador;
    }
}
