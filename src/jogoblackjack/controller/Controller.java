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

    private Scanner scan;
    private Ilist jogadores;
    private Baralho baralho;
    private IStack cartas;
    private Partida partida;

    public Controller() {
        this.jogadores = new LinkedList();
        this.cartas = new Pilha();
        scan = new Scanner (System.in); //MUDEI AQUI
        
    }

    //adiciona jogador na lista encadeada
    public void addJogador(Jogador jogador) {
        this.jogadores.addLast(jogador);
    }

    //inicia uma partida fazendo o usuario escolher a quantidade de jogadores
    public void iniciarPartida() {
        
        
        if(jogadores.isEmpty()){
            System.out.println("Não há jogadores cadastrados!");
            return;
        }
        else{
            int numDeJogadores;
            System.out.println("Digite a quantidade de jogadores: ");
            numDeJogadores = scan.nextInt();
            while (numDeJogadores > 5) {
                System.out.println("Número de jogadores acima do limite, digite novamente: ");
                numDeJogadores = scan.nextInt();
            }
            partida = new Partida(numDeJogadores);//chama metodo para adicionar jogador na partida
            partida.addJogadorNaPartida(jogadores);
            partida.pegarCarta();            
        }
    }
        
        
       
    

//    //cria um baralho, embaralha e coloca dentro de uma variavel
//    public void criarBaralho() {
//        cartas = baralho.embaralharEAddPilha();
//    }

    //metodo para distribuir as cartas
    public Object darCartas() {
        return partida.darCarta();
    }
    
    
}
