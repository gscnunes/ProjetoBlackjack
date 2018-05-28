package jogoblackjack.view;

import java.util.Scanner;
import jogoblackjack.controller.*;


public class View {
    //Iniciar o programa e chama o metodo de menu do controllerMenu
    
    private Controller controller = new Controller();
    private static ControllerMenu controllerMenu = new ControllerMenu();
    private static Scanner scan = new Scanner(System.in);
    
    
    public static void main(String[] args) {    
        
        System.out.println("\t\tJOGO BLACKJACK");
      
        int opcao;
        int sair = 1;

        do { 
            System.out.println("[1] - Cadastrar jogadores\n[2] - Listar todos os jogadores\n[3] - Iniciar Partida\n[0] - Sair\n");
            opcao = scan.nextInt();            
            switch (opcao) {
                case 1:
                    controllerMenu.cadastrarPessoa();
                    break;
                case 2:
                    controllerMenu.listaJogadores(); //NOVO MÉTODO
                    break;                            
                case 3:
                    controllerMenu.iniciarPartida();
                    break;
                case 0:
                    sair = 0;
                    break;
                default: 
                    System.out.println("Opção invalida");
            }
        } while (sair == 1); 
    }       
}
