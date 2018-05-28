package jogoblackjack.controller;

import java.io.Console;
import java.util.Scanner;
import jogoblackjack.model.Baralho;
import jogoblackjack.model.Jogador;
import jogoblackjack.util.IStack;
import jogoblackjack.util.Pilha;

public class ControllerMenu {

    private Scanner scan = new Scanner(System.in);
    private Controller controller = new Controller();
   
    //Opções do menu que o usuario digita o que ele deseja fazer
    public void Menu() {
        
    }

    //cadastrar todos os jogadores
    public void cadastrarPessoa() {
        System.out.println("Digite o user do Jogador:");        
        String user = scan.nextLine(); //criei um auxiliar pra guardar o dado inserido
        
        System.out.println("Digite a senha do Jogador:");        
        String senha = scan.nextLine();
        
        Jogador jogador = new Jogador(user, senha);//mando os auxiliares como parâmetro para a criação do novo jogador
        
        //controller = new Controller(); //CORREÇÃO AQUI
        controller.addJogador(jogador);//metodo para adicionar os jogadores na lista
    }

    //começa uma partida
    public void iniciarPartida(){
        controller.iniciarPartida();
    }

}