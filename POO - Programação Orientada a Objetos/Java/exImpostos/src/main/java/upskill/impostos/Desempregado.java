
package upskill.impostos;

/**
 * Representa um desempregado através do seu nome, morada, outros rendimentos e
 * meses de paragem.
 *
 * @author ISEP-DEI-PPROG
 */
public class Desempregado extends Contribuinte {

    /**
     * O número de meses de paragem do desempregado.
     */
    private int mesesParagem;

    /**
     * O número de meses de paragem do desempregado por omissão.
     */
    private static final int MESES_PARAGEM_POR_OMISSAO = -1;
    
    /**
     * A taxa(%) sobre os outros rendimentos aplicada a todos os desempregados.
     */
    private static float taxaOutrosRendimentos = 2;

    /**
     * Constrói uma instância de Desempregado recebendo o seu nome, morada,
     * outros rendimentos e meses de paragem.
     *
     * @param nome o nome do desempregado
     * @param morada a morada do desempregado
     * @param outrosRendimentos o valor dos outros rendimentos do desempregado
     * @param mesesParagem o número de meses de paragem do desempregado
     */
    public Desempregado(String nome, String morada, float outrosRendimentos, 
                        int mesesParagem) {
        super(nome, morada, outrosRendimentos);
        this.mesesParagem = mesesParagem;
    }

    /**
     * Constrói uma instância de Desempregado atribuindo o nome por omissão, a
     * morada por omissão, os outros rendimentos por omissão e meses de paragem
     * por omissão.
     */
    public Desempregado() {
        super();
        mesesParagem = MESES_PARAGEM_POR_OMISSAO;
    }

    /**
     * Devolve o número de meses de paragem do desempregado.
     *
     * @return o número de meses de paragem do desempregado
     */
    public int getMesesParagem() {
        return mesesParagem;
    }

    /**
     * Modifica o número de meses de paragem do desempregado.
     *
     * @param mesesParagem o novo número de meses de paragem do desempregado
     */
    public void setMesesParagem(int mesesParagem) {
        this.mesesParagem = mesesParagem;
    }

    /**
     * Devolve a descrição textual do desempregado.
     *
     * @return características do desempregado
     */
    @Override
    public String toString() {
        return String.format("DESEMPREGADO %n%s %nN. de Meses de Paragem: %d",
                super.toString(), mesesParagem);
    }

    /**
     * Devolve o montante de imposto a pagar pelo desempregado.
     *
     * @return o montante do imposto a pagar pelo desempregado
     */
    @Override
    public float calcularImposto() {
        return getOutrosRendimentos() * taxaOutrosRendimentos / 100;
    }

    /**
     * Devolve a taxa sobre os outros rendimentos aplicada a todos os
     * desempregados.
     *
     * @return taxa(%) sobre os outros rendimentos dos desempregados
     */
    public static float getTaxaOutrosRendimentos() {
        return taxaOutrosRendimentos;
    }

    /**
     * Modifica a taxa sobre os outros rendimentos aplicada a todos os
     * desempregados.
     *
     * @param taxaOutrosRendimentos a nova taxa(%) sobre os outros  
     *                              rendimentos dos desempregados
     */
    public static void setTaxaOutrosRendimentos(float taxaOutrosRendimentos) {
        Desempregado.taxaOutrosRendimentos = taxaOutrosRendimentos;
    }
}

