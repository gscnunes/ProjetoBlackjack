package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JogadorTest {

    Ilist lista;
    Jogador jogador1, jogador2;
    Carta carta1, carta2;

    @Before
    public void setUp() throws Exception {
        lista = new LinkedList();
        jogador1 = new Jogador("CCarlos", "1234");
        jogador2 = new Jogador("BBruno", "1234");
        carta1 = new Carta("♣", "2", 1);
        carta2 = new Carta("♦", "7", 45);
    }

    @Test
    public void testPegarCarta() {
        assertSame(carta1, jogador1.pegarCarta(carta1));
        assertSame(carta2, jogador2.pegarCarta(carta2));
    }

    @Test
    public void testCartasNaMao() {
        jogador1.pegarCarta(carta1);
        jogador1.pegarCarta(carta2);

        assertEquals(9, jogador1.cartasNaMao());
    }

    public void testGetCartas() {
        jogador1.pegarCarta(carta1);
        jogador1.pegarCarta(carta2);

        lista = jogador1.getCartas();

        assertSame(carta1, lista.removeFirst());
        assertSame(carta2, lista.removeLast());

        assertTrue(lista.isEmpty());
    }
}
