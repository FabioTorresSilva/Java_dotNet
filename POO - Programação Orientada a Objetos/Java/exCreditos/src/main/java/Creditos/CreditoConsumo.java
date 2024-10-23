package Creditos;

public class CreditoConsumo extends Credito {

    public double taxaJuro;
    private static double TAXA_JURO_POR_OMISSAO;

    public CreditoConsumo(String nome, String profissao, double montante, int prazo, double taxaJuro) {
        super(nome, profissao, montante, prazo);
        this.taxaJuro = taxaJuro;
    }

    public CreditoConsumo() {
        super();
        taxaJuro = TAXA_JURO_POR_OMISSAO;
    }

    public double getTaxaJuro() {
        return taxaJuro;
    }

    public void setTaxaJuro(double taxaJuro) {
        this.taxaJuro = taxaJuro;
    }

    public static double getTaxaJuroPorOmissao() {
        return TAXA_JURO_POR_OMISSAO;
    }

    @Override
    public String toString() {
        return "CreditoConsumo{" +
                "taxaJuro=" + taxaJuro +
                "} " + super.toString();
    }
}
