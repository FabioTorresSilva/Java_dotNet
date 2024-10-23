package Escolas;

import static org.junit.Assert.*;

class ProfessorTest {

    @org.junit.jupiter.api.Test
    void determinarCusto_ProfAdjunto() {
        Professor instance = new ProfAdjunto("qwe", 10);
        double expResult = 1500 * 1.2;
        double result = instance.determinarCusto();
        assertEquals(expResult, result, 0.0);
    }

    @org.junit.jupiter.api.Test
    void determinarCusto_ProfAssistente() {
        Professor instance = new ProfAssistente("qwe", 10);
        double expResult = 1500;
        double result = instance.determinarCusto();
        assertEquals(expResult, result, 0.0);
    }

    @org.junit.jupiter.api.Test
    void determinarCusto_ProfCoordenador() {
        Professor instance = new ProfCoordenador("qwe", 10) ;
        double expResult = 1500 * 1.5;
        double result = instance.determinarCusto();
        assertEquals(expResult, result, 0.0);
    }
}

