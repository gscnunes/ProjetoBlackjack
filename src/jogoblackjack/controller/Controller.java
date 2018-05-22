package jogoblackjack.controller;

import jogoblackjack.model.Jogador;
import jogoblackjack.model.Partida;
import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;

public class Controller {

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
    
    public void iniciarPartida(){
        int numDeJogadores;
        System.out.println("Digite a quantidade de jogadores:");
        numDeJogadores = Integer.parseInt(scan.nextLine());
        new Partida(numDeJogadores,jogadores);
    }
}
