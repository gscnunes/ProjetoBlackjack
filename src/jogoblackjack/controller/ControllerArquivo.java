package jogoblackjack.controller;

import java.io.*;
import java.util.Scanner;
import jogoblackjack.model.*;
import jogoblackjack.util.LinkedList;

/**
 *
 * @author Daniel Alves e Gabriela dos Santos
 */
public class ControllerArquivo {

    private LinkedList jogadoresCadastrados = new LinkedList();

    /**
     * Escreve no arquivo de texto um novo jogador
     *
     * @param jogador - novo jogador
     */
    public void writer(Jogador jogador) {
        try {
            FileWriter arquivo = new FileWriter("jogadoresCadastrados.txt", true);
            BufferedWriter buffer = new BufferedWriter(arquivo);
            PrintWriter escritor = new PrintWriter(arquivo);

            escritor.println(jogador.getUser() + " " + jogador.getSenha() + " " + jogador.getPontTotal() + " " + jogador.getJogosVencidos());

            escritor.flush();
            escritor.close();
            arquivo.close();

        } catch (Exception e) {
            System.out.println("Erro ao escrever arquivo!");
        }
    }

    /**
     * Gera um novo arquivo de texto mostrando o placar dos jogadores
     *
     * @param jogador - jogador que irá ser adicionado no arquivo de texto
     */
    public void writerUpdate(Jogador jogador) {

        try {
            FileWriter arquivo = new FileWriter("placar.txt", true);
            BufferedWriter buffer = new BufferedWriter(arquivo);
            PrintWriter escritor = new PrintWriter(arquivo);

            escritor.println(jogador.getUser() + " " + jogador.getPontTotal() + " " + jogador.getJogosVencidos());

            escritor.flush();
            escritor.close();
            arquivo.close();

        } catch (Exception e) {
            System.out.println("Erro ao escrever arquivo!");
        }

    }

    /**
     * Ler o arquivo de texto com os jogadores salvos e salva eles no programa
     * para poderem ser utilizados
     *
     * @return jogadoresCadastrados - lista com os jogadores que estão salvos no
     * arquivo
     */
    public LinkedList reader() {
        Jogador jogador;

        try {
            File arq = new File("jogadoresCadastrados.txt");
            String user, senha;
            int pontTotal, jogosVencidos;

            Scanner scan = new Scanner(new FileReader(arq)).useDelimiter(" |\n");

            while (scan.hasNext()) {
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
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo!");
        }
        return jogadoresCadastrados;
    }

    /**
     * Método para deletar o placar anterior quando inicia uma nova partida
     */
    public void deletar() {
        File file = new File("placar.txt");
        file.delete();
    }

}
