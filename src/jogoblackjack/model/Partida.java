package jogoblackjack.model;

import java.util.Scanner;
import jogoblackjack.controller.Controller;
import jogoblackjack.util.Ilist;
import jogoblackjack.util.Iterator;
import jogoblackjack.util.LinkedList;

public class Partida {

    Scanner scan = new Scanner(System.in);
    private int numDeJogadores;
    Ilist jogadoresDaPartida;
    Baralho baralho;
    String jogador;
    Controller controller;

    public Partida(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
        baralho = new Baralho();
        this.jogadoresDaPartida = new LinkedList();
    }

    public int getNumDeJogadores() {
        return numDeJogadores;
    }

    public void setNumDeJogadores(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
    }

    public void addJogadorNaPartida(int numDeJogadores, Ilist jogadores) {
        if (jogadores.size() == 0) {
            System.out.println("Casdatre um jogador");
            return;
        }
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

    //melhorar isso
    //falta cartas do couprier
    public void pegarCarta() {
        int resposta, pontos = 0;
        Carta carta, pegarCarta;
        Iterator iterador = jogadoresDaPartida.iterator();
        while (!iterador.hasNext()) {
            Jogador jogado = (Jogador) iterador.next();

            System.out.println("Cartas do jogador " + jogado.getUser());

            pegarCarta = (Carta) controller.darCartas();

            carta = (Carta) jogado.pegarCarta(pegarCarta);
            pontos
                    = System.out.print(" " + carta.getNumero());
            System.out.println(" " + carta.getNaipe());

            pegarCarta = (Carta) controller.darCartas();

            carta = (Carta) jogado.pegarCarta(pegarCarta);
            pontos = pontos + Integer.parseInt(carta.getNumero());

            System.out.print(" " + carta.getNumero());
            System.out.println(" " + carta.getNaipe());

            //cartas do croupier
            System.out.print("Jogador " + jogado.getUser());
            System.out.println("deseja pegar carta? [1] - SIM [2] - NÃO");
            resposta = Integer.parseInt(scan.nextLine());

            if (resposta == 1) {
                pegarCarta = (Carta) controller.darCartas();

                carta = (Carta) jogado.pegarCarta(pegarCarta);
                pontos = pontos + Integer.parseInt(carta.getNumero());

                if (pontos == 21) {
                    System.out.print("Jogador " + jogado.getUser());
                    System.out.println("venceu com " + pontos);
                } else if (pontos > 21) {
                    System.out.print("Jogador " + jogado.getUser());
                    System.out.println("estorou com " + pontos);
                }
            }
            if (resposta == 2) {
                if (pontos == 21) {
                    System.out.print("Jogador " + jogado.getUser());
                    System.out.println("venceu com " + pontos);
                } else if (pontos > 21) {
                    System.out.print("Jogador " + jogado.getUser());
                    System.out.println("estorou com " + pontos);
                } else {
                    System.out.print("Jogador " + jogado.getUser());
                    System.out.println("ficou com " + pontos);
                }
            }
        }

    }

}
