package org.upskill;

import org.upskill.utils.Data;
import org.upskill.utils.Tempo;

public class Empregado {
    private String primeiroNome;
    private String ultimoNome;
    private final Data dataContrato;
    private final Tempo horaEntrada;
    private final Tempo horaSaida;

    private static final String PRIMEIRO_NOME_POR_OMISSAO = "";
    private static final String ULTIMO_NOME_POR_OMISSAO = "";
    private static final Data DATA_POR_OMISSAO = new Data();
    private static final Tempo HORA_ENTRADA_POR_OMISSAO = new Tempo();
    private static final Tempo HORA_SAIDA_POR_OMISSAO = new Tempo();

    public Empregado() {
        this.primeiroNome = PRIMEIRO_NOME_POR_OMISSAO;
        this.ultimoNome = ULTIMO_NOME_POR_OMISSAO;
        this.dataContrato = DATA_POR_OMISSAO;
        this.horaEntrada = HORA_ENTRADA_POR_OMISSAO;
        this.horaSaida = HORA_SAIDA_POR_OMISSAO;
    }

    public Empregado(Empregado outroEmpregado) {
        this.primeiroNome = outroEmpregado.primeiroNome;
        this.ultimoNome = outroEmpregado.ultimoNome;
        this.dataContrato = outroEmpregado.dataContrato;
        this.horaEntrada = outroEmpregado.horaEntrada;
        this.horaSaida = outroEmpregado.horaSaida;
    }

    public Empregado(String primeiroNome, String ultimoNome, Data dataContrato,
                     Tempo horaEntrada, Tempo horaSaida) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.dataContrato = new Data(dataContrato);
        this.horaEntrada = new Tempo(horaEntrada);
        this.horaSaida = new Tempo(horaSaida);
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
        return new Tempo(horaEntrada);
    }

    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada.setTempo(horaEntrada.getHoras(), horaEntrada.getMinutos(),
                horaEntrada.getSegundos());
    }

    public Data getDataContrato() {
        return new Data(dataContrato);
    }

    public void setDataContrato(Data dataContrato) {
        this.dataContrato.setData(dataContrato.getAno(), dataContrato.getMes(),
                dataContrato.getDia());
    }

    public void setDataContrato(int ano, int mes, int dia) {
        dataContrato.setData(ano, mes, dia);
    }

    public Tempo getHoraSaida() {
        return new Tempo(horaSaida);
    }

    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida.setTempo(horaSaida.getHoras(), horaSaida.getMinutos(),
                horaSaida.getSegundos());
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Empregado outroEmpregado = (Empregado) outroObjeto;
        return primeiroNome.equalsIgnoreCase(outroEmpregado.primeiroNome)
                && ultimoNome.equalsIgnoreCase(outroEmpregado.ultimoNome)
                && dataContrato.equals(outroEmpregado.dataContrato)
                && horaEntrada.equals(outroEmpregado.horaEntrada)
                && horaSaida.equals(outroEmpregado.horaSaida);
    }

    public double calcularHorasTrabalhoSemanal() {
        int minutosEntrada = horaEntrada.getHoras() * 60 + horaEntrada.getMinutos();
        int minutosSaida = horaSaida.getHoras() * 60 + horaSaida.getMinutos();
        double horasTrabalhoDiario = (minutosSaida - minutosEntrada) / 60.0;
        return horasTrabalhoDiario * 5;
    }

    public String tempoContratado() {
        Data dataAtual = Data.dataAtual();

        int anos = dataAtual.getAno() - dataContrato.getAno();
        int meses = dataAtual.getMes() - dataContrato.getMes();
        int dias = dataAtual.getDia() - dataContrato.getDia();

        if (dias < 0) {
            meses--;
            dias += 30;
        }
        if (meses < 0) {
            anos--;
            meses += 12;
        }

        return String.format("%d anos, %d meses e %d dias", anos, meses, dias);
    }

    @Override
    public String toString() {
        return String.format("%s %s, Contratado em: %s, Hora de Entrada: %s, Hora de Saída: %s",
                primeiroNome, ultimoNome, dataContrato.toAnoMesDiaString(), horaEntrada.toStringHHMMSS(), horaSaida.toStringHHMMSS());
    }
}