package org.dei.tributaveis2;

import static org.junit.Assert.*;

public class MoradiaTest {

    /**
     * Test of calcularImposto method, of class Moradia.
     */
    @org.junit.Test
    //  public void testCalcularImposto() {
    public void calcularImposto() {
        System.out.println("calcularImposto");
        Moradia instance = new Moradia("Rua do Bocage", 90, Moradia.CINZENTO);
        float expResult = 180;
        float result = instance.calcularImposto();
        assertEquals(expResult, result, 0.0);
    }
}