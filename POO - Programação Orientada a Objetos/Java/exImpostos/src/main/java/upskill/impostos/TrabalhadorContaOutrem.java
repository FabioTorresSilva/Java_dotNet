
package upskill.impostos;

/**
 * Representa um trabalhador por conta de outrem através do seu nome, morada,
 * rendimentos do trabalho, outros rendimentos e empresa do trabalhador.
 *
 * @author ISEP-DEI-PPROG
 */
public class TrabalhadorContaOutrem extends ContribuinteComRendimentosTrabalho {

    /**
     * O nome da empresa do trabalhador por conta de outrem.
     */
    private String empresa;

    /**
     * O nome da empresa por omissão.
     */
    private static final String EMPRESA_POR_OMISSAO = "sem empresa";

    /**
     * O limite do 1º escalão de rendimentos do trabalho aplicado a todos os
     * trabalhadores por conta de outrem.
     */
    private static float escalao1RendimentosTrabalho = 30000;
    
    /**
     * A taxa(%) sobre os rendimentos do trabalho 1 aplicada a todos os
     * trabalhadores por conta de outrem.
     */
    private static float taxaRendimentosTrabalho1 = 1;
    
    /**
     * A taxa(%) sobre os rendimentos do trabalho 2 aplicada a todos os
     * trabalhadores por conta de outrem.
     */
    private static float taxaRendimentosTrabalho2 = 2;
    
    /**
     * A taxa(%) sobre os outros rendimentos aplicada a todos os trabalhadores
     * por conta de outrem.
     */
    private static float taxaOutrosRendimentos = 2;

    /**
     * Constrói uma instância de TrabalhadorContaOutrem recebendo o seu nome, 
     * morada, rendimentos do trabalho, outros rendimentos e nome da empresa.
     *
     * @param nome o nome do trabalhador por conta de outrem
     * @param morada a morada do trabalhador por conta de outrem
     * @param rendimentosTrabalho os rendimentos do trabalho do trabalhador por 
     *                            conta de outrem
     * @param outrosRendimentos outros rendimentos do trabalhador por conta de 
     *                          outrem
     * @param empresa o nome da empresa do trabalhador por conta de outrem
     */
    public TrabalhadorContaOutrem(String nome, 
                                  String morada, 
                                  float rendimentosTrabalho, 
                                  float outrosRendimentos, 
                                  String empresa) {
        super(nome, morada, rendimentosTrabalho, outrosRendimentos);
        this.empresa = empresa;
    }

    /**
     * Constrói uma instância de TrabalhadorContaOutrem atribuindo o nome por 
     * omissão, a morada por omissão, a empresa por omissão, os rendimentos do 
     * trabalho por omissão e os outros rendimentos por omissão.
     */
    public TrabalhadorContaOutrem() {
        super();
        empresa = EMPRESA_POR_OMISSAO;
    }

    /**
     * Devolve o nome da empresa do trabalhador por conta de outrem.
     *
     * @return nome da empresa do trabalhador por conta de outrem
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Modifica a empresa do trabalhador por conta de outrem.
     *
     * @param empresa a nova empresa do trabalhador por conta de outrem
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Devolve a descrição textual do trabalhador por conta de outrem.
     *
     * @return características do trabalhador por conta de outrem
     */
    @Override
    public String toString() {
        return String.format("TRABALHADOR POR CONTA DE OUTREM %n%s"
                              + "%nEmpresa: %s ", super.toString(), empresa); 
    }

    /**
     * Devolve a taxa sobre os rendimentos do trabalho do trabalhador por conta 
     * de outrem.
     *
     * @return taxa(%) sobre os rendimentos do trabalho do trabalhador por conta
     *         de outrem
     */
    @Override
    public float obterTaxaRendimentosTrabalho() {
        return (getRendimentosTrabalho() <= escalao1RendimentosTrabalho)? taxaRendimentosTrabalho1: taxaRendimentosTrabalho2;
    }

