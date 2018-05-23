package jogoblackjack.view;

import jogoblackjack.controller.ControllerMenu;


public class JogoBlackjack {
    //Iniciar o programa e chama o metodo de menu do controllerMenu
    public static void main(String[] args) {
        System.out.println("\t\tJOGO BLACKJACK");
       ControllerMenu controller = new ControllerMenu();
       controller.Menu();
    }       
}
