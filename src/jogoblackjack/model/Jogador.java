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

    public Jogador(String user, String senha) {
        this.user = user;
        this.senha = senha;
        maodecarta = new MaoDeCarta();
        listadecartas = new LinkedList();
    }
   
    //retorna a carta que o jogador acabou de pegar
    public Object pegarCarta(Carta carta) {
        this.listadecartas.addLast(carta);
        
        return carta;
    }
    //retorna os pontos do jogador
    public int cartasNaMao() {
        return maodecarta.CartasNaMao(listadecartas);
    }
    //lista de todas as cartas do jogador
    public Ilist getCartas() { //como esse método faz a mesma coisa que um get faria, deixei assim porque tava meio confuso
        return listadecartas;
    } 
    
    public void setCartas(Ilist nova){
        this.listadecartas = nova;
    }    
    
    public void setMaodecarta(MaoDeCarta maodecarta) {
        this.maodecarta = maodecarta;
    }
    
    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public int getPontTotal() {
        return ponttotal;
    }

    public void setPontTotal(int ponttotal) { //TIVE QUE MODIFICAR AQUI E O "jogosVencidos" POR CAUSA DO ARQUIVO
        this.ponttotal = ponttotal;
    }

    public int getJogosVencidos() {
        return jogosvencidos;
    }

    public void setJogosVencidos(int jogosvencidos) {
        this.jogosvencidos = jogosvencidos;
    }
    
    @Override
    public String toString() { //criei esse aqui também pra facilitar
        return user;
    }
    
}
