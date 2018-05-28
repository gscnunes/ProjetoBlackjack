package jogoblackjack.model;

import jogoblackjack.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaoDeCartaTest {

    LinkedList lista;
    Carta carta1, carta2, carta3, carta4, carta5;
    MaoDeCarta maodecarta;

    @Before
    public void setUp() throws Exception {
        lista = new LinkedList();
        carta1 = new Carta("♣", "2", 1);
        carta2 = new Carta("♥", "9", 21);
        carta3 = new Carta("♦", "7", 45);
        carta4 = new Carta("♠", "AS", 39);
        carta5 = new Carta("♦", "K", 49);
        maodecarta = new MaoDeCarta();
    }

    @Test
    public void pontos() {
        lista.addLast(carta1);
        lista.addLast(carta2);
        lista.addLast(carta3);

        assertEquals(18, maodecarta.CartasNaMao(lista));

        lista.removeFirst();
        assertEquals(16, maodecarta.CartasNaMao(lista));

        lista.removeFirst();
        assertEquals(7, maodecarta.CartasNaMao(lista));
    }

    @Test
    public void valorDoAs() {
        lista.addLast(carta5);
        lista.addFirst(carta4);

        assertEquals(11, maodecarta.valorAs(lista));

        lista.addLast(carta1);
        assertEquals(1, maodecarta.valorAs(lista));
    }
}
