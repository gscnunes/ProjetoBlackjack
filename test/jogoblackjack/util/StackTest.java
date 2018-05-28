package jogoblackjack.util;

import jogoblackjack.model.Carta;
import jogoblackjack.util.IStack;
import jogoblackjack.util.Pilha;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    IStack pilha;
    Object carta1, carta2, carta3;

    @Before
    public void setUp() throws Exception {
        pilha = new Pilha();

        carta1 = new Carta("espadas", "2", 27);
        carta2 = new Carta("copas", "8", 20);
        carta3 = new Carta("ouros", "12", 50);
    }

    @Test
    public void testisEmpty() {
        assertTrue(pilha.isEmpty());
    }

    @Test
    public void testPushEPop() {
        pilha.push(carta1);
        pilha.push(carta2);
        pilha.push(carta3);
        assertFalse(pilha.isEmpty());

        assertSame(carta3, pilha.pop());
        assertFalse(pilha.isEmpty());

        assertSame(carta2, pilha.pop());
        assertFalse(pilha.isEmpty());

        assertSame(carta1, pilha.pop());
        assertTrue(pilha.isEmpty());
    }

    @Test
    public void testPeek() {
        pilha.push(carta1);
        pilha.push(carta2);
        pilha.push(carta3);
        assertFalse(pilha.isEmpty());

        assertSame(carta3, pilha.peek());
        assertFalse(pilha.isEmpty());

        pilha.pop();

        assertSame(carta2, pilha.peek());
        assertFalse(pilha.isEmpty());

        pilha.pop();

        assertSame(carta1, pilha.peek());
        assertFalse(pilha.isEmpty());

        pilha.pop();
        assertTrue(pilha.isEmpty());
    }
}
