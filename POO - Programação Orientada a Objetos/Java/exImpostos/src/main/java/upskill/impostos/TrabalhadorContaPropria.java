
package upskill.impostos;

/**
 * Representa um trabalhador por conta própria através do seu nome, morada,
 * rendimentos do trabalho, outros rendimentos e profissão.
 *
 * @author ISEP-DEI-PPROG
 */
public class TrabalhadorContaPropria extends ContribuinteComRendimentosTrabalho {

    /**
     * A profissão do trabalhador por conta própria.
     */
    private String profissao;

    /**
     * O nome da profissão por omissão.
     */
    private static final String PROFISSAO_POR_OMISSAO = "sem profissão";

    /**
     * O limite do 1º escalão dos outros rendimentos dos trabalhadores por conta
     * própria.
     */
    private static float escalao1OutrosRendimentos = 50000;
    
    /**
     * A taxa(%) sobre os rendimentos do trabalho aplicada a todos os
     * trabalhadores por conta própria.
     */
    private static float taxaRendimentosTrabalho = 3;
    
    /**
     * A taxa(%) sobre os outros rendimentos 1 aplicada a todos os trabalhadores
     * por conta própria.
     */
    private static float taxaOutrosRendimentos1 = 2;
    
    /**
     * A taxa(%) sobre os outros rendimentos 2 aplicada a todos os trabalhadores
     * por conta própria.
     */
    private static float taxaOutrosRendimentos2 = 5;

    /**
     * Constrói uma instãncia de TrabalhadorContaPropria recebendo o seu nome, 
     * morada, rendimentos do trabalho, outros rendimentos e profissão.
     *
     * @param nome o nome do trabalhador por conta própria
     * @param morada a morada do trabalhador por conta própria
     * @param rendimentosTrabalho os rendimentos do trabalho do trabalhador por 
     *                            conta própria
     * @param outrosRendimentos outros rendimentos do trabalhador por conta 
     *                          própria
     * @param profissao a profissão do trabalhador por conta própria
     */
    public TrabalhadorContaPropria(String nome, 
                                     String morada, 
                                     float rendimentosTrabalho, 
                                     float outrosRendimentos,
                                     String profissao) {
        super(nome, morada, rendimentosTrabalho, outrosRendimentos);
        this.profissao = profissao;
    }

    /**
     * Constrói uma instância de TrabalhadorContaPropria atribuindo o nome por 
     * omissão, a morada por omissão, a profissão por omissão, os rendimentos do 
     * trabalho por omissão e os outros rendimentos por omissão.
     */
    public TrabalhadorContaPropria() {
        super();
        profissao = PROFISSAO_POR_OMISSAO;
    }

    /**
     * Devolve a profissão do trabalhador por conta própria.
     *
     * @return profissão do trabalhador por conta própria
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Modifica a profissão do trabalhador por conta própria.
     *
     * @param profissao a nova profissão do trabalhador por conta própria
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * Devolve a descrição textual do trabalhador por conta própria.
     *
     * @return características do trabalhador por conta própria
     */
    @Override
    public String toString() {
        return String.format("TRABALHADOR POR CONTA PROPRIA %n%s%nProfissao: %s ", super.toString(), profissao);
    }

    /**
     * Devolve a taxa sobre os rendimentos do trabalho do trabalhador por conta
     * própria.
     *
     * @return taxa(%) sobre os rendimentos do trabalho do trabalhador por conta
     *         própria
     */
    @Override
    public float obterTaxaRendimentosTrabalho() {
        return taxaRendimentosTrabalho;
    }

    /**
     * Devolve a taxa sobre os outros rendimentos do trabalhador por conta
     * própria.
     *
     * @return taxa(%) sobre os outros rendimentos do trabalhador por conta
     *         própria
     */
    @Override
    public float obterTaxaOutrosRendimentos() {
        return (getOutrosRendimentos() <= escalao1OutrosRendimentos) ? taxaOutrosRendimentos1: taxaOutrosRendimentos2;
    }

    /**
     * Devolve o limite do 1º escalão dos outros rendimentos dos trabalhadores
     * por conta própria.
     *
     * @return o limite do 1º escalão dos outros rendimentos dos trabalhadores
     *         por conta própria
     */
    public static float getEscalao1OutrosRendimentos() {
        return escalao1OutrosRendimentos;
    }

    /**
     * Devolve a taxa sobre os rendimentos do trabalho aplicada a todos os
     * trabalhadores por conta própria.
     *
     * @return taxa(%) sobre os rendimentos do trabalho dos trabalhadores por
     *         conta própria
     */
    public static float getTaxaRendimentosTrabalho() {
        return taxaRendimentosTrabalho;
    }

    /**
     * Devolve a taxa sobre os outros rendimentos 1 aplicada a todos os
     * trabalhadores por conta própria.
     *
     * @return taxa(%) sobre os outros rendimentos 1 dos trabalhadores por 
     *         conta própria
     */
    public static float getTaxaOutrosRendimentos1() {
        return taxaOutrosRendimentos1;
    }

    /**
     * Devolve a taxa sobre os outros rendimentos 2 aplicada a todos os
     * trabalhadores por conta própria.
     *
     * @return taxa(%) sobre os outros rendimentos 2 dos trabalhadores por 
     *         conta própria
     */
    public static float getTaxaOutrosRendimentos2() {
        return taxaOutrosRendimentos2;
    }

    /**
     * Modifica a taxa sobre os rendimentos do trabalho aplicada a todos os
     * trabalhadores por conta própria.
     *
     * @param taxaRendimentosTrabalho a nova taxa(%) sobre os rendimentos do 
     *                                trabalho dos trabalhadores por conta 
     *                                própria
     */
    public static void setTaxaRendimentosTrabalho(float taxaRendimentosTrabalho) {
        TrabalhadorContaPropria.taxaRendimentosTrabalho = taxaRendimentosTrabalho;
    }

    /**
     * Modifica a taxa sobre os outros rendimentos 1 aplicada a todos os
     * trabalhadores por conta própria.
     *
     * @param taxaOutrosRendimentos1 a nova taxa(%) sobre os outros 
     *                               rendimentos 1 dos trabalhadores 
     *                               por conta própria
     */
    public static void setTaxaOutrosRendimentos1(float taxaOutrosRendimentos1) {
        TrabalhadorContaPropria.taxaOutrosRendimentos1 = taxaOutrosRendimentos1;
    }

    /**
     * Modifica a taxa sobre os outros rendimentos 2 aplicada a todos os
     * trabalhadores por conta própria.
     *
     * @param taxaOutrosRendimentos2 a nova taxa(%) sobre os outros 
     *                               rendimentos 2 dos trabalhadores  
     *                               por conta própria
     */
    public static void setTaxaOutrosRendimentos2(float taxaOutrosRendimentos2) {
        TrabalhadorContaPropria.taxaOutrosRendimentos2 = taxaOutrosRendimentos2;
    }

    /**
     * Modifica o limite do 1º escalão dos outros rendimentos dos trabalhadores
     * por conta própria.
     *
     * @param escalao1OutrosRendimentos o novo limite do 1º escalão dos outros 
     *                                  rendimentos dos trabalhadores por conta 
     *                                  própria
     */
    public static void setEscalao1OutrosRendimentos(float escalao1OutrosRendimentos) {
        TrabalhadorContaPropria.escalao1OutrosRendimentos = escalao1OutrosRendimentos;
    }
}

