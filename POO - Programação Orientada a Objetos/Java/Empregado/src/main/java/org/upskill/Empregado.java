package org.upskill;
import org.upskill.utils.Data;
import org.upskill.utils.Tempo;

//Pretende-se uma classe de nome Empregado que satisfaça os seguintes requisitos:
//• Possua os atributos: primeiroNome, ultimoNome, dataContrato, horaEntrada e horaSaida. O
//atributo dataContrato deve ser um objeto da classe Data fornecida. Os atributos horaEntrada
//e horaSaida devem ser objetos da classe Tempo também disponibilizada;
// private int ano;
//    private int mes;
//    private int dia;
//    private static final int ANO_POR_OMISSAO = 1;
//    private static final int MES_POR_OMISSAO = 1;
//    private static final int DIA_POR_OMISSAO = 1;
//    private static String[] nomeDiaDaSemana = new String[]{"Domingo", "Segunda-feira", "Ter�a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S�bado"};
//    private static int[] diasPorMes = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//    private static String[] nomeMes = new String[]{"Inv�lido", "Janeiro", "Fevereiro", "Mar�o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
//
//    public Data(int ano, int mes, int dia) {
//        this.ano = ano;
//        this.mes = mes;
//        this.dia = dia;
//    }

public class Empregado {
    private String primeiroNome;
    private String ultimoNome;
    private Data dataContrato;
    private Tempo horaEntrada;
    private Tempo horaSaida;

    private static final String PRIMEIRO_NOME_POR_OMISSAO="";
    private static final String ULTIMO_NOME_POR_OMISSAO="";
    private static final Data DATA_POR_OMISSAO = new Data();
    private static final Tempo HORA_ENTRADA_POR_OMISSAO = new Tempo();
    private static final Tempo HORA_SAIDA_POR_OMISSAO= new Tempo();

    public Empregado(){
        this.primeiroNome = PRIMEIRO_NOME_POR_OMISSAO;
        this.ultimoNome = ULTIMO_NOME_POR_OMISSAO;
        this.dataContrato = DATA_POR_OMISSAO;
        this.horaEntrada = HORA_ENTRADA_POR_OMISSAO;
        this.horaSaida = HORA_SAIDA_POR_OMISSAO;
    }

    public Empregado (String primeiroNome, String ultimoNome, Data dataContrato, Tempo horaEntrada, Tempo horaSaida ){
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = dataContrato;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public Empregado (Empregado outroEmpregado){
        this.primeiroNome = outroEmpregado.primeiroNome;
        this.ultimoNome = outroEmpregado.ultimoNome;
        this.dataContrato = outroEmpregado.dataContrato;
        this.horaEntrada = outroEmpregado.horaEntrada;
        this.horaSaida = outroEmpregado.horaSaida;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Tempo getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Data getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Data dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Tempo getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida = horaSaida;
    }
}
