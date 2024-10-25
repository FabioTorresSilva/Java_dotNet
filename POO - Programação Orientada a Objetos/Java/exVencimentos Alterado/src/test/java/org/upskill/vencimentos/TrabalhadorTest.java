package org.upskill.vencimentos;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TrabalhadorTest {

    @org.junit.Test
    public void testCalcularVencimentoHora() {
        System.out.println("calcular Vencimento trabalhador Hora");
        TrabalhadorHora instance = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);
        float expResult = instance.getNumeroHoras() * instance.getPagamentoHora();
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }

    @org.junit.Test
    public void testCalcularVencimentoComissao() {
        System.out.println("calcular Vencimento trabalhador Comissao");
        TrabalhadorComissao instance = new TrabalhadorComissao("Susana Ferreira", 500.0f, 1500.0f, 6f, 321);
        //(vendas > 10000) ? salarioBase + premio + vendas * (comissao / 100) : salarioBase + vendas * (comissao / 100);
        float expResult = (instance.getVendas() > 10000) ? instance.getSalarioBase() + instance.getPremio() + instance.getVendas() * (instance.getComissao() / 100) : instance.getSalarioBase() + instance.getVendas() * (instance.getComissao() / 100);
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }

    @org.junit.Test
    public void testCalcularVencimentoPeca() {
        System.out.println("calcular Vencimento trabalhador Comissao");
        TrabalhadorPeca instance = new TrabalhadorPeca("Jorge Silva", 20, 30);
        //(numeroPecasTipo1 + numeroPecasTipo2 >= 1000) ? (numeroPecasTipo1 * pagamentoPecaTipo1 + numeroPecasTipo2 * pagamentoPecaTipo2)* premioTrabPeca1000 : numeroPecasTipo1 * pagamentoPecaTipo1 + numeroPecasTipo2 * pagamentoPecaTipo2;
        float expResult = (instance.getNumeroPecasTipo1() + instance.getNumeroPecasTipo1() >= 1000) ? (instance.getNumeroPecasTipo1() * TrabalhadorPeca.getPagamentoPecaTipo1() + instance.getNumeroPecasTipo2() * TrabalhadorPeca.getPagamentoPeca2())* TrabalhadorPeca.getPremioTrabPeca1000() : instance.getNumeroPecasTipo1() * TrabalhadorPeca.getPagamentoPecaTipo1() + instance.getNumeroPecasTipo2() * TrabalhadorPeca.getPagamentoPeca2();
        float result = instance.calcularVencimento();
        assertEquals(expResult, result, 0.0);
    }


}