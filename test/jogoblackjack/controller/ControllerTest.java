package jogoblackjack.controller;

import jogoblackjack.model.Carta;
import jogoblackjack.model.Jogador;
import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControllerTest {

    Ilist lista;
    Controller controller;
    Jogador jogador1, jogador2;
    Carta carta1, carta2, carta3, carta4;

    @Before
    public void setUp() {
        controller = new Controller();
        lista = new LinkedList();
        jogador1 = new Jogador("BBruno", "123");
        jogador2 = new Jogador("CCarlos", "123");
        carta1 = new Carta("♥", "10", 22);
        carta2 = new Carta("♣", "10", 9);
        carta3 = new Carta("♦", "AS", 52);
        carta4 = new Carta("♣", "6", 5);
    }

    @Test
    public void testGetJogadores() {
        lista = controller.getJogadores();
        assertTrue(lista.isEmpty());

        controller.getJogadores().addLast(jogador1);
        assertFalse(lista.isEmpty());

        controller.getJogadores().addLast(jogador1);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testVerificar21() {
        lista.addLast(carta1);
        lista.addLast(carta2);
        lista.addLast(carta3);
        jogador1.setCartas(lista);
        assertTrue(controller.verificar21(jogador1));
    }

    @Test
    public void testGetGanhou() {
        assertTrue(controller.getGanhou());
    }

    @Test
    public void testVerificarEstourou() {
        jogador1.pegarCarta(carta1);
        jogador1.pegarCarta(carta2);
        jogador1.pegarCarta(carta3);
        jogador1.pegarCarta(carta4);
        assertTrue(controller.verificarEstourou(jogador1));

        jogador2.pegarCarta(carta2);
        jogador2.pegarCarta(carta3);
        jogador2.pegarCarta(carta4);
        assertFalse(controller.verificarEstourou(jogador2));
    }
}
