/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exposicao;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ISEP-DEI-PPROG
 */
public class ExposicaoTest {

    private Exposicao expo1, expo2, expo3;
    private Quadro q1, q2, q3, q4, q5, q6, q7;
    private Object obj;

    public ExposicaoTest() {
        q1 = new Quadro("Ribeira", "Montes", 2000);
        q2 = new Quadro("Bíblia", "Abel", 1987);
        q3 = new Quadro("Ponte", "Veloso", 2012);
        q4 = new Quadro("Rua", "Lopes", 2007);
        q5 = new Quadro("Arvore", "Pereira", 2010);
        q6 = new Quadro("Estádio", "Luzia", 2012);
        q7 = new Quadro("Astros", "Nico", 2011);

        List<Quadro> listaQuadros1 = new ArrayList<>();
        listaQuadros1.add(q1);
        listaQuadros1.add(q2);
        listaQuadros1.add(q3);
        listaQuadros1.add(q4);
        listaQuadros1.add(q5);
        listaQuadros1.add(q6);
        listaQuadros1.add(q7);

        List<Quadro> listaQuadros2 = new ArrayList<>();
        listaQuadros2.add(q4);
        listaQuadros2.add(q5);

        expo1 = new Exposicao("Mix 1", 2014, listaQuadros1);
        expo2 = new Exposicao("Mix 2", 2017, listaQuadros2);
        expo3 = new Exposicao(expo1);

        obj = new Object();

    }

    /**
     * Test of adicionarQuadro method, of class Exposicao.
     */
    @Test
    public void testAdicionarQuadroTrue() {
        System.out.println("adicionarQuadroTrue");
        assertTrue(expo2.adicionarQuadro(q1));
    }

    @Test
    public void testAdicionarQuadroFalse() {
        System.out.println("adicionarQuadroFalse");
        assertFalse(expo2.adicionarQuadro(q4));
    }

    /**
     * Test of removerQuadro method, of class Exposicao.
     */
    @Test
    public void testRemoverQuadroTrue() {
        System.out.println("removerQuadroTrue");
        assertTrue(expo2.removerQuadro(q5));
    }

    @Test
    public void testRemoverQuadroFalse() {
        System.out.println("removerQuadroFalse");
        assertFalse(expo2.removerQuadro(q7));
    }

    /**
     * Test of equals method, of class Exposicao.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(expo1, expo1);
        assertEquals(expo2, expo2);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(expo1, expo3);
        assertEquals(expo3, expo1);
        // Testes de insucesso
        assertNotEquals(expo1, expo2);
        assertNotEquals(expo2, expo1);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(expo1, null);
        assertNotEquals(expo2, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(expo1, obj);
        assertNotEquals(expo2, obj);
        assertNotEquals(expo3, obj);
    }

    /**
     * Test of compareTo method, of class Exposicao.
     */
    @Test
    public void testCompareToZero() {
        System.out.println("compareToZero");
        int expResult = 0;
        int result = expo1.compareTo(expo3);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareToPos() {
        System.out.println("compareToPos");
        int expResult = 3;
        int result = expo2.compareTo(expo1);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareToNeg() {
        System.out.println("compareToNeg");
        int expResult = -3;
        int result = expo1.compareTo(expo2);
        assertEquals(expResult, result);
    }
}