    /**
     * Devolve a taxa sobre os outros rendimentos do trabalhador por conta de
     * outrem.
     *
     * @return taxa(%) sobre os outros rendimentos do trabalhador por conta de
     *         outrem
     */
    @Override
    public float obterTaxaOutrosRendimentos() {
        return taxaOutrosRendimentos;
    }

    /**
     * Devolve o limite do 1º escalão dos rendimentos do trabalho dos 
     * trabalhadores por conta de outrem.
     *
     * @return limite do 1º escalão dos rendimentos do trabalho dos 
     *         trabalhadores por conta de outrem
     */
    public static float getEscalao1RendimentosTrabalho() {
        return escalao1RendimentosTrabalho;
    }

    /**
     * Devolve a taxa sobre os rendimentos do trabalho 1 aplicada a todos os
     * trabalhadores por conta de outrem.
     *
     * @return taxa(%) sobre os rendimentos do trabalho 1 dos trabalhadores 
     *         por conta de outrem
     */
    public static float getTaxaRendimentosTrabalho1() {
        return taxaRendimentosTrabalho1;
    }

    /**
     * Devolve a taxa sobre os rendimentos do trabalho 2 aplicada a todos os
     * trabalhadores por conta de outrem.
     *
     * @return taxa(%) sobre os rendimentos do trabalho 2 dos trabalhadores 
     *         por conta de outrem
     */
    public static float getTaxaRendimentosTrabalho2() {
        return taxaRendimentosTrabalho2;
    }

    /**
     * Devolve a taxa sobre os outros rendimentos aplicada a todos os
     * trabalhadores por conta de outrem.
     *
     * @return taxa(%) sobre os outros rendimentos dos trabalhadores 
     *         por conta de outrem
     */
    public static float getTaxaOutrosRendimentos() {
        return taxaOutrosRendimentos;
    }

    /**
     * Modifica o limite do 1º escalão dos rendimentos do trabalho de todos os
     * trabalhadores por conta de outrem.
     *
     * @param escalao1RendimentosTrabalho o novo limite do 1º escalão dos 
     *                                    rendimentos do trabalho dos  
     *                                    trabalhadores por conta de outrem
     */
    public static void setEscalao1RendimentosTrabalho(float escalao1RendimentosTrabalho) {
        TrabalhadorContaOutrem.escalao1RendimentosTrabalho = escalao1RendimentosTrabalho;
    }

    /**
     * Modifica a taxa sobre os rendimentos do trabalho 1 aplicada a todos os
     * trabalhadores por conta de outrem.
     *
     * @param taxaRendimentosTrabalho1 a nova taxa(%) sobre os rendimentos do 
     *                                 trabalho 1 dos trabalhadores por conta  
     *                                 de outrem
     */
    public static void setTaxaRendimentosTrabalho1(float taxaRendimentosTrabalho1) {
        TrabalhadorContaOutrem.taxaRendimentosTrabalho1 = taxaRendimentosTrabalho1;
    }

    /**
     * Modifica a taxa sobre os rendimentos do trabalho 2 aplicada a todos os
     * trabalhadores por conta de outrem.
     *
     * @param taxaRendimentosTrabalho2 a nova taxa(%) sobre os rendimentos do 
     *                                 trabalho 2 dos trabalhadores por conta 
     *                                 de outrem
     */
    public static void setTaxaRendimentosTrabalho2(float taxaRendimentosTrabalho2) {
        TrabalhadorContaOutrem.taxaRendimentosTrabalho2 = taxaRendimentosTrabalho2;
    }

    /**
     * Modifica a taxa sobre os outros rendimentos aplicada a todos os
     * trabalhadores por conta de outrem.
     *
     * @param taxaOutrosRendimentos a nova taxa(%) sobre os outros rendimentos 
     *                              dos trabalhadores por conta de outrem
     */
    public static void setTaxaOutrosRendimentos(float taxaOutrosRendimentos) {
        TrabalhadorContaOutrem.taxaOutrosRendimentos = taxaOutrosRendimentos;
    }
}
