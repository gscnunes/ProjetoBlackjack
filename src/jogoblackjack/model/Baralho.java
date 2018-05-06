package jogoblackjack.model;

public class Baralho { //NÃO ESQUECER DOS GETTERS E SETTERS!!!
    Carta[] cartas;
    
    public Baralho(){
        Carta[] cartas = new Carta[52];       
        
    }
    
    public Carta[] inicializaBaralho(Carta[] cartas){
        
        return cartas;
    }      


    
    private class Carta{
        private int id;
        private String naipe;
        private int valor; 
        
        public Carta(int id, String naipe, int valor){
            this.id = id;
            this.naipe = naipe;
            this.valor = valor;
        }        
    }
    
}
