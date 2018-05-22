package jogoblackjack.model;

import java.util.Scanner;
import jogoblackjack.util.Ilist;
import jogoblackjack.util.Iterator;
import jogoblackjack.util.LinkedList;

public class Partida {

    Scanner scan = new Scanner(System.in);
    private int numDeJogadores;
    Ilist jogadores;
    Ilist jogadoresDaPartida;
    Baralho baralho;
    String jogador;

    public Partida(int numDeJogadores, Ilist jogadores) {
        this.numDeJogadores = numDeJogadores;
        this.jogadores = jogadores;
        baralho = new Baralho();
        this.jogadoresDaPartida = new LinkedList();
    }

    public int getNumDeJogadores() {
        return numDeJogadores;
    }

    public void setNumDeJogadores(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
    }

    void addJogadorNaPartida(int numDeJogadores) {
        for (int i = 0; i < numDeJogadores; i++) {
            System.out.println("Digite o user do Jogador:");
            jogador = scan.nextLine();
            Iterator iterador = jogadores.iterator();
            while (!iterador.hasNext()) {
                Jogador jog = (Jogador) iterador.next();
                if (jogador.equals(jog.getUser())) {
                    jogadoresDaPartida.addLast(jog);
                }
            }
        }
    }

    void pegarCarta() {
        int resposta, pontos = 0;
        Carta carta;
        Iterator iterador = jogadoresDaPartida.iterator();
        while (!iterador.hasNext()) {
            Jogador jogador = (Jogador) iterador.next();
            
            System.out.println("Cartas do jogador " + jogador.getUser());
            
            carta = (Carta) jogador.pegarCarta(croupier);
            pontos = pontos + Integer.parseInt(carta.getNumero());
            
            System.out.print(" " +carta.getNumero());
            System.out.print(" " +carta.getNaipe());
            
            carta = (Carta) jogador.pegarCarta(croupier);
            pontos = pontos + Integer.parseInt(carta.getNumero());
            
            System.out.print(" " +carta.getNumero());
            System.out.print(" " +carta.getNaipe());
            
            System.out.print("Jogador " + jogador.getUser());
            System.out.println("deseja pegar carta? [1] - SIM [2] - NÃO");
            resposta = Integer.parseInt(scan.nextLine());
            
            if (resposta == 1) {
                carta = (Carta) jogador.pegarCarta(croupier);
                pontos = pontos + Integer.parseInt(carta.getNumero());
                
                if(pontos == 21){
                    System.out.print("Jogador " + jogador.getUser());
                    System.out.println("venceu com " + pontos);
                }else if(pontos > 21){
                    System.out.print("Jogador " + jogador.getUser());
                    System.out.println("estorou com " + pontos);
                }
            }
            if(resposta == 2){
                if(pontos == 21){
                    System.out.print("Jogador " + jogador.getUser());
                    System.out.println("venceu com " + pontos);
                }else if(pontos > 21){
                    System.out.print("Jogador " + jogador.getUser());
                    System.out.println("estorou com " + pontos);
                }else{
                    System.out.print("Jogador " + jogador.getUser());
                    System.out.println("ficou com " + pontos);
                }
            }
        }

    }

}
