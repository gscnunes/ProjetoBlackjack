package jogoblackjack.model;

import jogoblackjack.controller.Controller;
import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;

public class Jogador {

    private String user;
    private String senha;
    private int ponttotal;
    private int jogosvencidos;
    private Ilist listadecartas;
    private MaoDeCarta maodecarta;
    Controller controller;

    public Jogador(String user, String senha) {
        this.user = user;
        this.senha = senha;
        listadecartas = new LinkedList();
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
        this.ponttotal = 10 * jogosvencidos;
    }

    public int getJogosVencidos() {
        return jogosvencidos;
    }

    public void setJogosVencidos(int jogosvencidos) {
        this.jogosvencidos = jogosvencidos;
    }

    public int pegarCarta(Carta carta) {
        this.listadecartas.addLast(carta);
        return maodecarta.CartasNaMao(listadecartas);
    }
    
    public Ilist cartasNaMao(){
        return this.listadecartas;
    }
}
