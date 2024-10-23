
package upskill.creditosbancarios;

/**
 *
 * @author jduar
 */
public class CreditoHabitacao extends CreditoBancario {
 
    private double spread;
    
    private static final double SPREAD_POR_OMISSAO = 0;
    
    private static double taxaEuribor=0.1;
    
    private static int qtdCreditosHabitacao = 0;
    
    
    public CreditoHabitacao(String nomeCliente, String profissao, double montante, int prazoFinanciamento,double spread) {
        super(nomeCliente,profissao,montante,prazoFinanciamento);
        this.spread=spread;
        qtdCreditosHabitacao++;
    }
    
    public CreditoHabitacao() {
        super();
        spread=SPREAD_POR_OMISSAO;
        qtdCreditosHabitacao++;
    }
    
    @Override
    public String toString() {
        return String.format("Crédito à Habitação: %n%s e um spread de %.2f",super.toString(), getSpread());
    }

    public double getSpread() {
        return spread;
    }
        
    public void setSpread(double spread) {
        this.spread = spread;
    }        
    
    @Override  
    public double calcularMontanteAReceberPorCadaCredito(){
      
        double amortCapital= getMontante()/getPrazoFinanciamento();
        double capitalEmDivida =getMontante();
        double valorReceber=0;        
        double juros, prestMensal;
     
        for (int i = 1; i <= getPrazoFinanciamento(); i++) {  
           // juros = capitalEmDivida * (((spread / 100) / 12)+(taxaEuribor/100/12));
            juros = capitalEmDivida * (((spread +taxaEuribor) / 100) / 12);
            prestMensal = amortCapital + juros;
            capitalEmDivida= capitalEmDivida-amortCapital;
            valorReceber+=prestMensal;                    
        }        
        return valorReceber;         
    }  
    
//    @Override
//    public double calcularMontanteTotalJuros(){
//        return calcularMontanteAReceberPorCadaCredito() - getMontante();
//    }

    
    public static double getTaxaEuribor() {
        return taxaEuribor;
    }
    
    public static int getQtdCreditosHabitacao() {
        return qtdCreditosHabitacao;
    }
    
    public static void setTaxaEuribor(double aTaxaEuribor) {
        taxaEuribor = aTaxaEuribor;
    }
}
