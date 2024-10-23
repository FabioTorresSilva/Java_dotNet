
package upskill.creditosbancarios;

/**
 *
 * @author jduar
 */
public class CreditoAutomovel extends CreditoConsumo{
    
    private static double taxaJuroAnual=6;
    
    private static double taxaDesconto=1;
    
    private static double referenciaPrazoFinanciamento=24;
    
    public CreditoAutomovel(String nomeCliente, String profissao, double montante, int prazoFinanciamento) {
        super(nomeCliente,profissao,montante,prazoFinanciamento);        
    }
    
    public CreditoAutomovel() {
        super();        
    }    
    
        @Override
    public String toString() {
        return String.format("Crédito Automóvel: %n%s",super.toString());
    }
    
    @Override  
    public double calcularMontanteAReceberPorCadaCredito(){
      
        double amortCapital= getMontante()/getPrazoFinanciamento();
        double capitalEmDivida =getMontante();
        double valorReceber=0;       
        double juros, prestMensal;
     
        for (int i = 1; i <= getPrazoFinanciamento(); i++) {  
            juros = capitalEmDivida * ((taxaJuroAnual / 100) / 12);
            prestMensal= getPrazoFinanciamento()<=getReferenciaPrazoFinanciamento() ?(amortCapital + juros)*((100-taxaDesconto)/100):amortCapital + juros;
            capitalEmDivida= capitalEmDivida-amortCapital;
            valorReceber+=prestMensal;                       
        }        
        return valorReceber;        
    }
//    @Override
//    public double calcularMontanteTotalJuros(){
//        return calcularMontanteAReceberPorCadaCredito() - getMontante();
//    }

//    @Override
//    public double calcularMontanteTotalJuros(){
//
//        double amortCapital= getMontante()/getPrazoFinanciamento();
//        double capitalEmDivida =getMontante();
//        double totalJuros=0;
//        double juros;
//
//        for (int i = 1; i <= getPrazoFinanciamento(); i++) {
//            juros = getPrazoFinanciamento()<=getReferenciaPrazoFinanciamento() ?capitalEmDivida * ((taxaJuroAnual / 100) / 12)*((100-taxaDesconto)/100): capitalEmDivida * ((taxaJuroAnual / 100) / 12);
//            capitalEmDivida= capitalEmDivida-amortCapital;
//            totalJuros+=juros;
//        }
//        return totalJuros;
//    }
    
    public static double getTaxaJuroAnual() {
        return taxaJuroAnual;
    }
    
    public static double getTaxaDesconto() {
        return taxaDesconto;
    }
    
    public static double getReferenciaPrazoFinanciamento() {
        return referenciaPrazoFinanciamento;
    }

    public static void setTaxaJuroAnual(double aTaxaJuroAnual) {
        taxaJuroAnual = aTaxaJuroAnual;
    }

    public static void setTaxaDesconto(double aTaxaDesconto) {
        taxaDesconto = aTaxaDesconto;
    }

    public static void setReferenciaPrazoFinanciamento(double aReferenciaPrazoFinanciamento) {
        referenciaPrazoFinanciamento = aReferenciaPrazoFinanciamento;
    }
}
