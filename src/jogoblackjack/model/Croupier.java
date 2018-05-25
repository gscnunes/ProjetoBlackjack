package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;

public class Croupier extends Jogador {

    private Ilist listadecartas;
    private MaoDeCarta maodecarta;

    public Croupier(String user, String senha) {
        super(user, senha);
        listadecartas = new LinkedList();
    }

    //retorna a carta que o croupier acabou de pegar
    @Override
    public Object pegarCarta(Carta carta) {
        this.listadecartas.addLast(carta);
        return carta;
    }

    //retorna os pontos do jogador
    @Override
    public int cartasNaMao() {
        return maodecarta.CartasNaMao(listadecartas);
    }

    //lista de todas as cartas do croupier
    @Override
    public Ilist cartas() {
        return this.listadecartas;
    }
}
