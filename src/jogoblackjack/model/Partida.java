package jogoblackjack.model;

import java.util.Scanner;
import jogoblackjack.controller.Controller;

import jogoblackjack.util.*;

public class Partida {

    private Scanner scan = new Scanner(System.in);
    private int numDeJogadores;
    private Ilist jogadoresDaPartida;
    private Baralho baralho;
    private Pilha monteCartas;
    private Croupier croupier;
    private Controller controller;
    private boolean ganhou;
    private Jogador user;
    private Iterator iterador;
    private Carta carta, pegaCarta;

    public Partida(int numDeJogadores) {
        this.croupier = new Croupier("Croupier", "123");
        this.numDeJogadores = numDeJogadores;
        this.baralho = new Baralho();
        this.monteCartas = baralho.embaralharEAddPilha();
        this.jogadoresDaPartida = new LinkedList();
        ganhou = true;
    }

    public int getNumDeJogadores() {
        return numDeJogadores;
    }

    public void setNumDeJogadores(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
    }

    //adiciona um jogador na partida
    public void addJogadorNaPartida(Ilist jogadores) { //MUDEI BASTANTE ESSE MÉTODO, PRA QUE TRATASSE OS ERROS DIREITINHO

        String user, senha;
        iterador = jogadores.iterator();
        Jogador jogador;
        boolean contains = false;

        for (int i = 0; i < numDeJogadores; i++) {

            int indice = i + 1;

            System.out.println("\nDigite o User do jogador " + indice + ":");
            user = scan.nextLine();

            while (contains == false) {
                while (iterador.hasNext()) {
                    jogador = (Jogador) iterador.next();
                    if (user.equals(jogador.getUser())) {
                        contains = true;

                        System.out.println("\nDigite a senha: ");
                        senha = scan.nextLine();
                        while (!senha.equals(jogador.getSenha())) {
                            System.out.println("\nSenha incorreta, digite novamente!");
                            senha = scan.nextLine();
                        }
                        jogadoresDaPartida.addLast(jogador);
                        break;
                    }
                }
                if (!contains) {
                    System.out.println("\nJogador não encontrado, digite novamente!");
                    user = scan.nextLine();
                    iterador = jogadores.iterator();

                }
            }
            contains = false;
        }
        cartasInicioDaPartida();
    }

    //melhorar isso
    public void pegarCarta() { //TAMBÉM ARRUMEI ESSE, TÁ PEGANDO AS CARTAS DIREITINHO
        int resposta, naoPegar = 0;
        do {
            iterador = jogadoresDaPartida.iterator();
            //meto1do pedir nova carta
            while (iterador.hasNext()) {
                user = (Jogador) iterador.next();

                System.out.print("\nJogador " + user.getUser());
                System.out.println(" deseja pegar carta? [1] - SIM [2] - NÃO");//jogador quer mais cartas. pode colocar em um metodo
                resposta = scan.nextInt();

                while (resposta == 1) {
                    user.pegarCarta(darCarta());
                    mostrarMao(user);
                    if (verificarEstourou(user)) {
                        System.out.println("\nJogador " + user.getUser() + " estourou!");
                        break;
                    }
                    System.out.print("\nJogador " + user.getUser());
                    System.out.println(" deseja pegar carta? [1] - SIM [2] - NÃO");//jogador quer mais cartas. pode colocar em um metodo
                    resposta = scan.nextInt();
                }
                naoPegar++;
            }
            if (naoPegar == numDeJogadores) {
                ganhou = false;
            }
        } while (getGanhou());

        limiteCroupier();
        cartasDoCroupier();
        verificarGanhou();
        iterador = jogadoresDaPartida.iterator();
        while (iterador.hasNext()) { //ESSA PARTE SERVE PRA ZERAR AS MÃOS DOS JOGADORES E A LISTA DOS JOGADORES DA PARTIDA

            LinkedList novasCartas = new LinkedList();
            MaoDeCarta novaMao = new MaoDeCarta();

            user = (Jogador) iterador.next();
            user.setCartas(novasCartas);
            user.setMaodecarta(novaMao);
        }
        LinkedList novaLista = new LinkedList();
        jogadoresDaPartida = novaLista;
    }

