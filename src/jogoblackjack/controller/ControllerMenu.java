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
   
    //Opções do menu que o usuario digita o que ele deseja fazer
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

    //cadastrar todos os jogadores
    public void cadastrarPessoa() {
        System.out.println("Digite o user do Jogador:");        
        String user = scan.nextLine(); //criei um auxiliar pra guardar o dado inserido
        
        System.out.println("Digite a senha do Jogador:");        
        String senha = scan.nextLine();
        
        Jogador jogador = new Jogador(user, senha);//mando os auxiliares como parâmetro para a criação do novo jogador
        
        controller.addJogador(jogador);//metodo para adicionar os jogadores na lista
    }

    //começa uma partida
    public void iniciarPartida(){
        controller.iniciarPartida();
    }

}
