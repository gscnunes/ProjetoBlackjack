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
        int resposta;
        Iterator iterador = jogadoresDaPartida.iterator();
        while (!iterador.hasNext()) {
            Jogador jogador = (Jogador) iterador.next();
            System.out.print("Jogador " + jogador.getUser());
            System.out.println("deseja pegar carta? [1] - SIM [2] - NÃO");
            resposta = Integer.parseInt(scan.nextLine());

            if (resposta == 1) {
                jogador.pegarCarta(croupier);
            }
        }

    }

}
