package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;

public class Jogador {

    private String user;
    private String senha;
    private int ponttotal;
    private int jogosvencidos;
    private Ilist maodecarta;
    private MaoDeCarta maodecarta2;
    

    public Jogador(String user, String senha) {
        this.user = user;
        this.senha = senha;
        maodecarta = new LinkedList();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPontTotal() {
        return ponttotal;
    }

    public void setPontTotal(int ponttotal) {
        this.ponttotal = ponttotal;
    }

    public int getJogosVencidos() {
        return jogosvencidos;
    }

    public void setJogosVencidos(int jogosvencidos) {
        this.jogosvencidos = jogosvencidos;
    }
    
    public void pegarCarta(Croupier croupier){
        this.maodecarta.addLast(croupier.pegaCarta());
        maodecarta2.CartasNaMao(maodecarta);
    }
}
