package jogoblackjack.controller;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import jogoblackjack.model.*;
import jogoblackjack.util.*;

public class Controller {

    private Scanner scan;
    private Ilist jogadores;
    private Ilist jogadoresDaPartida;
    private Partida partida;
    private ControllerArquivo controllerArquivo;
    private Croupier croupier;
    private boolean ganhou;
    private Carta [] cartasRestantes;

    public Controller() {
        scan = new Scanner(System.in);
        controllerArquivo = new ControllerArquivo();
        jogadores = controllerArquivo.reader();
        jogadoresDaPartida = new LinkedList();
        cartasRestantes = new Carta[52];

    }

    //inicia uma partida fazendo o usuario escolher a quantidade de jogadores
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

    public void placar() {
        LinkedList jogadores = controllerArquivo.reader();

    }

    public Ilist getJogadores() {
        return jogadores;
    }

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
        
        
        if("nao".equals(ordenar)){
            System.out.println("\nCartas restantes no monte:");
            for(Carta carta: cartasRestantes){
                if(carta == null){
                    break;
                }
                System.out.println("-----");
                System.out.println("\n" + carta); 
                
            }
        }
        else{
            i = 0;
            
            for(Carta carta: cartasRestantes){
                if(carta == null){
                    break;
                }
                arrayId[i] = carta.getIdentificador();
                i++;
            }
            
            
            for(i = 1; i < arrayId.length; i++){
                int j = i;
            
                while(j > 0 && arrayId[j] < arrayId[j-1]){
                    aux2 = arrayId[j];
                    arrayId[j] = arrayId[j-1];
                    arrayId[j-1] = aux2; 
                    j--;
                }
            }
            System.out.println("Cartas restantes no monte ordenadas: \n");
            
            for(int id: arrayId){
               for (Carta carta : cartasRestantes) {
                    if(carta == null){
                       break;
                    } 
                    if (id == carta.getIdentificador()) {
                        System.out.println("-----");
                        System.out.println(carta);
                    }
                } 
            }
            
            
            
            
            
            
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        

//        while (!partida.getMonteCartas().isEmpty()) {
//            aux = (Carta) partida.getMonteCartas().pop();
//            System.out.println("\nCARTA RETIRADA DA PILHA: " + aux + " " + aux.getIdentificador());
//            arrayCartas[i] = new Carta(aux.getNaipe(), aux.getNumero(), aux.getIdentificador());
//            arrayId[i] = (aux.getIdentificador());            
//            i++;
//            temp = i;
//        }        
//        
//        
//        Baralho novoBaralho = new Baralho();
//        Carta[] cartas = novoBaralho.getCartas();
//        
//        
//        System.out.println("\nCartas restantes no monte: ");
//        
//        if("nao".equals(ordenar)){
//            for(int c = 0; c < temp; c++){
//                for (Carta carta : cartas) {
//                    if (arrayId[c] == carta.getIdentificador()) {
//                        System.out.println("-----");
//                        System.out.println("\n" + carta);
//                    }
//                } 
//            }
//        }  
//        
//        else if("sim".equals(ordenar)){            
//            for(i = 1; i < arrayId.length; i++){
//                int j = i;
//            
//                while(j > 0 && array[j] < array[j-1]){
//                    aux2 = array[j];
//                    array[j] = array[j-1];
//                    array[j-1] = aux2; 
//                    j--;
//                }
//            }
//            System.out.println("Cartas restantes no monte ordenadas: \n");
//            
//            for(int id: array){
//               for (Carta carta : cartas) {
//                    if (id == carta.getIdentificador()) {
//                        System.out.println("-----");
//                        System.out.println("\n" + carta);
//                    }
//                } 
//            }
//        }
        

    }
    

    //adiciona um jogador na partida
    public void addJogadorNaPartida(Ilist jogadores) { //MUDEI BASTANTE ESSE MÉTODO, PRA QUE TRATASSE OS ERROS DIREITINHO

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

    public void limiteCroupier() {
        while (croupier.cartasNaMao() < 17) { //croupier pega cartas ate tentar vencer ou ser maior ou igual a 17
            Carta pegaCarta = darCarta();
            croupier.pegarCarta(pegaCarta);
        }
    }

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

    
    public boolean verificar21(Jogador user){
        return user.cartasNaMao() == 21;
    }

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

    }

    public boolean rodarCroupier(Jogador jogadorMaior) {
        if (croupier.cartasNaMao() > jogadorMaior.cartasNaMao() && croupier.cartasNaMao() < 21) {
            System.out.println("O croupier ganhou!");
            return true;
        }
        return false;
    }

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

    public boolean getGanhou() {
        return ganhou;
    }

    //melhorar isso
    public void pegarCarta() { //TAMBÉM ARRUMEI ESSE, TÁ PEGANDO AS CARTAS DIREITINHO
        String resposta;
        int naoPegar = 0;
        do {
            Iterator iterador = jogadoresDaPartida.iterator();
            //meto1do pedir nova carta
            while (iterador.hasNext()) {
                Jogador user = (Jogador) iterador.next();

                System.out.print("\nJogador " + user.getUser());
                System.out.println(" deseja pegar carta? [1] - SIM [2] - NÃO");//jogador quer mais cartas. pode colocar em um metodo
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
                    }
                    else if(verificar21(user)){
                        System.out.println("\nJogador " + user.getUser() + " fez 21!");
                        user.setJogosVencidos(user.getJogosVencidos() + 1);
                        user.setPontTotal(user.getPontTotal() + 10);                        
                        break;
                    }
                    System.out.print("\nJogador " + user.getUser());
                    System.out.println(" deseja pegar carta? [1] - SIM [2] - NÃO");//jogador quer mais cartas. pode colocar em um metodo
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

    public boolean verificarEstourou(Jogador user) {
        return user.cartasNaMao() > 21;
    }

    //metodo para pegar novas cartas
    public Carta darCarta() {
        return (Carta) partida.getMonteCartas().pop();
    }

}
