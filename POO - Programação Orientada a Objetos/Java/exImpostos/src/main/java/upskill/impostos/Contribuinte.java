
package upskill.impostos;

/**
 * Esta classe permite a construção de uma hierarquia de classes para
 * representarem diferentes tipos de contribuintes. Especifica membros 
 * comuns a todas as classes da hierarquia.
 *
 * @author ISEP-DEI-PPROG
 */
public abstract class Contribuinte {

    /**
     * O nome do contribuinte.
     */
    private String nome;
    
    /**
     * A morada do contribuinte.
     */
    private String morada;
    
    /**
     * O valor dos outros rendimentos do contribuinte.
     */
    private float outrosRendimentos;

    /**
     * O nome do contribuinte por omissão.
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    
    /**
     * A morada do contribuinte por omissão.
     */
    private static final String MORADA_POR_OMISSAO = "sem morada";
    
    /**
     * O valor por omissão dos outros rendimentos do contribuinte.
     */
    private static final float OUTROS_RENDIMENTOS_POR_OMISSAO = -1;

    /**
     * Inicializa o estado do contribuinte atribuindo o nome, a morada e os 
     * outros rendimentos do contribuinte recebidos.
     *
     * @param nome o nome do contribuinte
     * @param morada a morada do contribuinte
     * @param outrosRendimentos os outros rendimentos do contribuinte
     */
    public Contribuinte(String nome, String morada, float outrosRendimentos) {
        this.nome = nome;
        this.morada = morada;
        this.outrosRendimentos = outrosRendimentos;
    }

    /**
     * Inicializa o estado do contribuinte atribuindo o nome por omissão, a
     * morada por omissão e os outros rendimentos por omissão.
     */
    public Contribuinte() {
        nome = NOME_POR_OMISSAO;
        morada = MORADA_POR_OMISSAO;
        outrosRendimentos = OUTROS_RENDIMENTOS_POR_OMISSAO;
    }

    /**
     * Devolve o nome do contribuinte.
     *
     * @return nome do contribuinte
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a morada do contribuinte.
     *
     * @return morada do contribuinte
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Devolve os outros rendimentos do contribuinte.
     *
     * @return o valor dos outros rendimentos do contribuinte
     */
    public float getOutrosRendimentos() {
        return outrosRendimentos;
    }

    /**
     * Modifica o nome do contribuinte.
     *
     * @param nome o novo nome do contribuinte
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica a morada do contribuinte.
     *
     * @param morada a nova morada do contribuinte
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Modifica os outros rendimentos do contribuinte.
     *
     * @param outrosRendimentos o novo valor dos outros rendimentos do 
     *                          contribuinte
     */
    public void setOutrosRendimentos(float outrosRendimentos) {
        this.outrosRendimentos = outrosRendimentos;
    }

    /**
     * Devolve a representação textual do contribuinte.
     *
     * @return representação textual do contribuinte
     */
    @Override
    public String toString() {
        return String.format("Nome: %s %nMorada: %s %nOutros Rendimentos: %.2f€",
                                nome, morada, outrosRendimentos);
    }

    /**
     * Permite o cálculo do imposto de um contribuinte através do polimorfismo.
     *
     * @return montante do imposto do contribuinte
     */
    public abstract float calcularImposto();

}
