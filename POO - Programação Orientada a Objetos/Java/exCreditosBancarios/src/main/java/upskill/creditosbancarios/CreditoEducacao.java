
package upskill.creditosbancarios;

/**
 *
 * @author jduar
 */
public class CreditoEducacao extends CreditoConsumo{
    
    private int periodoCarencia;
    
    private static final int PERIODO_CARENCIA_POR_OMISSAO = 0;
    
    private static double taxaJuroAnual=2;
    
    public CreditoEducacao(String nomeCliente, String profissao, double montante, int prazoFinanciamento, int periodoCarencia) {
        super(nomeCliente,profissao,montante,prazoFinanciamento);  
        this.periodoCarencia=periodoCarencia;
    }
    
    public CreditoEducacao() {
        super();     
        periodoCarencia=PERIODO_CARENCIA_POR_OMISSAO;
    } 

    public double getPeriodoCarencia() {
        return periodoCarencia;
    }

    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }
    
    @Override
    public String toString() {
        return String.format("Crédito à Educação: %n%s e um período de carencia de %d",super.toString(), periodoCarencia);
    }
    
    @Override  
    public double calcularMontanteAReceberPorCadaCredito(){
      
        double amortCapital= getMontante()/(getPrazoFinanciamento()-periodoCarencia);
        double capitalEmDivida =getMontante();
        double valorReceber=0;        
        double juros, prestMensal;
        
     
        for (int i = 1; i <= periodoCarencia; i++) {
            juros = capitalEmDivida * ((taxaJuroAnual / 100) / 12);
            valorReceber+=juros;          
        } 
        
        for (int i = periodoCarencia+1; i <= getPrazoFinanciamento(); i++) {
            juros = capitalEmDivida * ((taxaJuroAnual / 100) / 12);
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
    
    public static double getTaxaJuroAnual() {
        return taxaJuroAnual;
    }

    public static void setTaxaJuroAnual(double aTaxaJuroAnual) {
        taxaJuroAnual = aTaxaJuroAnual;
    }    
}
