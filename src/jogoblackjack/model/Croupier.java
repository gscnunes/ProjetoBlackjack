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
    public int pegarCarta(Carta carta) {
        this.listadecartas.addLast(carta);
        return maodecarta.CartasNaMao(listadecartas);
    }
    
    @Override
     public Ilist cartasNaMao(){
        return this.listadecartas;
    }//alterar para só aparecer uma carta

}
