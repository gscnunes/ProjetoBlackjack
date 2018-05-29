package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CroupierTest {

    Croupier croupier;
    Ilist lista;
    Carta carta1, carta2;

    @Before
    public void setUp() throws Exception {
        lista = new LinkedList();
        croupier = new Croupier("Croupier", "123");
        carta1 = new Carta("♣", "2", 1);
        carta2 = new Carta("♦", "7", 45);
    }

    @Test
    public void testPegarCarta() {
        assertSame(carta1, croupier.pegarCarta(carta1));
        assertSame(carta2, croupier.pegarCarta(carta2));
    }

    @Test
    public void testCartasNaMao() {
        croupier.pegarCarta(carta1);
        croupier.pegarCarta(carta2);

        assertEquals(9, croupier.cartasNaMao());
    }

    @Test
    public void testGetCartas() {
        croupier.pegarCarta(carta1);
        croupier.pegarCarta(carta2);

        lista = croupier.getCartas();

        assertSame(carta1, lista.removeFirst());
        assertSame(carta2, lista.removeLast());

        assertTrue(lista.isEmpty());
    }
}
