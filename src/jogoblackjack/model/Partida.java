package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;

public class Partida {

    private int numDeJogadores;
    Ilist jogadores;
    Baralho baralho;

    public Partida(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
        this.jogadores = new LinkedList();
    }

    public int getNumDeJogadores() {
        return numDeJogadores;
    }

    public void setNumDeJogadores(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
    }

    void addNewJogador(String User, String senha) {
        for (int i = 0; i < numDeJogadores; i++) {
            jogadores.addLast(new Jogador(User, senha));
        }
    }
}
