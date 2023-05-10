//Integrantes:
//Lucas Henrique Nogueira - 202265515B
//Breno Fernandes Brazilino - 202265500B
//Breno Montanha - 202265513B
//Pedro Henrique de Souza Rodrigues - 202165508B

package trabalhofinal_oo.bola_pula_pula;

import java.io.IOException;
import java.util.Scanner;

public class Telas_terminal {

    public static void Menu_Inicial() {
        Scanner teclado = new Scanner(System.in);
        int escolha;
        do {
            clean();
            System.out.println("\t\t\t\tBola pula pula\n");
            System.out.println("\t1-Jogar\n\t2-Ranking\n\t3-Regras\n\t4-Creditos\n\t5-sair");
            escolha = teclado.nextInt();
            teclado.nextLine();
            switch (escolha) {
                case 1:
                    Jogo jogo = new Jogo();
                    jogo.start();
                    break;
                case 2:
                    Ranking();
                    break;
                case 3:
                    Regras();
                    break;
                case 4:
                    Creditos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Valor inserido não corresponde as opções, tente outro");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
            }
        } while (escolha != 5);
        teclado.close();
    }

    public static void clean() {
        System.out.println("\033[H\033[2J");
        System.out.println("\033[H\033[2J");
        System.out.println("\033[H\033[2J");
        System.out.println("\033[H\033[2J");
    }

    private static void Ranking() {
        clean();
        System.out.println("\t\tRanking");
        System.out.println("");
        System.out.println("        Player\t\tPontos");
        System.out.println("\n\n");
        System.out.println("     Em breve uma implementacao em interface GUI");
        System.out.println("\n\n");
        System.out.println("\nPara voltar, presione o Enter");
        try {
            System.in.read();
        } catch (IOException e) {
        }

    }

    private static void Regras() {
        clean();
        System.out.println("\t\t\t\tRegras\n");
        System.out.println("\tVocê controla uma barra que pode andar lateralmente");
        System.out.println("\tO objetivo é quebrar os blocos que são gerados de tempos em tempos no topo do tabuleiro");
        System.out.println("\tVocê tem 3 vidas, que são reduzidas quando o tabuleiro não possui mais nenhuma bolinha");
        System.out.println(
                "A cada bloco quebrado, sua pontuação total será acrescida e ao final das 3 vidas, será inserida no Ranking");
        System.out.println("\nPara voltar, presione o Enter");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

    private static void Creditos() {
        clean();
        System.out.println("\t\t\t Créditos: ");
        System.out.println("\n\t Obrigado por jogar!!");
        System.out.println("\t este é um trabalho de Orientação a Objetos ");
        System.out.println("\t realizado por Breno Fernandes, Breno Montanha, Lucas Henrique e Pedro Henrique");
        System.out.println("\t Esperamos que tenha gostado do jogo... ");
        System.out.println("\nPara voltar, presione o Enter");
        try {
            System.in.read();
        } catch (IOException e) {
        }
    }

}
