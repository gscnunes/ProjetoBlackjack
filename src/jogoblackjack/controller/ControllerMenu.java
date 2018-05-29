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

        Jogador jogador = new Jogador(user, senha);
        controllerArquivo.writer(jogador);
        controller.getJogadores().addLast(jogador);

    }

    /**
     * Mostra no console todos os jogadores que já estão cadastrados
     *
     */
    public void listaJogadores() {

        Ilist lista = controller.getJogadores();
        Iterator iterador = lista.iterator();

        System.out.println("\nEstão cadastrados ao todo " + lista.size() + " jogadores: ");

        while (iterador.hasNext()) {
            Jogador jogador = (Jogador) iterador.next();
            System.out.println("\n" + jogador);
        }
    }
}
