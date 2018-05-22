package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;

public class Croupier extends Jogador {

    Ilist listadecartas;
    MaoDeCarta maodecarta;

    public Croupier(String user, String senha) {
        super(user, senha);
        listadecartas = new LinkedList();
    }

    @Override
    public int pegarCarta(Croupier croupier) {
        this.listadecartas.addLast(croupier.pegaCarta());
        return maodecarta.CartasNaMao(listadecartas);
    }
}
