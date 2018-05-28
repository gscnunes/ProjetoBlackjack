package jogoblackjack.model;

import jogoblackjack.util.Pilha;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaralhoTest {

    Pilha pilha;
    Baralho baralho;
    Object[] test;
    Object carta1, carta2;

    @Before
    public void setUp() throws Exception {
        pilha = new Pilha();
        baralho = new Baralho();
        test = baralho.addCartas();
        carta1 = new Carta("♦", "AS", 52);
        carta2 = new Carta("♦", "K", 49);
    }

    @Test
    public void criarBaralho() {
        assertEquals(52, test.length);
    }

    @Test
    public void pilhaOrdenada() {
        for (Object test1 : test) {
            pilha.push(test1);
        }
        assertFalse(pilha.isEmpty());

        assertSame(carta1, pilha.pop());
        pilha.pop();
        pilha.pop();
        assertSame(carta2, pilha.pop());
    }

    @Test
    public void pilhaEmbaralhada() {
        pilha = baralho.embaralharEAddPilha();
        assertNotEquals(carta1, pilha.pop());
    }
}
