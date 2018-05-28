package jogoblackjack.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CartaTest {

    Carta carta1, carta2, carta3;

    @Before
    public void setUp() throws Exception {
        carta1 = new Carta("♣", "2", 1);
        carta2 = new Carta("♥", "9", 21);
        carta3 = new Carta("♦", "7", 45);
    }

    @Test
    public void testNaipe() {
        assertEquals("♣", carta1.getNaipe());
        assertEquals("♥", carta2.getNaipe());
        assertEquals("♦", carta3.getNaipe());
    }

    @Test
    public void testNumero() {
        assertEquals("2", carta1.getNumero());
        assertEquals("9", carta2.getNumero());
        assertEquals("7", carta3.getNumero());
    }

    @Test
    public void testId() {
        assertEquals(1, carta1.getIdentificador());
        assertEquals(21, carta2.getIdentificador());
        assertEquals(45, carta3.getIdentificador());
    }
}
