package jogoblackjack.model;

import jogoblackjack.util.*;

public class Partida {

    //private Scanner scan = new Scanner(System.in);
    private int numDeJogadores;
    private LinkedList jogadoresDaPartida;
    private Baralho baralho;
    private Pilha monteCartas;
    private Croupier croupier;
    //private Controller controller;
    //private boolean ganhou;
    //private Jogador user;
    private Iterator iterador;
    //private Carta carta, pegaCarta;
    

    public Partida(int numDeJogadores) {
        this.croupier = new Croupier("Croupier", "123");
        this.numDeJogadores = numDeJogadores;
        this.baralho = new Baralho();
        this.monteCartas = baralho.embaralharEAddPilha();
        this.jogadoresDaPartida = new LinkedList();
        //ganhou = true;
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
