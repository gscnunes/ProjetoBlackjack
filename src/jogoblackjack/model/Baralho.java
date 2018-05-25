package jogoblackjack.model;

import java.util.Random;
import jogoblackjack.util.IStack;
import jogoblackjack.util.Pilha;

public class Baralho {

    private Carta[] cartas;
    private Pilha pcartas;

    public Baralho() {
        this.cartas = new Carta[52];
        addCartas();
        pcartas = new Pilha();
    }

    public Object[] addCartas() {
        cartas[0] = new Carta("♣", "2", 1); //coloquei os naipes, ficou bonitinho ♥
        cartas[1] = new Carta("♣", "3", 2);
        cartas[2] = new Carta("♣", "4", 3);
        cartas[3] = new Carta("♣", "5", 4);
        cartas[4] = new Carta("♣", "6", 5);
        cartas[5] = new Carta("♣", "7", 6);
        cartas[6] = new Carta("♣", "8", 7);
        cartas[7] = new Carta("♣", "9", 8);
        cartas[8] = new Carta("♣", "10", 9);
        cartas[9] = new Carta("♣", "K", 10);
        cartas[10] = new Carta("♣", "J", 11);
        cartas[11] = new Carta("♣", "Q", 12);
        cartas[12] = new Carta("♣", "AS", 13);

        cartas[13] = new Carta("♥", "2", 14);
        cartas[14] = new Carta("♥", "3", 15);
        cartas[15] = new Carta("♥", "4", 16);
        cartas[16] = new Carta("♥", "5", 17);
        cartas[17] = new Carta("♥", "6", 18);
        cartas[18] = new Carta("♥", "7", 19);
        cartas[19] = new Carta("♥", "8", 20);
        cartas[20] = new Carta("♥", "9", 21);
        cartas[21] = new Carta("♥", "10", 22);
        cartas[22] = new Carta("♥", "K", 23);
        cartas[23] = new Carta("♥", "J", 24);
        cartas[24] = new Carta("♥", "Q", 25);
        cartas[25] = new Carta("♥", "AS", 26);

        cartas[26] = new Carta("♠", "2", 27);
        cartas[27] = new Carta("♠", "3", 28);
        cartas[28] = new Carta("♠", "4", 29);
        cartas[29] = new Carta("♠", "5", 30);
        cartas[30] = new Carta("♠", "6", 31);
        cartas[31] = new Carta("♠", "7", 32);
        cartas[32] = new Carta("♠", "8", 33);
        cartas[33] = new Carta("♠", "9", 34);
        cartas[34] = new Carta("♠", "10", 35);
        cartas[35] = new Carta("♠", "K", 36);
        cartas[36] = new Carta("♠", "J", 37);
        cartas[37] = new Carta("♠", "Q", 38);
        cartas[38] = new Carta("♠", "AS", 39);

        cartas[39] = new Carta("♦", "2", 40);
        cartas[40] = new Carta("♦", "3", 41);
        cartas[41] = new Carta("♦", "4", 42);
        cartas[42] = new Carta("♦", "5", 43);
        cartas[43] = new Carta("♦", "6", 44);
        cartas[44] = new Carta("♦", "7", 45);
        cartas[45] = new Carta("♦", "8", 46);
        cartas[46] = new Carta("♦", "9", 47);
        cartas[47] = new Carta("♦", "10", 48);
        cartas[48] = new Carta("♦", "K", 49);
        cartas[49] = new Carta("♦", "J", 50);
        cartas[50] = new Carta("♦", "Q", 51);
        cartas[51] = new Carta("♦", "AS", 52);

        return cartas;
    }

    public Pilha embaralharEAddPilha() {
        Random random = new Random();

        for (int i = 0; i < cartas.length; i++) {

            int j = random.nextInt(cartas.length);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }

        for (Object carta : cartas) {
            pcartas.push(carta);
        }
        return pcartas;
    }
}
