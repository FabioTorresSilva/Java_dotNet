package org.upskill;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class ExposicaoTest {

    @org.junit.jupiter.api.Test
    void getDesignacao() {
        System.out.println("getDesignacao");
        List<Quadro> quadroList = new ArrayList<>();
        Quadro q1 = new Quadro("aaa", "Luis", 121);
        quadroList.add(q1);
        Exposicao instance = new Exposicao("bbb", 90, quadroList);
        String expResult = "bbb";
        String result = instance.getDesignacao();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void setDesignacao() {
        System.out.println("setDesignacao");

        List<Quadro> quadroList = new ArrayList<>();
        Quadro q1 = new Quadro("aaa", "Luis", 121);
        quadroList.add(q1);
        Exposicao instance = new Exposicao("bbb", 90, quadroList);

        instance.setDesignacao("ccc");
        String expResult = "ccc";
        String result = instance.getDesignacao();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void getQuadros() {
        System.out.println("getQuadros");

        List<Quadro> quadroList = new ArrayList<>();
        Quadro q1 = new Quadro("aaa", "Luis", 121);
        quadroList.add(q1);
        Exposicao instance = new Exposicao("bbb", 90, quadroList);

        List<Quadro> expResult = new ArrayList<>();
        expResult.add(q1);

        List<Quadro> result = instance.getQuadros();

        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void setQuadros() {
        System.out.println("setQuadros");

        List<Quadro> quadroList = new ArrayList<>();
        Quadro q1 = new Quadro("aaa", "Luis", 121);
        quadroList.add(q1);

        List<Quadro> quadroList1 = new ArrayList<>();
        Quadro q2 = new Quadro("bbb", "Luis", 121);
        quadroList1.add(q2);

        Exposicao instance = new Exposicao("Exposicao 1", 90, quadroList);

        instance.setQuadros(quadroList1);

        assertEquals(quadroList1, instance.getQuadros());
    }

    @org.junit.jupiter.api.Test
    void getAnoRealizacao() {
        System.out.println("getAnoRealizacao");
        List<Quadro> quadroList = new ArrayList<>();
        Quadro q1 = new Quadro("aaa", "Luis", 121);
        quadroList.add(q1);
        Exposicao instance = new Exposicao("bbb", 90, quadroList);
        int expResult = 90;
        int result = instance.getAnoRealizacao();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void setAnoRealizacao() {
        System.out.println("setAnoRealizacao");

        List<Quadro> quadroList = new ArrayList<>();
        Quadro q1 = new Quadro("aaa", "Luis", 121);
        quadroList.add(q1);
        Exposicao instance = new Exposicao("bbb", 90, quadroList);

        instance.setAnoRealizacao(91);
        int expResult = 91;
        int result = instance.getAnoRealizacao();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void addQuadro() {
        System.out.println("addQuadro");

        List<Quadro> quadroList = new ArrayList<>();
        Quadro q1 = new Quadro("aaa", "Luis", 121);
        Exposicao instance = new Exposicao("bbb", 90, quadroList);
        instance.addQuadro(q1);

        int expResult = 1;
        int result = quadroList.size();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void removerQuadro() {
        System.out.println("addQuadro");

        List<Quadro> quadroList = new ArrayList<>();
        Quadro q1 = new Quadro("aaa", "Luis", 121);
        Exposicao instance = new Exposicao("bbb", 90, quadroList);
        instance.addQuadro(q1);
        instance.removerQuadro(q1);

        int expResult = 0;
        int result = quadroList.size();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void compareTo() {
    }
}