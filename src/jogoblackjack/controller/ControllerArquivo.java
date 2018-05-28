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
            
            escritor.println(jogador.getUser() + " " + jogador.getSenha());  
            
            escritor.flush();            
            escritor.close();
            //arquivo.flush();
            arquivo.close();
            
        }
        catch(Exception e){
            System.out.println("Erro ao escrever arquivo!");
            e.getMessage();            
            System.out.println(e);
            e.printStackTrace();
            System.out.println(e);
        } 
    }
    
    public LinkedList reader(){
        Jogador jogador;
        
        try{             
            File arq = new File("jogadoresCadastrados.txt");             
            String user, senha;
            Scanner scan = new Scanner(new FileReader(arq)).useDelimiter(" |\n");
            
            while(scan.hasNext()){
                user = scan.next();
                senha = scan.next();

                System.out.println(user + " " + senha);
                
                jogador = new Jogador(user, senha);
                jogadoresCadastrados.addLast(jogador);                
            } 
            scan.close();
        }
        catch(Exception e){
            System.out.println("Erro ao ler arquivo!");
            e.getMessage();            
            System.out.println(e);
            e.printStackTrace();
            System.out.println(e);
        }
        return jogadoresCadastrados; 
    }
}
