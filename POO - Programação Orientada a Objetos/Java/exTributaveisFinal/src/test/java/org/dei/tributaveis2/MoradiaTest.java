package org.dei.tributaveis2;

import static org.junit.Assert.*;

public class MoradiaTest {

    /**
     * Teste do método calcularImposto da classe Moradia.
     */
    @org.junit.Test
      public void testCalcularImposto() {
        System.out.println("calcularImposto");
        Moradia instance = new Moradia("Rua do Bocage", 90, Moradia.CINZENTO);
        float expResult = 180;
        float result = instance.calcularImposto();
        assertEquals(expResult, result, 0.0);
    }
}