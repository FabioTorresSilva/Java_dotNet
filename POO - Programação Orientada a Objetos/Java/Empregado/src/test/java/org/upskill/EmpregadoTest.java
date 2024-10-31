package org.upskill;

import org.upskill.utils.Data;
import org.upskill.utils.Tempo;

import static org.junit.jupiter.api.Assertions.*;

class EmpregadoTest {

    private final Empregado instance = new Empregado("Manuel", "Silva", new Data(2020,1,1),new Tempo(9, 0),new Tempo(17, 0));

    @org.junit.jupiter.api.Test
    void testEquals() {
        assertNotEquals(null, instance, "should not be equal to null");

        assertEquals(instance, instance, "should be equal to itself");

        Empregado another = new Empregado();
        assertNotEquals(instance, another, "instance should not be equal to other");

        Empregado other = new Empregado("Manuel", "Silva", new Data(2020,1,1),new Tempo(9, 0),new Tempo(17, 0));
        assertEquals(instance, other, "instance should be equal to other");
    }

    @org.junit.jupiter.api.Test
    void calcularHorasTrabalhoSemanal() {
        float expResult = 40f;
        double result = instance.calcularHorasTrabalhoSemanal();
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void tempoContratado() {
    }
}