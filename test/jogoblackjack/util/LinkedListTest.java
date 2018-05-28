package jogoblackjack.util;

import jogoblackjack.model.Jogador;
import jogoblackjack.util.Iterator;
import jogoblackjack.util.LinkedList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    LinkedList lista;
    Object jogador1, jogador2, jogador3;

    @Before
    public void setUp() throws Exception {
        lista = new LinkedList();
        jogador1 = new Jogador("CCarlos", "1234");
        jogador2 = new Jogador("BBruno", "1234");
        jogador3 = new Jogador("LLucas", "1234");
    }

    @Test
    public void testEstaVazia() {
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testTamanho() {
        assertEquals(0, lista.size());

        lista.addFirst(jogador1);
        assertEquals(1, lista.size());

        lista.addFirst(jogador2);
        lista.addFirst(jogador3);
        assertEquals(3, lista.size());

        lista.removeLast();
        assertEquals(2, lista.size());

        lista.removeFirst();
        lista.removeLast();
        assertEquals(0, lista.size());
    }

    @Test
    public void testAdicionaInicioRemoveInicio() {
        lista.addFirst(jogador1);
        lista.addFirst(jogador2);
        lista.addFirst(jogador3);
        assertFalse(lista.isEmpty());

        assertSame(jogador3, lista.removeFirst());
        assertFalse(lista.isEmpty());

        assertSame(jogador2, lista.removeFirst());
        assertFalse(lista.isEmpty());

        assertSame(jogador1, lista.removeFirst());
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testAdicionaInicioRemoveFinal() {
        lista.addFirst(jogador1);
        lista.addFirst(jogador2);
        lista.addFirst(jogador3);
        assertFalse(lista.isEmpty());

        assertSame(jogador1, lista.removeLast());
        assertFalse(lista.isEmpty());

        assertSame(jogador2, lista.removeLast());
        assertFalse(lista.isEmpty());

        assertSame(jogador3, lista.removeLast());
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testAdicionaFinalRemoveInicio() {
        lista.addLast(jogador1);
        lista.addLast(jogador2);
        lista.addLast(jogador3);
        assertFalse(lista.isEmpty());

        assertSame(jogador1, lista.removeFirst());
        assertFalse(lista.isEmpty());

        assertSame(jogador2, lista.removeFirst());
        assertFalse(lista.isEmpty());

        assertSame(jogador3, lista.removeFirst());
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testAdicionaFinalRemoveFinal() {
        lista.addLast(jogador1);
        lista.addLast(jogador2);
        lista.addLast(jogador3);
        assertFalse(lista.isEmpty());

        assertSame(jogador3, lista.removeLast());
        assertFalse(lista.isEmpty());

        assertSame(jogador2, lista.removeLast());
        assertFalse(lista.isEmpty());

        assertSame(jogador1, lista.removeLast());
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testIterador() {
        Iterator it = lista.iterator();
        assertFalse(it.hasNext());

        lista.addLast(jogador1);
        lista.addLast(jogador2);
        lista.addFirst(jogador3);
        it = lista.iterator();
        assertTrue(it.hasNext());
        assertSame(jogador3, it.next());
        assertTrue(it.hasNext());
        assertSame(jogador1, it.next());
        assertTrue(it.hasNext());
        assertSame(jogador2, it.next());
        assertFalse(it.hasNext());
    }
}
