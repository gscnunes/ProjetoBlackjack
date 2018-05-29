package jogoblackjack.model;

public class Carta {

    private String naipe;
    private String numero;
    private int id;

    public Carta(String naipe, String numero, int id) {
        this.naipe = naipe;
        this.numero = numero;
        this.id = id;
    }

    public String getNaipe() {
        return naipe;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public int getIdentificador() {
        return id;
    }
    
    @Override
    public String toString() {
        return numero + " " + naipe;
    }
}
