package jogoblackjack.model;

import jogoblackjack.util.*;

public class Partida {

    private int numDeJogadores;
    private LinkedList jogadoresDaPartida;
    private Baralho baralho;
    private Pilha monteCartas;
    private Croupier croupier;  

    public Partida(int numDeJogadores) {
        this.croupier = new Croupier("Croupier", "123");
        this.numDeJogadores = numDeJogadores;
        this.baralho = new Baralho();
        this.monteCartas = baralho.embaralharEAddPilha();
        this.jogadoresDaPartida = new LinkedList();
    }

    public int getNumDeJogadores() {
        return numDeJogadores;
    }    

    public LinkedList getJogadoresDaPartida() {
        return jogadoresDaPartida;
    }
    
    public Croupier getCroupier() {
        return croupier;
    }

    public Pilha getMonteCartas() {
        return monteCartas;
    }
   
}
