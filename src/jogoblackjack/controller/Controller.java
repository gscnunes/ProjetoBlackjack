package jogoblackjack.controller;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import jogoblackjack.model.*;
import jogoblackjack.util.*;


public class Controller {

    private Scanner scan;
    private Ilist jogadores;
    private Partida partida;
    private ControllerArquivo controllerArquivo;

    public Controller() {
        scan = new Scanner(System.in);
        controllerArquivo = new ControllerArquivo();        
        jogadores = controllerArquivo.reader();
        
    }

    //adiciona jogador na lista encadeada
    public void addJogador(Jogador jogador) {
        controllerArquivo.writer(jogador); 
        jogadores.addLast(jogador);
    }

    //inicia uma partida fazendo o usuario escolher a quantidade de jogadores
    public void iniciarPartida() {   
        
        if (jogadores.isEmpty()) {
            System.out.println("Não há jogadores cadastrados!");
        } 
        else {

            int numDeJogadores;
            System.out.println("Digite a quantidade de jogadores [1-5]: ");            
            
            numDeJogadores = scan.nextInt();            
            
            while (numDeJogadores > jogadores.size() || numDeJogadores > 5) {
                System.out.println("Número de jogadores fora do limite, digite novamente: ");
                numDeJogadores = scan.nextInt();
            }
            partida = new Partida(numDeJogadores);
            partida.addJogadorNaPartida(jogadores);
            partida.pegarCarta();

        }

    }
    
    public void placar(){
        LinkedList jogadores = controllerArquivo.reader();
        
        
        
    }

    public Ilist getJogadores() {
        return jogadores;
    }
    
    
 
}
