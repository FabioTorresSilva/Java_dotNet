package org.upskill.vencimentos;


public class TrabalhadorHora extends Trabalhador {

    private int numeroHoras;

    private float pagamentoHora;

    private static final int NUMERO_HORAS_POR_OMISSAO = 0;

    private static final int PAGAMENTO_HORA_POR_OMISSAO = 10;

    public TrabalhadorHora(String nome, int numeroHoras, float pagamentoHora) {
        super(nome);
        this.numeroHoras = numeroHoras;
        this.pagamentoHora = pagamentoHora;
    }

    public TrabalhadorHora(String nome) {
        super(nome);
        numeroHoras = NUMERO_HORAS_POR_OMISSAO;
        pagamentoHora = PAGAMENTO_HORA_POR_OMISSAO;
    }

    public TrabalhadorHora() {
        super();
        numeroHoras = NUMERO_HORAS_POR_OMISSAO;
        pagamentoHora = PAGAMENTO_HORA_POR_OMISSAO;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public float getPagamentoHora() {
        return pagamentoHora;
    }


    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public void setPagamentoHora(float pagamentoHora) {
        this.pagamentoHora = pagamentoHora;
    }

    @Override
    public String toString() {
        return String.format("Trabalhador à Hora: %s %nNº de Horas de Trabalho: "
                + "%d %nPagamento por Hora: %.2f€",
                super.toString(), numeroHoras, pagamentoHora);
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        TrabalhadorHora t = (TrabalhadorHora) outroObjeto;
        return this.numeroHoras == t.getPagamentoHora()
                && this.pagamentoHora == t.getPagamentoHora();
    }

    @Override
    public float calcularVencimento() {
        return numeroHoras * pagamentoHora;
    }
}