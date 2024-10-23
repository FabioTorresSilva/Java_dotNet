
package upskill.impostos;

/**
 * Esta classe possui membros comuns às classe de contribuintes com rendimentos
 * do trabalho (RT).
 *
 * @author ISEP-DEI-PPROG
 */
public abstract class ContribuinteComRendimentosTrabalho extends Contribuinte {

    /**
     * O valor dos rendimentos do trabalho do contribuinte RT.
     */
    private float rendimentosTrabalho;
    
    /**
     * O valor por omissão dos rendimentos do trabalho do contribuinte RT.
     */
    private static final float RENDIMENTOS_TRABALHO_POR_OMISSAO = -1;

    /**
     * Inicializa o estado do contribuinte RT atribuindo o nome, a morada, os
     * rendimentos do trabalho e os outros rendimentos do contribuinte RT
     * recebidos.
     *
     * @param nome o nome do contribuinte RT
     * @param morada a morada do contribuinte RT
     * @param rendimentosTrabalho os rendimentos do trabalho do contribuinte RT
     * @param outrosRendimentos os outros rendimentos do contribuinte RT
     */
    public ContribuinteComRendimentosTrabalho(String nome, 
                                              String morada, 
                                              float rendimentosTrabalho, 
                                              float outrosRendimentos) {
        super(nome, morada, outrosRendimentos);
        this.rendimentosTrabalho = rendimentosTrabalho;
    }

    /**
     * Inicializa o estado do contribuinte RT atribuindo o nome por omissão, a
     * morada por omissão, os outros rendimentos por omissão e os rendimentos 
     * do trabalho por omissão.
     */
    public ContribuinteComRendimentosTrabalho() {
        super();
        rendimentosTrabalho = RENDIMENTOS_TRABALHO_POR_OMISSAO;
    }

    /**
     * Devolve os rendimentos do trabalho do contribuinte RT.
     *
     * @return montante dos rendimentos do trabalho do contribuinte RT
     */
    public float getRendimentosTrabalho() {
        return rendimentosTrabalho;
    }

    /**
     * Modifica os rendimentos do trabalho do contribuinte RT.
     *
     * @param rendimentosTrabalho o novo montante dos rendimentos do trabalho 
     *                            do contribuinte RT
     */
    public void setRendimentosTrabalho(float rendimentosTrabalho) {
        this.rendimentosTrabalho = rendimentosTrabalho;
    }

    /**
     * Devolve a representação textual do contribuinte RT.
     *
     * @return representação textual do contribuinte RT
     */
    @Override
    public String toString() {
        return String.format("%s %nRendimentos do Trabalho: %.2f€",
                                super.toString(), 
                                rendimentosTrabalho);
    }

    /**
     * Devolve o montante de imposto a pagar pelo contribuinte. As taxas dos 
     * rendimentos do trabalho e dos outros rendimentos estão definidas em 
     * subclasses desta classe.
     *
     * @return montante de imposto a pagar pelo contribuinte
     */
    @Override
    public float calcularImposto() {
        return (rendimentosTrabalho * obterTaxaRendimentosTrabalho() + 
                getOutrosRendimentos() * obterTaxaOutrosRendimentos()) / 100;
    }
    
     /**
     * Permite implementar a obtenção da taxa sobre os rendimentos do trabalho 
     * do contribuinte com rendimentos do trabalho na subclasse apropriada,  
     * sendo necessária para esta classe especificar o cálculo do imposto a 
     * pagar pelo contribuinte com rendimentos do trabalho.
     *
     * @return taxa(%) sobre os rendimentos do trabalho do contribuinte
     *
     */
    public abstract float obterTaxaRendimentosTrabalho();

    /**
     * Permite implementar a obtenção da taxa sobre os outros rendimentos do
     * contribuinte com rendimentos do trabalho na subclasse apropriada, sendo 
     * necessária para esta classe especificar o cálculo do imposto a pagar pelo
     * contribuinte com rendimentos do trabalho.
     *
     * @return taxa(%) sobre os outros rendimentos do contribuinte
     */
    public abstract float obterTaxaOutrosRendimentos();
}

