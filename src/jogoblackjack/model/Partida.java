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
    private String jogador;
    private Controller controller;

    public Partida(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
        monteCartas = new Pilha();
        baralho = new Baralho();
        monteCartas = baralho.embaralharEAddPilha();
        this.jogadoresDaPartida = new LinkedList();
    }

    public int getNumDeJogadores() {
        return numDeJogadores;
    }

    public void setNumDeJogadores(int numDeJogadores) {
        this.numDeJogadores = numDeJogadores;
    }

    //adiciona um jogador na partida
    //pode colocar para verificar com senha
    public void addJogadorNaPartida(Ilist jogadores) {
        if (jogadores.size() == 0) { //caso não exista nenhum jogador registrado
            System.out.println("Cadatre um jogador");
            return;
        }
        for (int i = 0; i < numDeJogadores; i++) {
            System.out.println("Digite o user do Jogador:");
            jogador = scan.nextLine();

            Iterator iterador = jogadores.iterator();

            while (!iterador.hasNext()) {//verificar se o user digitado existe
                Jogador jog = (Jogador) iterador.next();

                if (jogador.equals(jog.getUser())) {
                    jogadoresDaPartida.addLast(jog); //adiciona em uma nova lista para ser utilizada depois
                }
            }
        }
    }

    //melhorar isso
    //falta cartas do couprier
    public void pegarCarta() { //distribui e imprimir as cartas dos jogadores
        int resposta, pontos = 0;
        Jogador user;
        Carta carta, pegaCarta;
        Iterator iterador;
        iterador = jogadoresDaPartida.iterator();   
        
        //MÉTODO P/ INÍCIO DA PARTIDA

        while (!iterador.hasNext()) { //percorrendo a lista dos jogadores da partida 
            user = (Jogador) iterador.next(); //salvando o jogador atual

            System.out.println("Cartas do jogador " + user.getUser());

            pegaCarta = (Carta) controller.darCartas();//pegando a primeira carta

            carta = (Carta) user.pegarCarta(pegaCarta);//salvando a primeira carta dentro do jogador

            System.out.print("" + carta.getNumero());
            System.out.println("" + carta.getNaipe());//imprimindo a carta

            pegaCarta = (Carta) controller.darCartas();//pegando a segunda carta

            carta = (Carta) user.pegarCarta(pegaCarta);

            System.out.print("" + carta.getNumero());
            System.out.println("" + carta.getNaipe());
        }
        pegaCarta = (Carta) controller.darCartas();//pegando a primeira carta do croupier

        carta = (Carta) croupier.pegarCarta(pegaCarta);//salvando a primeira carta do croupier

        System.out.print("" + carta.getNumero());
        System.out.println("" + carta.getNaipe());

        pegaCarta = (Carta) controller.darCartas();//pegando a segunda carta do croupier

        croupier.pegarCarta(pegaCarta);
        System.out.println("Carta desconhecida");//segunda carta do croupier fica para baixo

        iterador = jogadoresDaPartida.iterator();

        while (!iterador.hasNext()) {//caso algum jogador tenha feito 21 pontos
            user = (Jogador) iterador.next();

            if (user.cartasNaMao() == 21) {
                System.out.print("Jogador " + user.getUser());
                System.out.println("fez 21 pontos ");
                user.setJogosVencidos(user.getJogosVencidos() + 1);
                break;
            }
        }
        while (croupier.cartasNaMao() <= 17) {//croupier pega cartas ate tentar vencer ou ser maior ou igual a 17
            pegaCarta = (Carta) controller.darCartas();
            croupier.pegarCarta(pegaCarta);
        }

        Iterator iteratorcroupier = croupier.getListadecartas().iterator();
        System.out.println("Cartas do croupier");

        while (!iteratorcroupier.hasNext()) { //imprime todas as cartas do croupier
            carta = (Carta) croupier.pegarCarta(pegaCarta);
            System.out.print("" + carta.getNumero());
            System.out.println("" + carta.getNaipe());
        }//colocar isso em um metodo para não repetir codigo

        iterador = jogadoresDaPartida.iterator();

        while (!iterador.hasNext()) {
            user = (Jogador) iterador.next();

            System.out.print("Jogador " + user.getUser());
            System.out.println("deseja pegar carta? [1] - SIM [2] - NÃO");//jogador quer mais cartas. pode colocar em um metodo
            resposta = Integer.parseInt(scan.nextLine());

            if (resposta == 1) {
                pegaCarta = (Carta) controller.darCartas();//pega nova carta

                carta = (Carta) user.pegarCarta(pegaCarta);
                pontos = pontos + Integer.parseInt(carta.getNumero());//salva a quantidade de pontos. mudar isso por causa do metodo cartasNaMao

                if (pontos == 21) {//verificando os pontos do jogador
                    System.out.print("Jogador " + user.getUser());
                    System.out.println("venceu com " + pontos);
                } else if (pontos > 21) {
                    System.out.print("Jogador " + user.getUser());
                    System.out.println("estorou com " + pontos);
                }
            }
            if (resposta == 2) {//caso o jogador não queira mais cartas
                if (pontos == 21) {
                    System.out.print("Jogador " + user.getUser());
                    System.out.println("venceu com " + pontos);
                } else if (pontos > 21) {
                    System.out.print("Jogador " + user.getUser());
                    System.out.println("estorou com " + pontos);
                } else {
                    System.out.print("Jogador " + user.getUser());
                    System.out.println("ficou com " + pontos);
                }
            }
        }
    }
    
    public Carta darCarta(){
        return (Carta)monteCartas.pop();
    }

}
