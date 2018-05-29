package jogoblackjack.model;

import jogoblackjack.util.LinkedList;
import jogoblackjack.util.Pilha;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PartidaTest {

    LinkedList lista;
    Partida partida;
    Croupier croupier;
    Pilha pilha;

    @Before
    public void setUp() throws Exception {
        partida = new Partida(3);
    }

    @Test
    public void testgetNumDeJogadores() {
        assertEquals(3, partida.getNumDeJogadores());
    }

    @Test
    public void testLista() {
        lista = partida.getJogadoresDaPartida();
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testCroupier() {
        croupier = partida.getCroupier();
        assertSame("Croupier", croupier.getUser());
        assertSame("123", croupier.getSenha());
    }

    @Test
    public void testMonteCartas() {
        pilha = partida.getMonteCartas();
        assertFalse(pilha.isEmpty());
    }
}