    public boolean verificarEstourou(Jogador user) {
        return user.cartasNaMao() <= 21;
    }

    //metodo para pegar novas cartas
    public Carta darCarta() {
        return (Carta) monteCartas.pop();
    }

    public void cartasInicioDaPartida() {
        iterador = jogadoresDaPartida.iterator();

        while (iterador.hasNext()) { //percorrendo a lista dos jogadores da partida 
            user = (Jogador) iterador.next(); //salvando o jogador atual

            user.pegarCarta(darCarta());
            user.pegarCarta(darCarta());
            mostrarMao(user);
        }
        System.out.println("Cartas do Croupier");
        carta = (Carta) croupier.pegarCarta(darCarta());

        System.out.println("");
        System.out.println(carta);
        croupier.pegarCarta(darCarta());
        System.out.println("**Carta desconhecida**");//segunda carta do croupier fica para baixo
        System.out.println("");
        System.out.println("");
    }

    public void limiteCroupier() {
        while (croupier.cartasNaMao() <= 17) {//croupier pega cartas ate tentar vencer ou ser maior ou igual a 17
            pegaCarta = darCarta();
            croupier.pegarCarta(pegaCarta);
        }
    }

    public void cartasDoCroupier() {
        iterador = croupier.getCartas().iterator();
        System.out.println("Cartas do croupier");

        System.out.println("");
        while (iterador.hasNext()) { //imprime todas as cartas do croupier
            carta = (Carta) iterador.next();
            System.out.println(carta);
        }
        System.out.println("");
        System.out.println("");
    }

    public void verificarGanhou() {
        iterador = jogadoresDaPartida.iterator();

        while (iterador.hasNext()) {
            user = (Jogador) iterador.next();

            if (user.cartasNaMao() == 21) {
                System.out.println("\nJogador " + user.getUser() + " fez 21!");
                user.setJogosVencidos(user.getJogosVencidos() + 1);
                user.setPontTotal(user.getPontTotal() + 10);

            } else {
                verificarQuemGanhou();
            }
        }
    }

    public void verificarQuemGanhou() {
        iterador = this.jogadoresDaPartida.iterator();
        Jogador jogadorMaior = (Jogador) iterador.next();

        while (iterador.hasNext()) {
            user = (Jogador) iterador.next();

            if (user.cartasNaMao() == jogadorMaior.cartasNaMao()) {
                System.out.println("" + user + " e " + jogadorMaior + " empataram");
                return;
            }
            if (user.cartasNaMao() > jogadorMaior.cartasNaMao()) {
                if (verificarEstourou(user)) {
                    jogadorMaior = user;
                }
            }
        }
        if (rodarCroupier(jogadorMaior)) {
            return;
        }
        System.out.println("Jogador " + jogadorMaior + " ganhou!");

        jogadorMaior.setJogosVencidos(user.getJogosVencidos() + 1);
        jogadorMaior.setPontTotal(jogadorMaior.getPontTotal() + 10);

    }

    public boolean rodarCroupier(Jogador jogadorMaior) {
        if (croupier.cartasNaMao() > jogadorMaior.cartasNaMao()) {
            if (!verificarEstourou(croupier)) {
                System.out.println("Croupier estourou");
                return false;
            }
            System.out.println("Croupier ganhou");
            return true;
        }
        return false;
    }

    public void mostrarMao(Jogador jogador) { //criei um método pra mostrar as cartas da mão

        Iterator cursor = jogador.getCartas().iterator();

        System.out.println("Cartas do user: " + jogador);
        System.out.println("");

        while (cursor.hasNext()) {
            carta = (Carta) cursor.next();
            System.out.println(carta);
        }
        System.out.println("");
    }

    public boolean getGanhou() {
        return ganhou;
    }
}
