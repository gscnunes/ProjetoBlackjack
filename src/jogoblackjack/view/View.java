package jogoblackjack.view;

import java.util.Scanner;
import jogoblackjack.controller.*;

/**
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class View {

    private static Controller controller = new Controller();
    private static ControllerMenu controllerMenu = new ControllerMenu();
    private static Scanner scan = new Scanner(System.in);

    /**
     * Função principal, primeira função que executa no console. Mostra as
     * opções do que o usuário pode fazer
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("\t\t♠BEM VINDO AO JOGO BLACKJACK♠");

        String opcao;
        int sair = 1;

        do {
            System.out.println("\nO que você deseja?\n"
                    + "[1] - Cadastrar jogadores\n"
                    + "[2] - Listar todos os jogadores\n"
                    + "[3] - Iniciar Partida\n"
                    + "[0] - Sair\n");

            opcao = scan.next();
            switch (opcao) {

                case "1":
                    System.out.println("Digite o user do Jogador:");
                    String user = scan.next();

                    System.out.println("Digite a senha do Jogador:");
                    String senha = scan.next();

                    controllerMenu.cadastrarPessoa(user, senha);
                    break;

                case "2":
                    controllerMenu.listaJogadores();
                    break;

                case "3":
                    controller.iniciarPartida();
                    menuFimPartida();
                    break;

                case "0":
                    sair = 0;
                    break;

                default:
                    System.out.println("Opção inválida! Digite novamente: ");
            }
        } while (sair == 1);

    }

    /**
     * Quando a partida acaba é exibido esse menu com as opções que o usuário
     * pode escolher
     */
    public static void menuFimPartida() {

        String ordenar;
        int sair = 1;

        do{
            System.out.println("\nO que você deseja?\n"
                    + "[1] - Listar cartas restantes\n"
                    + "[2] - Listar cartas restantes ordenadas\n"
                    + "[0] - Sair\n");

            String resp = scan.next();

            switch (resp){
                case "1":
                    ordenar = "nao";
                    controller.listarCartas(ordenar);
                    break;
                case"2":
                    ordenar = "sim";
                    controller.listarCartas(ordenar);
                    break;
                case"0":
                    sair = 0;
                    break;
                default:
                    System.out.println("\nOpção inválida! Digite novamente: ");
                    break;
            }
        }while(sair == 1);
    }
}
