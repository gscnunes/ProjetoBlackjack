package jogoblackjack.model;

public class Carta {

    private String naipe;
    private String numero;
    private int id;

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIdentificador() {
        return id;
    }

    public void setIdentificador(int id) {
        this.id = id;
    }

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