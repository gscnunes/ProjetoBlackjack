package jogoblackjack.model;

import java.util.Scanner;
import jogoblackjack.util.*;

public class Partida {

    private Scanner scan = new Scanner(System.in);
    private int numDeJogadores;
    private Ilist jogadoresDaPartida;
    private Baralho baralho;
    private Pilha monteCartas;
    private Croupier croupier;
    Jogador user;
    Iterator iterador;
    Carta carta;

    public Partida(int numDeJogadores) {
        this.croupier = new Croupier("Croupier", "123");
        this.numDeJogadores = numDeJogadores;
        this.baralho = new Baralho();
        this.monteCartas = baralho.embaralharEAddPilha();
        this.jogadoresDaPartida = new LinkedList();
    }

    public int getNumDeJogadores() {
        return numDeJogadores;
    }

    public void setNumDeJogadores(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
    }

    //adiciona um jogador na partida
    public void addJogadorNaPartida(Ilist jogadores) {
        if (jogadores.isEmpty()) { //caso não exista nenhum jogador registrado
            System.out.println("Cadatre um jogador");
            return;
        }
        for (int i = 0; i < numDeJogadores; i++) {
            System.out.println("Digite o user do Jogador:");
            String jogador = scan.nextLine();

            iterador = jogadores.iterator();
            while (iterador.hasNext()) {//verificar se o user digitado existe
                Jogador jog = (Jogador) iterador.next();

                if (jogador.equals(jog.getUser())) {
                    System.out.println("Digite a senha");
                    String senha = scan.nextLine();
                    if (senha.equals(jog.getSenha())) {
                        jogadoresDaPartida.addLast(jog); //adiciona em uma nova lista para ser utilizada depois
                    } else {
                        System.out.println("Senha incorreta");
                    }
                }
            }
        }
        cartasInicioDaPartida();
    }

    //melhorar isso
    public void pegarCarta() { //distribui e imprimir as cartas dos jogadores
        int resposta, resp = 0;
        boolean ganhou = true;
        do {
            iterador = jogadoresDaPartida.iterator();
            //meto1do pedir nova carta
            while (iterador.hasNext()) {
                user = (Jogador) iterador.next();

                System.out.print("Jogador " + user.getUser());
                System.out.println(" deseja pegar carta? [1] - SIM [2] - NÃO");//jogador quer mais cartas. pode colocar em um metodo
                resposta = scan.nextInt();

                if (resposta == 1) {
                    user.pegarCarta(darCarta());
                    mostrarMao(user);
                } else if (resposta == 2) {
                    resp++;
                }
            }
            if (resp == numDeJogadores) {
                ganhou = false;
            }
        } while (ganhou == true);
        limiteCroupier();
        cartasDoCroupier();
        verificarGanhou();
        iterador = jogadoresDaPartida.iterator();
        while (iterador.hasNext()) {
            user = (Jogador) iterador.next();
            user.setCartas(null);
            user.setMaodecarta(null);
        }
        croupier.setMaodecarta(null);
    }

    public void setLista(Ilist lista) {
        this.jogadoresDaPartida = lista;
    }

    public boolean verificarEstourou(Jogador user) {
        return user.cartasNaMao() > 21;
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
        carta = (Carta) croupier.pegarCartas(darCarta());

        System.out.println("");
        System.out.println(carta);
        croupier.pegarCarta(darCarta());
        System.out.println("**Carta desconhecida**");//segunda carta do croupier fica para baixo
        System.out.println("");
        System.out.println("");
    }

    public void limiteCroupier() {
        while (croupier.cartasNaMao() <= 17) {//croupier pega cartas ate tentar vencer ou ser maior ou igual a 17
            croupier.pegarCartas(darCarta());
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
            if (verificarEstourou(user)) {
                System.out.println("Jogador " + user.getUser());
                System.out.println(" estourou");
                user.setCartas(null);
                verificarQuemGanhou();
            } else if (user.cartasNaMao() == 21) {
                System.out.println("Jogador " + user.getUser());
                System.out.println(" fez 21");
                user.setJogosVencidos(user.getJogosVencidos() + 1);
            }         
            else {
                verificarQuemGanhou();
            }
        }
    }

    public void verificarQuemGanhou() {
        iterador = this.jogadoresDaPartida.iterator();
        Jogador jogadorMaior = (Jogador) iterador.next();

        while (iterador.hasNext()) {
            user = (Jogador) iterador.next();

            if (jogadorMaior.cartasNaMao() < user.cartasNaMao()) {
                jogadorMaior = user;
            }
        }
        if (rodarCroupier(jogadorMaior)) {
            return;
        }
        System.out.println("Jogador " + jogadorMaior + " ganhou!");

        jogadorMaior.setJogosVencidos(user.getJogosVencidos() + 1);
    }

    public boolean rodarCroupier(Jogador jogadorMaior) {
        if (verificarEstourou(croupier)) {
            croupier.setCartas(null);
            return false;
        } else if (croupier.cartasNaMao() > jogadorMaior.cartasNaMao()) {
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
            System.out.println("");
        }
        System.out.println("");
    }
}
