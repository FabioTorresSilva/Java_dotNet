package aniversarios;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Testes unitários da classe Data.
 * 
 * @author ISEP-DEI-LEI-PPROG
 */

public class DataTest {

    /**
     * Testes do método setData da class Data.
     */

    @Test
    public void testSetDataComDataValida1() {
        System.out.println("setData: data válida 1 ");

        int ano = 2018;
        int mes = 12;
        int dia = 1;
        Data instance = new Data();

        instance.setData(ano, mes, dia);

        assertTrue(instance.getAno() == ano);
        assertTrue(instance.getMes() == mes);
        assertTrue(instance.getDia() == dia);

    }

    @Test
    public void testSetDataComDataValida2() {
        System.out.println("setData: data válida 2");

        // ano bissexto
        int ano =  2004;
        int mes = 2;
        int dia = 29;
        Data instance = new Data();

        instance.setData(ano, mes, dia);

        assertTrue(instance.getAno() == ano);
        assertTrue(instance.getMes() == mes);
        assertTrue(instance.getDia() == dia);

    }

    @Test(expected = MesInvalidoException.class)
    public void testSetDataComMesInvalido1() {
        System.out.println("setData: mês inválido 1");
        // mês < 1
        int ano = 2018;
        int mes = 0;
        int dia = 1;
        Data instance = new Data();

        instance.setData(ano, mes, dia);

    }

    @Test(expected = MesInvalidoException.class)
    public void testSetDataComMesInvalido2() {
        System.out.println("setData: mês inválido 2");
        // mês > 12
        int ano = 2018;
        int mes = 13;
        int dia = 1;
        Data instance = new Data();

        instance.setData(ano, mes, dia);

    }

    @Test(expected = DiaInvalidoException.class)
    public void testSetDataComDiaInvalido1() {
        System.out.println("setData: dia < 1");

        int ano = 2018;
        int mes = 1;
        int dia = 0;

        Data instance = new Data();

        instance.setData(ano, mes, dia);

    }

    @Test(expected = DiaInvalidoException.class)
    public void testSetDataComDiaInvalido2() {
        System.out.println("setData: dia > último dia do mês");

        int ano = 2018;
        int mes = 1;
        int dia = 32;

        Data instance = new Data();

        instance.setData(ano, mes, dia);
    }

    @Test(expected = DiaInvalidoException.class)
    public void testSetDataComDiaInvalido3() {
        System.out.println("setData: ano bissexto");

        int ano = 2023;
        int mes = 2;
        int dia = 29;

        Data instance = new Data();

        instance.setData(ano, mes, dia);
    }

}