package jogoblackjack.controller;

import java.util.Scanner;
import jogoblackjack.model.*;
import jogoblackjack.util.*;

/**
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class Controller {

    private Scanner scan;
    private Ilist jogadores;
    private Ilist jogadoresDaPartida;
    private Partida partida;
    private ControllerArquivo controllerArquivo;
    private Croupier croupier;
    private boolean ganhou;
    private Carta[] cartasRestantes;

    /**
     * Construtor da classe Controller
     */
    public Controller() {
        scan = new Scanner(System.in);
        controllerArquivo = new ControllerArquivo();
        jogadores = controllerArquivo.reader();
        jogadoresDaPartida = new LinkedList();
        cartasRestantes = new Carta[52];

    }

    /**
     * Inicia a partida com o usuário escolhendo a quantidade de jogadores,
     * depois adiciona jogadores na partida e vai para o método do jogador pegar
     * nova carta
     */
    public void iniciarPartida() {

        if (jogadores.isEmpty()) {
            System.out.println("\nNão há jogadores cadastrados!");
        } else {

            int numDeJogadores;
            System.out.println("\nDigite a quantidade de jogadores [1-5]: ");

            numDeJogadores = scan.nextInt();

            while (numDeJogadores > jogadores.size() || numDeJogadores > 5) {
                System.out.println("\nNúmero de jogadores fora do limite, digite novamente: ");
                numDeJogadores = scan.nextInt();
            }
            partida = new Partida(numDeJogadores);
            croupier = partida.getCroupier();
            addJogadorNaPartida(jogadores);
            pegarCarta();
        
        }
        
    }

    /**
     *
     */
    public void placar() {
        LinkedList jogadores = controllerArquivo.reader();

    }//QUAL A FUNÇÃO DESSE MÉTODO???

    /**
     *
     * @return jogadores - lista com todos os jogadores
     */
    public Ilist getJogadores() {
        return jogadores;
    }

    /**
     * Método para mostrar as cartas que sobrou no baralho após a finalização da
     * partida, mostrar também as cartas de forma ordenada
     *
     * @param ordenar
     */
    public void listarCartas(String ordenar) {

        Carta aux;
        int aux2;
        int temp = 0;
        int[] arrayId = new int[52];
        int i = 0;

        while (!partida.getMonteCartas().isEmpty()) {
            aux = (Carta) partida.getMonteCartas().pop();
            cartasRestantes[i] = aux;
            i++;
            temp = i;
        }

        if ("nao".equals(ordenar)) {
            System.out.println("\nCartas restantes no monte:");
            for (Carta carta : cartasRestantes) {
                if (carta == null) {
                    break;
                }
                System.out.println("-----");
                System.out.println("\n" + carta);

            }
        } else {
            i = 0;

            for (Carta carta : cartasRestantes) {
                if (carta == null) {
                    break;
                }
                arrayId[i] = carta.getIdentificador();
                i++;
            }

            for (i = 1; i < arrayId.length; i++) {
                int j = i;

                while (j > 0 && arrayId[j] < arrayId[j - 1]) {
                    aux2 = arrayId[j];
                    arrayId[j] = arrayId[j - 1];
                    arrayId[j - 1] = aux2;
                    j--;
                }
            }
            System.out.println("Cartas restantes no monte ordenadas: \n");

            for (int id : arrayId) {
                for (Carta carta : cartasRestantes) {
                    if (carta == null) {
                        break;
                    }
                    if (id == carta.getIdentificador()) {
                        System.out.println("-----");
                        System.out.println(carta);
                    }
                }
            }
        }
    }

    /**
     * Método para adicionar um jogador na partida, digitando o user e a senha
     * do jogador desejado. Depois chama o método para distribuir as cartas
     * iniciais.
     *
     * @param jogadores - lista de todos os jogadores salvos
     */
    public void addJogadorNaPartida(Ilist jogadores) {

        String user, senha;
        Iterator iterador = jogadores.iterator();
        Jogador jogador;
        boolean contains = false;

        for (int i = 0; i < partida.getNumDeJogadores(); i++) {

            int indice = i + 1;

            System.out.println("\nDigite o User do jogador " + indice + ":");
            user = scan.next();

            while (contains == false) {
                while (iterador.hasNext()) {
                    jogador = (Jogador) iterador.next();
                    if (user.equals(jogador.getUser())) {
                        contains = true;

                        System.out.println("\nDigite a senha: ");
                        senha = scan.next();
                        while (!senha.equals(jogador.getSenha())) {
                            System.out.println("\nSenha incorreta, digite novamente!");
                            senha = scan.next();
                        }
                        partida.getJogadoresDaPartida().addLast(jogador);
                        jogadoresDaPartida = partida.getJogadoresDaPartida();
                        break;
                    }
                }
                if (!contains) {
                    System.out.println("\nJogador não encontrado, digite novamente!");
                    user = scan.next();
                    iterador = jogadores.iterator();

                }
            }
            contains = false;
        }
        cartasInicioDaPartida();
    }

    /**
     * Distribui as cartas iniciais para todos os jogadores da partida e também
     * para o croupier.
     */
    public void cartasInicioDaPartida() {
        Iterator iterador = jogadoresDaPartida.iterator();
        Jogador user;
        Carta carta;

        while (iterador.hasNext()) { //percorrendo a lista dos jogadores da partida 
            user = (Jogador) iterador.next(); //salvando o jogador atual

            user.pegarCarta(darCarta());
            user.pegarCarta(darCarta());
            mostrarMao(user);
        }
        System.out.println("\n\nCartas do Croupier:");
        carta = (Carta) croupier.pegarCarta(darCarta());

        System.out.println("");
        System.out.println(carta);
        croupier.pegarCarta(darCarta());
        System.out.println("**Carta desconhecida**");//segunda carta do croupier fica para baixo
        System.out.println("");
        System.out.println("");
    }

    /**
     * Método para fazer o croupier pegar cartas até o limite de 17 pontos, caso
     * passe disso ele para de pegar.
     */
    public void limiteCroupier() {
        while (croupier.cartasNaMao() < 17) { //croupier pega cartas ate tentar vencer ou ser maior ou igual a 17
            Carta pegaCarta = darCarta();
            croupier.pegarCarta(pegaCarta);
        }
    }

    /**
     * Método para imprimir as cartas do croupier.
     */
    public void cartasDoCroupier() {
        Iterator iterador = croupier.getCartas().iterator();
        System.out.println("Cartas do croupier:");

        System.out.println("");
        while (iterador.hasNext()) { //imprime todas as cartas do croupier
            Carta carta = (Carta) iterador.next();
            System.out.println(carta);
        }
        System.out.println("");
        System.out.println("");
    }

    /**
     * Método para verificar se determinado jogador fez 21 pontos
     *
     * @param user - jogador que deseja verificar
     * @return true caso o jogador fez 21
     */
    public boolean verificar21(Jogador user) {
        return user.cartasNaMao() == 21;
    }

    /**
     * Método que verificar qual jogador ganhou após a finalização da partida.
     * Salva o jogador que fez mais pontos comparando com todos os outros, logo
     * após compara com o croupier.
     *
     */
    public void verificarQuemGanhou() {
        Iterator iterador = jogadoresDaPartida.iterator();
        Jogador jogadorMaior = (Jogador) iterador.next();
        Jogador user;

        while (iterador.hasNext()) {
            user = (Jogador) iterador.next();

            if (user.cartasNaMao() < 21 && user.cartasNaMao() > jogadorMaior.cartasNaMao()) {
                jogadorMaior = user;
            }
        }
        if (rodarCroupier(jogadorMaior)) {
            return;
        }
        System.out.println("Jogador " + jogadorMaior + " ganhou!");

        jogadorMaior.setJogosVencidos(jogadorMaior.getJogosVencidos() + 1);
        jogadorMaior.setPontTotal(jogadorMaior.getPontTotal() + 10);
        controllerArquivo.writer(jogadorMaior);
    }

    /**
     * Método para comparar o jogador que fez mais pontos com os pontos do
     * croupier para saber qual dos dois ganhou.
     *
     * @param jogadorMaior - jogador que fez mais pontos
     * @return
     */
    public boolean rodarCroupier(Jogador jogadorMaior) {
        if (croupier.cartasNaMao() > jogadorMaior.cartasNaMao() && croupier.cartasNaMao() < 21) {
            System.out.println("O croupier ganhou!");
            return true;
        }
        return false;
    }

    /**
     * Método para imprimir as cartas dos jogadores
     *
     * @param jogador - jogador que as cartas será impresa
     */
    public void mostrarMao(Jogador jogador) { //criei um método pra mostrar as cartas da mão

        Iterator cursor = jogador.getCartas().iterator();

        System.out.println("Cartas do user: " + jogador);
        System.out.println("");

        while (cursor.hasNext()) {
            Carta carta = (Carta) cursor.next();
            System.out.println(carta);
        }
        System.out.println("");
    }

    /**
     * Método para saber se todos os jogadores da partida jogaram.
     *
     * @return
     */
    public boolean getGanhou() {
        return ganhou;
    }

    /**
     * Método para o jogador pegar novas cartas. Caso ele queira uma nova carta
     * ela é adicionada na sua mão.
     */
    public void pegarCarta() {
        String resposta;
        int naoPegar = 0;
        do {
            Iterator iterador = jogadoresDaPartida.iterator();

            while (iterador.hasNext()) {
                Jogador user = (Jogador) iterador.next();

                System.out.print("\nJogador " + user.getUser());
                System.out.println(" deseja pegar carta? [1] - SIM [2] - NÃO");
                resposta = scan.next();

                while ("1".equals(resposta)) {
                    user.pegarCarta(darCarta());
                    mostrarMao(user);
                    if (verificarEstourou(user)) {
                        System.out.println("\nJogador " + user.getUser() + " estourou!");

                        LinkedList novasCartas = new LinkedList();
                        MaoDeCarta novaMao = new MaoDeCarta();

                        user.setCartas(novasCartas);
                        user.setMaodecarta(novaMao);
                        break;
                    } else if (verificar21(user)) {
                        System.out.println("\nJogador " + user.getUser() + " fez 21!");
                        user.setJogosVencidos(user.getJogosVencidos() + 1);
                        user.setPontTotal(user.getPontTotal() + 10);
                        controllerArquivo.writer(user);
                        break;
                    }
                    System.out.print("\nJogador " + user.getUser());
                    System.out.println(" deseja pegar carta? [1] - SIM [2] - NÃO");
                    resposta = scan.next();
                }
                naoPegar++;
            }
            if (naoPegar == partida.getNumDeJogadores()) {
                ganhou = false;
            }
        } while (getGanhou());

        limiteCroupier();
        cartasDoCroupier();
        verificarQuemGanhou();
        zerarValores();
    }

    /**
     * Método para zerar a mão dos jogadores e a lista de jogadores da partida,
     * após a finalização da partida.
     */
    public void zerarValores() {

        Iterator iterador = jogadoresDaPartida.iterator();
        Jogador user;
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

    /**
     * Método para verificar se o jogador estourou.
     *
     * @param user - jogador que deseja verificar
     * @return true caso o jogador tenha estourado
     */
    public boolean verificarEstourou(Jogador user) {
        return user.cartasNaMao() > 21;
    }

    /**
     * Método para pegar uma nova carta.
     *
     * @return
     */
    public Carta darCarta() {
        return (Carta) partida.getMonteCartas().pop();
    }

}
