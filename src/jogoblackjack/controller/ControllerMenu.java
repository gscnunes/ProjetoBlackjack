package jogoblackjack.controller;

import java.io.Console;
import java.util.Scanner;
import jogoblackjack.model.Baralho;
import jogoblackjack.model.Jogador;
import jogoblackjack.util.IStack;
import jogoblackjack.util.Pilha;

public class ControllerMenu {

    Scanner scan = new Scanner(System.in);
    Console console;
    Controller controller;
    Jogador jogador;
   

    public void Menu() {
        int opcao;
        int sair = 1;

        do {
            System.out.println("[1] - Cadastrar jogadores\n[2] - Iniciar Partida\n[0] - Sair");
            opcao = Integer.parseInt(scan.nextLine());
            switch (opcao) {

                case 1:
                    cadastrarPessoa();
                    break;
                case 2:
                    iniciarPartida();
                    break;
                case 0:
                    sair = 0;
                    break;
                default:
                    System.out.println("Opção invalida");
            }

        } while (sair == 1);
    }

    //problema aqui
    public void cadastrarPessoa() {
        System.out.println("Digite o user do Jogador:");
        jogador.setUser(scan.nextLine());
        System.out.println("aqui vai");        
        System.out.println("Digite a senha do Jogador:");
        jogador.setSenha(scan.nextLine());
        
        controller.addJogador(jogador);
    }

    public void iniciarPartida(){
        controller.iniciarPartida();
    }

}
