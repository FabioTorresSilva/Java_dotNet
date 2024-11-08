package jogodecartas;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes unitários da classe Mão de Jogo.
 * 
 * @author ISEP-DEI-PPROG
 */
public class MaoDeJogoTest {
    
    private Carta c1, c2, c3, c4;
    private List<Carta> lista, listaDiferente;
    private MaoDeJogo maoDeJogo, maoDeJogoIgual, maoDeJogoDiferente;
    private Object objetoClasseDiferente;
    
    public MaoDeJogoTest() {
        c1 = new Carta(Carta.Tipo.AS, Carta.Naipe.Copas);
        c2 = new Carta(Carta.Tipo.AS, Carta.Naipe.Paus);
        c3 = new Carta(Carta.Tipo.DAMA, Carta.Naipe.Copas);
        c4 = new Carta(Carta.Tipo.REI, Carta.Naipe.Espadas);
        
        lista = new ArrayList<>();
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
        
        listaDiferente = new ArrayList<>();
        listaDiferente.add(new Carta(Carta.Tipo.VALETE, Carta.Naipe.Paus));
        listaDiferente.add(new Carta(Carta.Tipo.SENA, Carta.Naipe.Copas));
        listaDiferente.add(new Carta(Carta.Tipo.MANILHA, Carta.Naipe.Espadas));
        listaDiferente.add(new Carta(Carta.Tipo.OITO, Carta.Naipe.Espadas));
        listaDiferente.add(new Carta(Carta.Tipo.QUINA, Carta.Naipe.Paus));
        
        maoDeJogo = new MaoDeJogo(lista);
        maoDeJogoIgual = new MaoDeJogo(lista);
        maoDeJogoDiferente = new MaoDeJogo(listaDiferente);
        
        objetoClasseDiferente = new Object();
    }
    
    /**
     * Teste do método tiposDeCarta da classe MaoDeJogo.
     */
    @Test
    public void testTiposDeCarta() {
        System.out.println("tiposDeCarta");
        
        List<Carta.Tipo> listaResultado = new ArrayList<>();
        listaResultado.add(Carta.Tipo.AS);
        listaResultado.add(Carta.Tipo.DAMA);
        listaResultado.add(Carta.Tipo.REI);
        
        assertEquals(listaResultado, maoDeJogo.tiposDeCarta());
    }

    /**
     * Teste do método contarCartasDoTipo da classe MaoDeJogo.
     */
    @Test
    public void testContarCartasDoTipo() {
        System.out.println("contarCartasDoTipo");
        
        assertEquals(2, maoDeJogo.contarCartasDoTipo(Carta.Tipo.AS));
        assertEquals(1, maoDeJogo.contarCartasDoTipo(Carta.Tipo.DAMA));
        assertEquals(1, maoDeJogo.contarCartasDoTipo(Carta.Tipo.REI));
        assertEquals(0, maoDeJogo.contarCartasDoTipo(Carta.Tipo.OITO));
    }

    /**
     * Teste do método ordenar da classe MaoDeJogo.
     */
    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        
        List<Carta> listaResultadoOK = new ArrayList<>();
        listaResultadoOK.add(c3);
        listaResultadoOK.add(c1);
        listaResultadoOK.add(c4);
        listaResultadoOK.add(c2);

        List<Carta> listaResultadoKO = new ArrayList<>();
        listaResultadoKO.add(c1);
        listaResultadoKO.add(c2);
        listaResultadoKO.add(c4);
        listaResultadoKO.add(c3);
        
        maoDeJogo.ordenar();
        
        assertEquals(listaResultadoOK, maoDeJogo.getMaoDeJogo());
        assertNotEquals(listaResultadoKO, maoDeJogo.getMaoDeJogo());
    }
    
    /**
     * Testes do método equals da classe MaoDeJogo.
     */
    
    @Test
    public void testEqualsReflexivo() {
        System.out.println("equals reflexivo");
        
        assertEquals(maoDeJogo, maoDeJogo);
        assertEquals(maoDeJogoIgual, maoDeJogoIgual);
        assertEquals(maoDeJogoDiferente, maoDeJogoDiferente);
    }

    @Test
    public void testEqualsSimetrico() {
        System.out.println("equals simétrico");

        // Casos de teste de sucesso
        assertEquals(maoDeJogo, maoDeJogoIgual);
        assertEquals(maoDeJogoIgual, maoDeJogo);

        // Casos de teste de insucesso
        assertNotEquals(maoDeJogo, maoDeJogoDiferente);
        assertNotEquals(maoDeJogoDiferente, maoDeJogo);
    }

    @Test
    public void testEqualsConsistencia() {
        System.out.println("equals consistente");

        for (int i = 1; i < 1000; i++) {
            // Casos de teste de sucesso
            assertEquals(maoDeJogo, maoDeJogoIgual);
            assertEquals(maoDeJogoIgual, maoDeJogo);

            // Casos de teste de insucesso
            assertNotEquals(maoDeJogo, maoDeJogoDiferente);
            assertNotEquals(maoDeJogoDiferente, maoDeJogo);
        }
    }

    @Test
    public void testEqualsNull() {
        System.out.println("equals: nenhum objeto é null");
        
        assertNotEquals(maoDeJogo, null);
        assertNotEquals(maoDeJogoIgual, null);
        assertNotEquals(maoDeJogoDiferente, null);
        assertNotEquals(objetoClasseDiferente, null);
    }

    @Test
    public void testEqualsObjetosDeClassesDiferentes() {
        System.out.println("equals: um objeto não é igual a objeto de outra classe");
        
        assertNotEquals(maoDeJogo, objetoClasseDiferente);
        assertNotEquals(maoDeJogoIgual, objetoClasseDiferente);
        assertNotEquals(maoDeJogoDiferente, objetoClasseDiferente);
    }    
    
}
