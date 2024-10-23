
package upskill.creditosbancarios;

/**
 *
 * @author jduar
 */
public abstract class CreditoBancario {
    
    private String nomeCliente;
    private String profissao;
    private double montante;
    private int prazoFinanciamento;
    
    private static final String NOME_CLIENTE_POR_OMISSAO = "sem nome";
    private static final String PROFISSAO_POR_OMISSAO = "sem profissão";
    private static final double MONTANTE_POR_OMISSAO = 0;
    private static final int PRAZO_FINANCIAMENTO_POR_OMISSAO = 0;
    
    public CreditoBancario(String nomeCliente, String profissao, double montante, int prazoFinanciamento) {
        this.nomeCliente = nomeCliente;
        this.profissao = profissao;
        this.montante = montante;
        this.prazoFinanciamento = prazoFinanciamento;
    }
    
    public CreditoBancario() {
        this.nomeCliente = NOME_CLIENTE_POR_OMISSAO;
        this.profissao = PROFISSAO_POR_OMISSAO;
        this.montante = MONTANTE_POR_OMISSAO;
        this.prazoFinanciamento = PRAZO_FINANCIAMENTO_POR_OMISSAO;
    }    
    
    public String getNomeCliente() {
        return nomeCliente;
    }
      
    public String getProfissao() {
        return profissao;
    }
    
    public double getMontante() {
        return montante;
    }
    
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    public void setMontante(double montante) {
        this.montante = montante;
    }
    
    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }
    
    @Override
    public String toString() {
        return String.format("%s tem a profissão: %s e contraiu um crédito bancário no valor de %.2f com um prazo de financiamento de %d meses",
                nomeCliente, profissao, montante, prazoFinanciamento);
    }
    
    public abstract double calcularMontanteAReceberPorCadaCredito();    
    
  //  public abstract double calcularMontanteTotalJuros();

    public double calcularMontanteTotalJuros() {
        return calcularMontanteAReceberPorCadaCredito() - getMontante();
    }


    }
