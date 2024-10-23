
package upskill.creditosbancarios;

/**
 *
 * @author jduar
 */
public abstract class CreditoConsumo extends CreditoBancario{
  
    private static int qtdCreditosConsumo = 0;
    
    public CreditoConsumo(String nomeCliente, String profissao, double montante, int prazoFinanciamento) {
        super(nomeCliente,profissao,montante,prazoFinanciamento);
        qtdCreditosConsumo++;
    }
    
    public CreditoConsumo() {
        super();
        qtdCreditosConsumo++;
    }

    public static int getQtdCreditosConsumo() {
        return qtdCreditosConsumo;
    }
     
}
