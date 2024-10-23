
package upskill.creditosbancarios;

/**
 *
 * @author jduar
 */
public class MainCreditosBancarios {

    public static void main(String[] args) {
       
        CreditoEducacao credEduc1= new CreditoEducacao("Pessoa1", "Profissão1", 18000, 60, 24);
        CreditoEducacao credEduc2= new CreditoEducacao("Pessoa2", "Profissão2", 36000, 60, 48);
        CreditoHabitacao credHab1 = new CreditoHabitacao("pessoa3", "profissão3", 120000,240, 1);
        CreditoHabitacao credHab2 = new CreditoHabitacao("pessoa4", "profissão4", 90000,300, 1.2);
        CreditoAutomovel CredAut1 = new CreditoAutomovel("pessoa5", "profissão5", 20000,24);
        CreditoAutomovel CredAut2 = new CreditoAutomovel("pessoa6", "profissão6", 25000,30);

        CreditoBancario[] credBanc = new CreditoBancario[20]; 
        
        credBanc[0]=credEduc1;
        credBanc[1]=credEduc2;
        credBanc[2]=credHab1;
        credBanc[3]=credHab2;
        credBanc[4]=CredAut1;
        credBanc[5]=CredAut2;
                
        System.out.println("\n\n### Listagem dos créditos ao consumo com o nome do cliente e o valor que a instituição bancária irá receber até ao final de cada contrato realizado ###");
        for (int i = 0; i < credBanc.length; i++) {
              if (credBanc[i] instanceof CreditoConsumo ) {
                System.out.printf("%nMontante total a receber do crédito realizado pelo " +
                        "cliente %s: %.2f euros",credBanc[i].getNomeCliente(),credBanc[i].calcularMontanteAReceberPorCadaCredito());
            }
        }     
        System.out.println("\n\n### Listagem dos créditos bancários com nome do cliente e o valor dos juros que o cliente terá de pagar até " +
                "ao final de cada contrato realizado  ###");
        for (int i = 0; i < credBanc.length; i++) {
              if (credBanc[i] !=null) {
                System.out.printf("%nMontante total a receber de juros do crédito realizado pelo cliente %s:" +
                        " %.2f euros",credBanc[i].getNomeCliente(),credBanc[i].calcularMontanteTotalJuros());
            }
        }
        
        System.out.printf("%n%n#Número de Instâncias de Créditos à Habitação: %d", CreditoHabitacao.getQtdCreditosHabitacao());
        System.out.printf("%n#Número de Instâncias de Créditos ao Consumo : %d ", CreditoConsumo.getQtdCreditosConsumo());

        double totalMontanteCred = 0;
        double totalJurosCred = 0;
        for (int i = 0; i < credBanc.length; i++) {            
            if (credBanc[i]  != null)        
            {
                totalMontanteCred += credBanc[i].calcularMontanteAReceberPorCadaCredito();                 
                totalJurosCred += credBanc[i].calcularMontanteTotalJuros();
            }
        }

        System.out.printf("%n%nValor total a receber por todos os créditos bancários realizados: %.2f euros", totalMontanteCred);       
        System.out.printf("%nValor total de juros a receber por todos os créditos bancários realizados: %.2f euros", totalJurosCred);
       
    }    
}


