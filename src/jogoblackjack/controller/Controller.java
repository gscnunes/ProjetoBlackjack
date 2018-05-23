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

    private Scanner scan = new Scanner(System.in);
    private Ilist jogadores;
    private Baralho baralho;
    private IStack cartas;
    private Partida partida;

    public Controller() {
        this.jogadores = new LinkedList();
        this.cartas = new Pilha();

    }

    //adiciona jogador na lista encadeada
    public void addJogador(Jogador jogador) {
        this.jogadores.addLast(jogador);
    }

    //inicia uma partida fazendo o usuario escolher a quantidade de jogadores
    public void iniciarPartida() {
        int numDeJogadores;
        System.out.println("Digite a quantidade de jogadores:");
        numDeJogadores = Integer.parseInt(scan.nextLine());
        while (numDeJogadores > 5) {
            System.out.println("Número de jogadores acima do limite");
            numDeJogadores = Integer.parseInt(scan.nextLine());
        }
       partida.addJogadorNaPartida(numDeJogadores, jogadores);//chama metodo para adicionar jogador na partida
       partida.pegarCarta();
    }

    //cria um baralho, embaralha e coloca dentro de uma variavel
    public void criarBaralho() {
        cartas = baralho.embaralharEAddPilha(baralho.addCartas());
    }

    //metodo para distribuir as cartas
    public Object darCartas() {
        return cartas.pop();
    }
}
