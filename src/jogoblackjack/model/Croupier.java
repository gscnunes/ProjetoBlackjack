package jogoblackjack.model;

import jogoblackjack.util.IStack;
import jogoblackjack.util.Pilha;

public class Croupier extends Jogador {

    IStack pcartas;
    MaoDeCarta maodecarta;

    public Croupier(String user, String senha) {
        super(user, senha);
        pcartas = new Pilha();
    }

    void regra17() {
        if (maodecarta.CartasNaMao() >= 17) {
            //parar de pegar cartas
        }
    }
    
      Object pegaCarta() {
        return pcartas.pop();
    }
}
