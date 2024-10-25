package org.upskill.vencimentos;


public class TrabalhadorComissao extends Trabalhador {

    private float salarioBase;

    private float vendas;

    private int premio;

    private float comissao;

    private static final float SALARIO_BASE_POR_OMISSAO = 530;

    private static final int VENDAS_POR_OMISSAO = 0;

    private static final int COMISSAO_POR_OMISSAO = 0;

    public TrabalhadorComissao(String nome, float salarioBase, float vendas,
                               float comissao, int premio) {
        super(nome);
        this.salarioBase = salarioBase;
        this.vendas = vendas;
        this.comissao = comissao;
        this.premio = premio;
    }
    public TrabalhadorComissao(String nome, float salarioBase, float vendas,
                               float comissao) {
        super(nome);
        this.salarioBase = salarioBase;
        this.vendas = vendas;
        this.comissao = comissao;

    }

    public TrabalhadorComissao(String nome) {
        super(nome);
        salarioBase = SALARIO_BASE_POR_OMISSAO;
        vendas = VENDAS_POR_OMISSAO;
        comissao = COMISSAO_POR_OMISSAO;
    }

    public TrabalhadorComissao() {
        super();
        salarioBase = SALARIO_BASE_POR_OMISSAO;
        vendas = VENDAS_POR_OMISSAO;
        comissao = COMISSAO_POR_OMISSAO;
    }


    public float getSalarioBase() {
        return salarioBase;
    }

    public float getVendas() {
        return vendas;
    }

    public float getComissao() {
        return comissao;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setVendas(float vendas) {
        this.vendas = vendas;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return String.format("Trabalhador à Comissão: %s"
                        + "%nSalário Base: %.2f€"
                        + "%nVendas: %.2f€"
                        + "%nComissão: %.1f%%"
                        + "%nPremio: %d",
                super.toString(), salarioBase, vendas, comissao, premio);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        TrabalhadorComissao t = (TrabalhadorComissao) outroObjeto;
        return this.salarioBase == t.getSalarioBase()
                && this.vendas == t.getVendas()
                && this.comissao == t.getComissao();
    }

    @Override
    public float calcularVencimento() {
        return (vendas > 10000) ? salarioBase + premio + vendas * (comissao / 100) : salarioBase + vendas * (comissao / 100);
    }
}