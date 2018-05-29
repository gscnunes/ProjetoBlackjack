package jogoblackjack.controller;

import java.io.Console;
import java.util.Scanner;
import jogoblackjack.model.*;
import jogoblackjack.util.*;

public class ControllerMenu {

    private Scanner scan = new Scanner(System.in);
    private Controller controller = new Controller();
    private ControllerArquivo controllerArquivo = new ControllerArquivo();
   
    

    //cadastrar todos os jogadores
    public void cadastrarPessoa(String user, String senha) {
        
        Jogador jogador = new Jogador(user, senha);//mando os auxiliares como parâmetro para a criação do novo jogador
        controllerArquivo.writer(jogador); 
        controller.getJogadores().addLast(jogador);
        
    }
    
    public void listaJogadores(){       //CRIEI ESSE MÉTODO PRA LISTAR TODOS OS JOGADORES CADASTRADOS
        
        Ilist jogadores = controller.getJogadores();
        Iterator cursor = jogadores.iterator();
        
        
        if(jogadores.isEmpty()){
            System.out.println("\nNão há jogadores cadastrados!");
        }
        else{ 
            
            System.out.println("\nEstão cadastrados ao todo " + jogadores.size() + " jogadores:\n");
            Jogador jogador;

            while(cursor.hasNext()){
                jogador = (Jogador)cursor.next();   
                System.out.println("User: " + jogador); 
                
            }
        }
    }


}
