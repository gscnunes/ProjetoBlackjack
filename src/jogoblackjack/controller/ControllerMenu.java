package jogoblackjack.controller;

import java.util.Scanner;
import jogoblackjack.model.*;
import jogoblackjack.util.*;

/**
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class ControllerMenu {

    private Scanner scan;
    private Controller controller;
    private ControllerArquivo controllerArquivo;

    /**
     * Construtor da classe ControllerMenu
     *
     */
    public ControllerMenu() {
        scan = new Scanner(System.in);
        controller = new Controller();
        controllerArquivo = new ControllerArquivo();
    }

    /**
     * Cadastra o novo jogador e manda para o controllerArquivo e para a lista
     * de jogadores no controller
     *
     * @param user - user do jogador recebido da view
     * @param senha - senha do jogador recebida da view
     */
    public void cadastrarPessoa(String user, String senha) {

        Jogador jogador = new Jogador(user, senha);//mando os auxiliares como parâmetro para a criação do novo jogador
        controllerArquivo.writer(jogador);
        controller.getJogadores().addLast(jogador);

    }

    /**
     * Mostra no console todos os jogadores que já estão cadastrados
     *
     */
    public void listaJogadores() {  

        Ilist jogadores = controller.getJogadores();
        Iterator cursor = jogadores.iterator();

        if (jogadores.isEmpty()) {
            System.out.println("\nNão há jogadores cadastrados!");
        } else {

            System.out.println("\nEstão cadastrados ao todo " + jogadores.size() + " jogadores:\n");
            Jogador jogador;

            while(cursor.hasNext()){
                jogador = (Jogador)cursor.next();   
                System.out.println("User: " + jogador); 

            }
        }
    }

}
