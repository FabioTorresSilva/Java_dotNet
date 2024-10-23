package Creditos;

public class CreditoConAuto extends CreditoConsumo {

    public double taxaJuroAnual;
    private final double TAXA_JURO_ANUAL_POR_OMISSAO = -1;

    private final double descontoMensal = 1;

    public double getTaxaJuroAnual() {
        return taxaJuroAnual;
    }

    public double getDescontoMensal() {
        return descontoMensal;
    }

    public CreditoConAuto(String nome, String profissao, double montante, int prazo, double taxaJuro, double taxaJuroAnual) {
        super(nome, profissao, montante, prazo, taxaJuro);
        this.taxaJuroAnual = taxaJuroAnual;
    }

    public CreditoConAuto() {
        super();
        taxaJuroAnual = TAXA_JURO_ANUAL_POR_OMISSAO;
    }

}
