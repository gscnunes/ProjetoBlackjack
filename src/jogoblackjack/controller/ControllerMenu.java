package jogoblackjack.controller;

import java.util.Scanner;
import jogoblackjack.model.*;
import jogoblackjack.util.*;

public class ControllerMenu {

    private Scanner scan; 
    private Controller controller;
    private ControllerArquivo controllerArquivo;    
    
    public ControllerMenu(){
        scan = new Scanner(System.in); 
        controller = new Controller();
        controllerArquivo = new ControllerArquivo();
    }

    //cadastrar todos os jogadores
    public void cadastrarPessoa(String user, String senha) {
        
        Jogador jogador = new Jogador(user, senha);//mando os auxiliares como parâmetro para a criação do novo jogador
        controllerArquivo.writer(jogador); 
        controller.getJogadores().addLast(jogador);
        
    }
    
    public void listaJogadores(){       //CRIEI ESSE MÉTODO PRA LISTAR TODOS OS JOGADORES CADASTRADOS
        Ilist lista = controller.getJogadores();
        Iterator iterador = lista.iterator();
        
        System.out.println("\nEstão cadastrados ao todo " + lista.size() + " jogadores: ");
        
        while(iterador.hasNext()){
            Jogador jogador = (Jogador) iterador.next();
            System.out.println("\n" + jogador);
        }
    }
}
