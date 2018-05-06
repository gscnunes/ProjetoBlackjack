package jogoblackjack.model;


public class Jogador { //NÃO ESQUECER DOS GETTERS E SETTERS!!!
    private String user;
    private String senha;
    private int pontuacaoGeral;
    private int partidasGanhas;
    
    public Jogador(String user, String senha){
        this.user= user;
        this.senha = senha;
    }  
    
    private class MãoDeCarta{
        private int qtdCartas;
        private int valorDaMao;
    }
    
}
