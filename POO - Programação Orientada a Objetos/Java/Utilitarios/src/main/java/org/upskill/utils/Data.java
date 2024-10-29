package org.upskill.utils;

import java.util.Calendar;

/**
 * Representa uma data atrav�s do dia, m�s e ano.
 *
 * @author ISEP-DEI-PPROG
 */
public class Data implements Comparable<Data> {

    /**
     * O ano da data.
     */
    private int ano;

    /**
     * O m�s da data.
     */
    private int mes;

    /**
     * O dia da data.
     */
    private int dia;

    /**
     * O ano por omiss�o.
     */
    private static final int ANO_POR_OMISSAO = 1;

    /**
     * O m�s por omiss�o.
     */
    private static final int MES_POR_OMISSAO = 1;

    /**
     * O dia por omiss�o.
     */
    private static final int DIA_POR_OMISSAO = 1;

    /**
     * Nomes dos dias da semana.
     */
    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira",
            "Ter�a-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "S�bado"};

    /**
     * N�mero de dias de cada m�s do ano.
     */
    private static int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
            31, 30, 31};

    /**
     * Nomes dos meses do ano.
     */
    private static String[] nomeMes = {"Inv�lido", "Janeiro", "Fevereiro",
            "Mar�o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
            "Outubro", "Novembro", "Dezembro"};

    /**
     * Constroi uma inst�ncia de Data recebendo o ano, o m�s e o dia.
     *
     * @param ano o ano da data.
     * @param mes o m�s da data.
     * @param dia o dia da data.
     */
    public Data(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * Constroi uma inst�ncia de Data com a data por omiss�o.
     */
    public Data() {
        ano = ANO_POR_OMISSAO;
        mes = MES_POR_OMISSAO;
        dia = DIA_POR_OMISSAO;
    }

    /**
     * Constroi uma inst�ncia de Data com as mesmas caracter�sticas da data
     * recebida por par�metro.
     *
     * @param outraData a data com as caracter�sticas a copiar.
     */
    public Data(Data outraData) {
        ano = outraData.ano;
        mes = outraData.mes;
        dia = outraData.dia;
    }

    /**
     * Devolve o ano da data.
     *
     * @return ano da data
     */
    public int getAno() {
        return ano;
    }

    /**
     * Devolve o m�s da data.
     *
     * @return m�s da data.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Devolve o dia da data.
     *
     * @return dia da data.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Modifica o ano, o m�s e o dia da data.
     *
     * @param ano o novo ano da data.
     * @param mes o novo m�s da data.
     * @param dia o novo dia da data.
     */
    public void setData(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * Devolve a descri��o textual da data no formato: diaDaSemana, dia de m�s
     * de ano.
     *
     * @return caracter�sticas da data.
     */
    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", diaDaSemana(), dia,
                nomeMes[mes], ano);
    }

    /**
     * Devolve a data no formato:%04d/%02d/%02d.
     *
     * @return caracter�sticas da data.
     */
    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes, dia);
    }

    /**
     * Compara a data com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com a data.
     * @return true se o objeto recebido representar uma data equivalente �
     *         data. Caso contr�rio, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Data outraData = (Data) outroObjeto;
        return ano == outraData.ano && mes == outraData.mes
                && dia == outraData.dia;
    }

    /**
     * Compara a data com a outra data recebida por par�metro.
     *
     * @param outraData a data a ser comparada.
     * @return o valor 0 se a outraData recebida � igual � data; o valor -1 se
     *         a outraData for posterior � data; o valor 1 se a outraData for
     *         anterior � data.
     */
    @Override
    public int compareTo(Data outraData) {
        return (outraData.isMaior(this)) ? -1 : (isMaior(outraData)) ? 1 : 0;
    }

    /**
     * Devolve o dia da semana da data.
     *
     * @return dia da semana da data.
     */
    public String diaDaSemana() {
        int totalDias = contaDias();
        totalDias = totalDias % 7;

        return nomeDiaDaSemana[totalDias];
    }


    /**
     * Devolve true se a data for maior do que a data recebida por par�metro. Se
     * a data for menor ou igual � data recebida por par�metro, devolve false.
     *
     * @param outraData a outra data com a qual se compara a data.
     * @return true se a data for maior do que a data recebida por par�metro,
     *         caso contr�rio devolve false.
     */
    public boolean isMaior(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return totalDias > totalDias1;
    }

    /**
     * Devolve a diferen�a em n�mero de dias entre a data e a data recebida por
     * par�metro.
     *
     * @param outraData a outra data com a qual se compara a data para calcular
     *                  a diferen�a do n�mero de dias.
     * @return diferen�a em n�mero de dias entre a data e a data recebida por
     *         par�metro.
     */
    public int diferenca(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }

    /**
     * Devolve a diferen�a em n�mero de dias entre a data e a data recebida por
     * par�metro com ano, m�s e dia.
     *
     * @param ano o ano da data com a qual se compara a data para calcular a
     *            diferen�a do n�mero de dias.
     * @param mes o m�s da data com a qual se compara a data para calcular a
     *            diferen�a do n�mero de dias.
     * @param dia o dia da data com a qual se compara a data para calcular a
     *            diferen�a do n�mero de dias.
     * @return diferen�a em n�mero de dias entre a data e a data recebida por
     *         par�metro com ano, m�s e dia.
     */
    public int diferenca(int ano, int mes, int dia) {
        int totalDias = contaDias();
        Data outraData = new Data(ano, mes, dia);
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }

    /**
     * Devolve true se o ano passado por par�metro for bissexto. Se o ano
     * passado por par�metro n�o for bissexto, devolve false.
     *
     * @param ano o ano a validar.
     * @return true se o ano passado por par�metro for bissexto, caso contr�rio
     *         devolve false.
     */
    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    /**
     * Devolve a data atual do sistema.
     *
     * @return a data atual do sistema.
     */
    public static Data dataAtual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;    // janeiro � representado por 0
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Data(ano, mes, dia);
    }

    /**
     * Devolve o n�mero de dias desde o dia 1/1/1 at� � data.
     *
     * @return n�mero de dias desde o dia 1/1/1 at� � data.
     */
    private int contaDias() {
        int totalDias = 0;

        for (int i = 1; i < ano; i++) {
            totalDias += isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes; i++) {
            totalDias += diasPorMes[i];
        }
        totalDias += (isAnoBissexto(ano) && mes > 2) ? 1 : 0;
        totalDias += dia;

        return totalDias;
    }
}
