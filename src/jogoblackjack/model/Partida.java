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
    Jogador user;
    Iterator iterador;
    Carta carta, pegaCarta;

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
        int resposta;

        iterador = jogadoresDaPartida.iterator();
        //metodo pedir nova carta
        while (iterador.hasNext()) {
            user = (Jogador) iterador.next();

            System.out.print("Jogador " + user.getUser());
            System.out.println(" deseja pegar carta? [1] - SIM [2] - NÃO");//jogador quer mais cartas. pode colocar em um metodo
            resposta = scan.nextInt();

            if (resposta == 1) {
                user.pegarCarta(darCarta());
                mostrarMao(user);
                verificarGanhou(user);
            }            
            

        }
        cartasDoCroupier();
        verificarQuemGanhou();
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

    public void verificarGanhou(Jogador user) {
        if (user.cartasNaMao() > 21) {
            System.out.println("Jogador " + user.getUser());
            System.out.println(" estourou");
        } else if (user.cartasNaMao() == 21) {
            System.out.println("Jogador " + user.getUser());
            System.out.println(" fez 21");
            limiteCroupier();
        }
    }

    public void verificarQuemGanhou(){
        iterador = this.jogadoresDaPartida.iterator();
        while(iterador.hasNext()){
            user = (Jogador) iterador.next();
            //alguma coisa para comparar os pontos de um com outro e depois com o do croupier
            
            
            user.setJogosVencidos(user.getJogosVencidos() + 1);
        }            
    
    
    }
    
    public void mostrarMao(Jogador jogador){ //criei um método pra mostrar as cartas da mão
        
        Iterator cursor = jogador.getCartas().iterator();
        
        Carta carta;
        
        System.out.println("Cartas do user: " + jogador);
        System.out.println("");
        
        while(cursor.hasNext()){
            carta = (Carta)cursor.next();
            System.out.println(carta);
            System.out.println("");
        }
        System.out.println(""); 
    }

}
