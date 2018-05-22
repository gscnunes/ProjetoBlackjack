package jogoblackjack.controller;

import java.util.Scanner;
import jogoblackjack.model.Baralho;
import jogoblackjack.model.Jogador;
import jogoblackjack.model.Partida;
import jogoblackjack.util.IStack;
import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;
import jogoblackjack.util.Pilha;

public class Controller {

    Scanner scan = new Scanner(System.in);
    private Ilist jogadores;
    Baralho baralho;
    IStack cartas;
    Partida partida;

    public Controller() {
        this.jogadores = new LinkedList();
        this.cartas = new Pilha();

    }

    public void addJogador(Jogador jogador) {
        this.jogadores.addLast(jogador);
    }

    public void iniciarPartida() {
        int numDeJogadores;
        System.out.println("Digite a quantidade de jogadores:");
        numDeJogadores = Integer.parseInt(scan.nextLine());
        while (numDeJogadores > 5) {
            System.out.println("Número de jogadores acima do limite");
            numDeJogadores = Integer.parseInt(scan.nextLine());

        }
       partida.addJogadorNaPartida(numDeJogadores, jogadores);
       partida.pegarCarta();
    }

    public void criarBaralho() {
        cartas = baralho.embaralharEAddPilha(baralho.addCartas());
    }

    public Object darCartas() {
        return cartas.pop();
    }
}
