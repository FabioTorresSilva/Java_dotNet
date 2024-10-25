package org.upskill.vencimentos;


public class TrabalhadorPeca extends Trabalhador {

    private int numeroPecasTipo1;

    private int numeroPecasTipo2;

    private static final int NUMERO_PECAS_TIPO1_POR_OMISSAO = 0;

    private static final int NUMERO_PECAS_TIPO2_POR_OMISSAO = 0;

    private static float pagamentoPecaTipo1 = 15.5f;

    private static float pagamentoPecaTipo2 = 20;

    private static float premioTrabPeca1000 = 0.05f;

    public TrabalhadorPeca(String nome, int numeroPecasTipo1, int numeroPecasTipo2) {
        super(nome);
        this.numeroPecasTipo1 = numeroPecasTipo1;
        this.numeroPecasTipo2 = numeroPecasTipo2;
    }

    public TrabalhadorPeca(String nome) {
        super(nome);
        numeroPecasTipo1 = NUMERO_PECAS_TIPO1_POR_OMISSAO;
        numeroPecasTipo2 = NUMERO_PECAS_TIPO2_POR_OMISSAO;
    }

    public TrabalhadorPeca() {
        super();
        numeroPecasTipo1 = NUMERO_PECAS_TIPO1_POR_OMISSAO;
        numeroPecasTipo2 = NUMERO_PECAS_TIPO2_POR_OMISSAO;
    }

    public int getNumeroPecasTipo1() {
        return numeroPecasTipo1;
    }




    public int getNumeroPecasTipo2() {
        return numeroPecasTipo2;
    }

    public void setNumeroPecasTipo1(int numeroPecasTipo1) {
        this.numeroPecasTipo1 = numeroPecasTipo1;
    }

    public void setNumeroPecasTipo2(int numeroPecasTipo2) {
        this.numeroPecasTipo2 = numeroPecasTipo2;
    }

    @Override
    public String toString() {
        return String.format("Trabalhador à Peça: %s %nNº de Peças do Tipo 1: "
                        + "%d %nNº de Peças do Tipo 2: %d",
                super.toString(), numeroPecasTipo1, numeroPecasTipo2);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        TrabalhadorPeca t = (TrabalhadorPeca) outroObjeto;
        return this.numeroPecasTipo1 == t.getNumeroPecasTipo1() && this.numeroPecasTipo2 == t.getNumeroPecasTipo2();
    }

    @Override
    public float calcularVencimento() {
        return (numeroPecasTipo1 + numeroPecasTipo2 >= 1000) ? (numeroPecasTipo1 * pagamentoPecaTipo1 + numeroPecasTipo2 * pagamentoPecaTipo2)* premioTrabPeca1000 : numeroPecasTipo1 * pagamentoPecaTipo1 + numeroPecasTipo2 * pagamentoPecaTipo2;
    }

    public static float getPagamentoPecaTipo1() {
        return pagamentoPecaTipo1;
    }

    public static float getPagamentoPeca2() {
        return pagamentoPecaTipo2;
    }
    public static float getPremioTrabPeca1000() {
        return premioTrabPeca1000;
    }

    public static void setPagamentoPecaTipo1(float pagamentoPecaTipo1) {
        TrabalhadorPeca.pagamentoPecaTipo1 = pagamentoPecaTipo1;
    }

    public static void setPagamentoPeca2(float pagamentoPecaTipo2) {
        TrabalhadorPeca.pagamentoPecaTipo2 = pagamentoPecaTipo2;
    }
}
