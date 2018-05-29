package jogoblackjack.model;

import jogoblackjack.util.Ilist;
import jogoblackjack.util.LinkedList;

/**
 *
 * @author Daniel Alves e Gabriela Dos Santos
 */
public class Jogador {

    private String user;
    private String senha;
    private int ponttotal;
    private int jogosvencidos;
    private Ilist listadecartas;
    private MaoDeCarta maodecarta;

    /**
     * Construtor da classe Jogador
     *
     * @param user
     * @param senha
     */
    public Jogador(String user, String senha) {
        this.user = user;
        this.senha = senha;
        maodecarta = new MaoDeCarta();
        listadecartas = new LinkedList();
    }

    /**
     *
     * @return user - user do jogador criado
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user - recebe um user para colocar no jogador
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return senha - senha do jogador criado
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha - recebe uma senha para colocar no jogador
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return ponttotal - pontos totais do jogador
     */
    public int getPontTotal() {
        return ponttotal;
    }

    /**
     *
     * @param ponttotal - recebe os pontos que o jogador recebeu na partida
     */
    public void setPontTotal(int ponttotal) {
        this.ponttotal = ponttotal;
    }

    /**
     *
     * @return jogosvencidos - jogos vencidos pelo jogador
     */
    public int getJogosVencidos() {
        return jogosvencidos;
    }

    /**
     *
     * @param jogosvencidos - recebe a quantidade de jogos vencidos pelo jogador
     */
    public void setJogosVencidos(int jogosvencidos) {
        this.jogosvencidos = jogosvencidos;
    }

    /**
     * Método para salvar na lista de cartas a carta que está recebendo por
     * paramentro
     *
     * @param carta - carta recebida
     * @return carta - retorna a carta
     */
    public Object pegarCarta(Carta carta) {
        this.listadecartas.addLast(carta);
        return carta;
    }

    /**
     * Método para retornar a quantidade de pontos que o jogador tem na mão
     *
     * @return maodecarta.CartasNaMao(listadecartas)
     */
    public int cartasNaMao() {
        return maodecarta.CartasNaMao(listadecartas);
    }

    /**
     * Método para retornar a lista com as cartas que o jogador tem na mão
     *
     * @return listadecartas
     */
    public Ilist getCartas() {
        return listadecartas;
    }

    /**
     * Método para setar uma nova lista de cartas, utilizamos para zerar a lista
     * de cartas do jogador
     *
     * @param nova - nova lista de cartas
     */
    public void setCartas(Ilist nova) {
        this.listadecartas = nova;
    }

    /**
     * Método para setar uma nova mão de cartas no jogador, utilizamos para
     * zerar a mão de carta do jogador
     *
     * @param maodecarta - nova mão de carta
     */
    public void setMaodecarta(MaoDeCarta maodecarta) {
        this.maodecarta = maodecarta;
    }

    @Override
    public String toString() {
        return user;
    }
}
