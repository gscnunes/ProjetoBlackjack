package jogoblackjack.model;

import java.util.Random;
import jogoblackjack.util.IStack;
import jogoblackjack.util.Pilha;

public class Baralho {

    Object[] cartas;
    IStack pcartas;

    public Baralho() {
        this.cartas = new Object[52];
        pcartas = new Pilha();
        addCartas();
        embaralharEAddPilha();
    }
    //transformar os valores em Strings

    public void addCartas() {
        cartas[0] = new Carta("paus", "2", 1);
        cartas[1] = new Carta("paus", "3", 2);
        cartas[2] = new Carta("paus", "4", 3);
        cartas[3] = new Carta("paus", "5", 4);
        cartas[4] = new Carta("paus", "6", 5);
        cartas[5] = new Carta("paus", "7", 6);
        cartas[6] = new Carta("paus", "8", 7);
        cartas[7] = new Carta("paus", "9", 8);
        cartas[8] = new Carta("paus", "10", 9);
        cartas[9] = new Carta("paus", "K", 10);
        cartas[10] = new Carta("paus", "J", 11);
        cartas[11] = new Carta("paus", "Q", 12);
        cartas[12] = new Carta("paus", "AS", 13);

        cartas[13] = new Carta("copas", "2", 14);
        cartas[14] = new Carta("copas", "3", 15);
        cartas[15] = new Carta("copas", "4", 16);
        cartas[16] = new Carta("copas", "5", 17);
        cartas[17] = new Carta("copas", "6", 18);
        cartas[18] = new Carta("copas", "7", 19);
        cartas[19] = new Carta("copas", "8", 20);
        cartas[20] = new Carta("copas", "9", 21);
        cartas[21] = new Carta("copas", "10", 22);
        cartas[22] = new Carta("copas", "K", 23);
        cartas[23] = new Carta("copas", "J", 24);
        cartas[24] = new Carta("copas", "Q", 25);
        cartas[25] = new Carta("copas", "AS", 26);

        cartas[26] = new Carta("espadas", "2", 27);
        cartas[27] = new Carta("espadas", "3", 28);
        cartas[28] = new Carta("espadas", "4", 29);
        cartas[29] = new Carta("espadas", "5", 30);
        cartas[30] = new Carta("espadas", "6", 31);
        cartas[31] = new Carta("espadas", "7", 32);
        cartas[32] = new Carta("espadas", "8", 33);
        cartas[33] = new Carta("espadas", "9", 34);
        cartas[34] = new Carta("espadas", "10", 35);
        cartas[35] = new Carta("espadas", "K", 36);
        cartas[36] = new Carta("espadas", "J", 37);
        cartas[37] = new Carta("espadas", "Q", 38);
        cartas[38] = new Carta("espadas", "AS", 39);

        cartas[39] = new Carta("ouros", "2", 40);
        cartas[40] = new Carta("ouros", "3", 41);
        cartas[41] = new Carta("ouros", "4", 42);
        cartas[42] = new Carta("ouros", "5", 43);
        cartas[43] = new Carta("ouros", "6", 44);
        cartas[44] = new Carta("ouros", "7", 45);
        cartas[45] = new Carta("ouros", "8", 46);
        cartas[46] = new Carta("ouros", "9", 47);
        cartas[47] = new Carta("ouros", "10", 48);
        cartas[48] = new Carta("ouros", "K", 49);
        cartas[49] = new Carta("ouros", "J", 50);
        cartas[50] = new Carta("ouros", "Q", 51);
        cartas[51] = new Carta("ouros", "AS", 52);
    }

    public void embaralharEAddPilha() {
        Random random = new Random();

        for (int i = 0; i < cartas.length; i++) {
            int j = random.nextInt(cartas.length);
            
            Object temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }

        for (Object carta : cartas) {
            pcartas.push(carta);
        }
    }
}
