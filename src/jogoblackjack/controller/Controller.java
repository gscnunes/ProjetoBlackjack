package jogoblackjack.controller;

import java.util.Scanner;
import jogoblackjack.model.Jogador;
import jogoblackjack.model.Partida;
import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;

public class Controller {

    Scanner scan = new Scanner(System.in);
    private Ilist jogadores;

    public Controller() {
        this.jogadores = new LinkedList();
    }

    //cadastrar jogadores
    //escolher jogadores para partida
    //adicionar as cartas à mão de carta
    //iniciar novo baralho???  
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
        Partida partida = new Partida(numDeJogadores, jogadores);
    }
}
