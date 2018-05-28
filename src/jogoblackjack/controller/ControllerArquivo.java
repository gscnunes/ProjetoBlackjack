package jogoblackjack.controller;

import java.io.*;
import java.util.Scanner;
import jogoblackjack.model.*;
import jogoblackjack.util.LinkedList;

public class ControllerArquivo {
    
    private LinkedList jogadoresCadastrados = new LinkedList();
    
    public void writer(Jogador jogador){
        try{
            FileWriter arquivo = new FileWriter("jogadoresCadastrados.txt", true);
            BufferedWriter buffer = new BufferedWriter(arquivo);
            PrintWriter escritor = new PrintWriter(arquivo);
            
            escritor.println(jogador.getUser() + " " + jogador.getSenha() + " " +jogador.getPontTotal() + " " + jogador.getJogosVencidos());  
            
            escritor.flush();            
            escritor.close();            
            arquivo.close();
            
        }
        catch(Exception e){
            System.out.println("Erro ao escrever arquivo!");            
        } 
    }
    
    public LinkedList reader(){
        Jogador jogador;
        
        try{             
            File arq = new File("jogadoresCadastrados.txt");             
            String user, senha;
            int pontTotal, jogosVencidos;
            
            Scanner scan = new Scanner(new FileReader(arq)).useDelimiter(" |\n");
            
            while(scan.hasNext()){
                user = scan.next();
                senha = scan.next();
                pontTotal = Integer.parseInt(scan.next());
                jogosVencidos = Integer.parseInt(scan.next());
                
                jogador = new Jogador(user, senha);
                jogador.setPontTotal(pontTotal);
                jogador.setJogosVencidos(jogosVencidos); 
                
                jogadoresCadastrados.addLast(jogador);                
            } 
            scan.close();
        }
        catch(Exception e){
            System.out.println("Erro ao ler arquivo!");            
        }
        return jogadoresCadastrados; 
    }
}
