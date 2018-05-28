package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.Iterator;

public class MaoDeCarta {

    private int pontos;

    //retorna o total de pontos na mão
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

    public int valorAs(Ilist maodecarta) {
        Iterator cursor = maodecarta.iterator();
        Carta temp;

        while (cursor.hasNext()) {
            temp = (Carta) cursor.next();
            if (temp.getNumero().equals("K") || temp.getNumero().equals("Q") || temp.getNumero().equals("J")) {
                if (maodecarta.size() == 2) {
                    return 11;
                }
            }
        }
        return 1;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
