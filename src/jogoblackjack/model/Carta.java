package jogoblackjack.model;

/**
 *
 * @author Daniel Alves e Gabriela Dos Santos
 */
public class Carta {

    private String naipe;
    private String numero;
    private int id;

    /**
     *
     * @return naipe - naipe da carta criada
     */
    public String getNaipe() {
        return naipe;
    }

    /**
     *
     * @param naipe - recebe um naipe para colocar na carta
     */
    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    /**
     *
     * @return numero - numero da carta criada
     */
    public String getNumero() {
        return numero;
    }

    /**
     *
     * @param numero - recebe um numero para colocar na carta
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return id - id da carta criada
     */
    public int getIdentificador() {
        return id;
    }

    /**
     *
     * @param id - recebe o id para colocar na carta
     */
    public void setIdentificador(int id) {
        this.id = id;
    }

    /**
     * Construtor da classe Carta
     *
     * @param naipe
     * @param numero
     * @param id
     */
    public Carta(String naipe, String numero, int id) {
        this.naipe = naipe;
        this.numero = numero;
        this.id = id;
    }

    @Override
    public String toString() {
        return numero + " " + naipe;
    }

}
