package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.Iterator;

/**
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class MaoDeCarta {

    private int pontos;

    /**
     * Método para retornar a quantidade de pontos que o jogador tem na mão
     *
     * @param maodecarta - recebe uma lista de cartas
     * @return pontos - quantidade de pontos
     */
    public int CartasNaMao(Ilist maodecarta) {

        pontos = 0;

        Carta temp;

        Iterator cursor = maodecarta.iterator();
        int aux;

        while (cursor.hasNext()) {
            temp = (Carta) cursor.next();

            switch (temp.getNumero()) {
                case "K":
                    aux = 10;
                    break;

                case "Q":
                    aux = 10;
                    break;

                case "J":
                    aux = 10;
                    break;
                case "AS":
                    aux = valorAs(maodecarta);
                    break;

                default:
                    aux = Integer.parseInt(temp.getNumero());
            }
            pontos = pontos + aux;
        }
        return pontos;
    }

    /**
     * Método para saber qual é o valor do Ás
     *
     * @param maodecarta - recebe a lista de carta
     * @return retorna um inteiro que depende das cartas que o jogador tem
     */
    public int valorAs(Ilist maodecarta) {
        Iterator cursor = maodecarta.iterator();
        Carta temp;

        while (cursor.hasNext()) {
            temp = (Carta) cursor.next();
            if (temp.getNumero().equals("K") || temp.getNumero().equals("Q") || temp.getNumero().equals("J")) {
                if (maodecarta.size() == 2) {
                    return 11;
                }
                if (pontos >= 10) {
                    return 1;
                } else {
                    return 11;
                }
            }
            if (pontos >= 10) {
                return 1;   
            } else {
                return 11;
            }
        }
        return 1;
    }

    /**
     * Método para setar os pontos da mão
     *
     * @param pontos - pontos que irá receber
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
