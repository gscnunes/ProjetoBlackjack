package jogoblackjack.model;

import jogoblackjack.util.*;

/**
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class Partida {

    private int numDeJogadores;
    private LinkedList jogadoresDaPartida;
    private Baralho baralho;
    private Pilha monteCartas;
    private Croupier croupier;

    /**
     * Construtor da classe Partida
     *
     * @param numDeJogadores - recebe o número de jogadores da partida
     */
    public Partida(int numDeJogadores) {
        this.croupier = new Croupier("Croupier", "123");
        this.numDeJogadores = numDeJogadores;
        this.baralho = new Baralho();
        this.monteCartas = baralho.embaralharEAddPilha();
        this.jogadoresDaPartida = new LinkedList();
    }

    /**
     *
     * @return numDeJogadores - número de jogadores da partida
     */
    public int getNumDeJogadores() {
        return numDeJogadores;
    }

    /**
     *
     * @return jogadoresDaPartida - lista com todos os jogadores da partida
     * atual
     */
    public LinkedList getJogadoresDaPartida() {
        return jogadoresDaPartida;
    }

    /**
     *
     * @return croupier - croupier utilizado na partida
     */
    public Croupier getCroupier() {
        return croupier;
    }

    /**
     *
     * @return monteCartas - pilha com as cartas embaralhas para a partida
     */
    public Pilha getMonteCartas() {
        return monteCartas;
    }

}
