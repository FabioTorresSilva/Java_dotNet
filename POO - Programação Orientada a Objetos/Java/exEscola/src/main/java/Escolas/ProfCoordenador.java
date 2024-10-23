package Escolas;

public class ProfCoordenador extends Professor{

    static private double modificador = 1.5;

    public ProfCoordenador() {
        super();
    }

    public ProfCoordenador(String nome, int numeroId) {
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
