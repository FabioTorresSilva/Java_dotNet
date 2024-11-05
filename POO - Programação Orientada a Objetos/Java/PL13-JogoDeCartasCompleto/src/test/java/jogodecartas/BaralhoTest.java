package jogodecartas;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários da classe Baralho.
 *
 * @author ISEP-DEI-PPROG
 */
public class BaralhoTest {

    private Baralho baralho40, baralho40Igual;
    private Baralho baralho52, baralho52Igual;
    private Object objetoClasseDiferente;

    public BaralhoTest() {
        baralho40 = new Baralho(Baralho.Tipo.BAR_40);
        baralho40Igual = new Baralho(Baralho.Tipo.BAR_40);
        baralho52 = new Baralho(Baralho.Tipo.BAR_52);
        baralho52Igual = new Baralho(Baralho.Tipo.BAR_52);

        objetoClasseDiferente = new Object();
    }

    /**
     * Testes do método equals da classe Baralho.
     */
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");

        assertEquals(baralho40, baralho40);
        assertEquals(baralho40Igual, baralho40Igual);

        assertEquals(baralho52, baralho52);
        assertEquals(baralho52Igual, baralho52Igual);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");

        // Casos de teste de sucesso
        assertEquals(baralho40, baralho40Igual);
        assertEquals(baralho40Igual, baralho40);
        
        baralho40Igual.baralhar();
        assertEquals(baralho40, baralho40Igual);
        assertEquals(baralho40Igual, baralho40);

        // Casos de teste de insucesso
        assertNotEquals(baralho40, baralho52);
        assertNotEquals(baralho52, baralho40);
    }

    @Test
    public void testEqualsConsistencia() {
        System.out.println("equals consistente");

        for (int i = 1; i < 1000; i++) {
            // Casos de teste de sucesso
            assertEquals(baralho40, baralho40Igual);
            assertEquals(baralho40Igual, baralho40);
            
            // Casos de teste de insucesso
            assertNotEquals(baralho40, baralho52);
            assertNotEquals(baralho52, baralho40);
        }
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");

        assertNotEquals(baralho40, null);
        assertNotEquals(baralho40Igual, null);
        assertNotEquals(baralho52, null);
        assertNotEquals(baralho52Igual, null);
        assertNotEquals(objetoClasseDiferente, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: um objeto não é igual a objeto de outra classe");

        assertNotEquals(baralho40, objetoClasseDiferente);
        assertNotEquals(baralho40Igual, objetoClasseDiferente);
        assertNotEquals(baralho52, objetoClasseDiferente);
        assertNotEquals(baralho52Igual, objetoClasseDiferente);
    }

}
