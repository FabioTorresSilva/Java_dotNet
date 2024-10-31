/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exposicao;

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
public class QuadroTest {

    private Quadro  q1 = new Quadro("Quadro1", "Autor1", 2001);
    private Quadro q2 = new Quadro("Quadro2", "Autor4", 2002);
    private Quadro q3 = new Quadro("Quadro3", "Autor3", 2003);
    private Quadro q1a = new Quadro("Quadro1", "Autor1", 2001);
    private Object obj = new Object();

    /**
     * Test of equals method, of class Quadro.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        assertEquals(q1, q1);
        assertEquals(q2, q2);
        assertEquals(q3, q3);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");
        // Testes de sucesso
        assertEquals(q1, q1a);
        assertEquals(q1a, q1);
        // Testes de insucesso
        assertNotEquals(q1, q2);
        assertNotEquals(q2, q1);
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        assertNotEquals(q1, null);
        assertNotEquals(q2, null);
        assertNotEquals(q3, null);
        assertNotEquals(obj, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: objetos de classes diferentes");
        assertNotEquals(q1, obj);
        assertNotEquals(q2, obj);
        assertNotEquals(q3, obj);
    }

    /**
     * Test of compareTo method, of class Quadro.
     */
    @Test
    public void testCompareToZero() {
        System.out.println("compareToZero");
        int expResult = 0;
        int result = q1.compareTo(q1a);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareToPos() {
        System.out.println("compareToPos");
        int expResult = 1;
        int result = q2.compareTo(q1);
        assertEquals(expResult, result);
    }

    @Test
    public void testCompareToNeg() {
        System.out.println("compareToNeg");
        int expResult = -2;
        int result = q1.compareTo(q3);
        assertEquals(expResult, result);
    }
}