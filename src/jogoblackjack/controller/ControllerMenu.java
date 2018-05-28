package jogoblackjack.controller;

import java.io.Console;
import java.util.Scanner;
import jogoblackjack.model.*;
import jogoblackjack.util.*;

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
    
    public void listaJogadores(){       
        
        Ilist jogadores = controller.getJogadores();
        Iterator cursor = jogadores.iterator();
        
        
        if(jogadores.isEmpty()){
            System.out.println("Não há jogadores cadastrados!");
        }
        else{ 
            
            Jogador jogador;

            while(cursor.hasNext()){
                jogador = (Jogador)cursor.next();   
                System.out.println("User: " + jogador + "\nPontos: " + jogador.getPontTotal() + 
                                   "\nJogos vencidos: " + jogador.getJogosVencidos() + "\n"); 
                
            }
        }
    }

    //começa uma partida
    public void iniciarPartida(){
        controller.iniciarPartida();
    }

}
