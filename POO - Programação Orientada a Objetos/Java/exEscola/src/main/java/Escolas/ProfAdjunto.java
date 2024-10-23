package Escolas;

public class ProfAdjunto extends Professor {

    static private double modificador = 1.2;

    public ProfAdjunto() {
        super();
    }

    public ProfAdjunto(String nome, int numeroId) {
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

