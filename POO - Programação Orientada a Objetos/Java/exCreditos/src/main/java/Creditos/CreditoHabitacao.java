package Creditos;

public class CreditoHabitacao extends Credito {

    public double spread;
    public static double taxaEuribor = 0.1;
    public double taxaJuroAnual = spread + taxaEuribor;

    private final double SPREAD_POR_OMISSAO = -1;
    private final double TAXA_EURIBOR_POR_OMISSAO = -1;
    private final double TAXA_JURO_ANUAL_POR_OMISSAO = SPREAD_POR_OMISSAO + TAXA_EURIBOR_POR_OMISSAO;

    public CreditoHabitacao(String nome, String profissao, double montante, int prazo, double spread, double taxaJuroAnual) {
        super(nome, profissao, montante, prazo);
        this.spread = spread;
    }

    public CreditoHabitacao() {
        super();
        spread = SPREAD_POR_OMISSAO;
    }

    public double getSpread() {
        return spread;
    }

    public void setSpread(double spread) {
        this.spread = spread;
    }

    public double getTaxaJuroAnual() {
        return taxaJuroAnual;
    }

    public void setTaxaJuroAnual(double taxaJuroAnual) {
        this.taxaJuroAnual = taxaJuroAnual;
    }

    public double getTaxaEuribor() {
        return taxaEuribor;
    }

    public void setTaxaEuribor(double taxaEuribor) {
        this.taxaEuribor = taxaEuribor;
    }

    @Override
    public String toString() {
        return "CreditoHabitacao{" +
                "spread=" + spread +
                ", taxaEuribor=" + taxaEuribor +
                ", taxaJuroAnual=" + taxaJuroAnual +
                ", SPREAD_POR_OMISSAO=" + SPREAD_POR_OMISSAO +
                ", TAXA_EURIBOR_POR_OMISSAO=" + TAXA_EURIBOR_POR_OMISSAO +
                ", TAXA_JURO_ANUAL_POR_OMISSAO=" + TAXA_JURO_ANUAL_POR_OMISSAO +
                "} " + super.toString();
    }
}
