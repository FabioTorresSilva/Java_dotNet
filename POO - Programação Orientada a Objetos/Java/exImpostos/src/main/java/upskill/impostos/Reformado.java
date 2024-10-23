
package upskill.impostos;

/**
 * Representa um reformado através do seu nome, morada, rendimentos do trabalho
 * e outros rendimentos.
 *
 * @author ISEP-DEI-PPROG
 */
public class Reformado extends ContribuinteComRendimentosTrabalho {

    /**
     * A taxa(%) sobre os rendimentos do trabalho aplicada a todos os reformados.
     */
    private static float taxaRendimentosTrabalho = 1;
    
    /**
     * A taxa(%) sobre os outros rendimentos aplicada a todos os reformados.
     */
    private static float taxaOutrosRendimentos = 3;

    /**
     * Constrói uma instância de Reformado recebendo o seu nome, morada,
     * rendimentos do trabalho e outros rendimentos.
     *
     * @param nome o nome do reformado
     * @param morada a morada do reformado
     * @param rendimentosTrabalho o montante dos rendimentos do trabalho do 
     *                            reformado
     * @param outrosRendimentos o montante dos outros rendimentos do reformado
     */
    public Reformado(String nome, String morada, float rendimentosTrabalho, 
                     float outrosRendimentos) {
        super(nome, morada, rendimentosTrabalho, outrosRendimentos);
    }

    /**
     * Constrói uma instância de Reformado atribuindo o nome por omissão, a
     * morada por omissão, os rendimentos do trabalho por omissão e os outros 
     * rendimentos por omissão.
     */
    public Reformado() {
        super();
    }

    /**
     * Devolve a descrição textual do reformado.
     *
     * @return características do reformado
     */
    @Override
    public String toString() {
        return String.format("REFORMADO %n%s ", super.toString()); 
    }

    /**
     * Devolve a taxa sobre os rendimentos do trabalho do reformado.
     *
     * @return taxa(%) sobre os rendimentos do trabalho do reformado
     */
    @Override
    public float obterTaxaRendimentosTrabalho() {
        return taxaRendimentosTrabalho;
    }

    /**
     * Devolve a taxa sobre os outros rendimentos do reformado.
     *
     * @return taxa(%) sobre os outros rendimentos do reformado
     */
    @Override
    public float obterTaxaOutrosRendimentos() {
        return taxaOutrosRendimentos;
    }

    /**
     * Devolve a taxa sobre os rendimentos do trabalho aplicada a todos os
     * reformados.
     *
     * @return taxa(%) sobre os rendimentos do trabalho dos reformados
     */
    public static float getTaxaRendimentosTrabalho() {
        return taxaRendimentosTrabalho;
    }

    /**
     * Devolve a taxa sobre os outros rendimentos aplicada a todos os
     * reformados.
     *
     * @return taxa(%) sobre os outros rendimentos dos reformados
     */
    public static float getTaxaOutrosRendimentos() {
        return taxaOutrosRendimentos;
    }

    /**
     * Modifica a taxa sobre os rendimentos do trabalho aplicada a todos os
     * reformados.
     *
     * @param taxaRendimentosTrabalho a nova taxa(%) sobre os rendimentos do 
     *                                trabalho dos reformados
     * 
     */
    public static void setTaxaRendimentosTrabalho(float taxaRendimentosTrabalho) {
        Reformado.taxaRendimentosTrabalho = taxaRendimentosTrabalho;
    }

    /**
     * Modifica a taxa sobre os outros rendimentos aplicada a todos os
     * reformados.
     *
     * @param taxaOutrosRendimentos a nova taxa(%) sobre os outros rendimentos 
     *                              dos reformados
     */
    public static void setTaxaOutrosRendimentos(float taxaOutrosRendimentos) {
        Reformado.taxaOutrosRendimentos = taxaOutrosRendimentos;
    }
}

