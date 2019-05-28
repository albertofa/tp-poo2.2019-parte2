package jogo.ufc;

import java.util.Scanner;
/*
 * Está Classe contem todos os metodos para impressão e interacão de informacão ao usuario
 */
public class Informacoes {


    public static void printResultadoLuta(Jogador player, Npc maquina){
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Relatorio  luta: "+player.getNome()+" VS "+maquina.getNome());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(player.getNome()+" vida restante: "+player.getHp());
        System.out.println(maquina.getNome()+" vida restante: "+maquina.getHp());
        if(player.getHp() < maquina.getHp()){
            System.out.println(maquina.getNome()+" Ganhou a luta");
            System.out.println("");
            System.out.println("FIM DE LUTA");
            System.out.println("Total de vitorias adquiridas: "+player.getNumeroWins());
        }else{
            System.out.println(player.getNome()+" Ganhou a luta");
            System.out.println();
            System.out.println("(Para comprar poderes entre com [1])  --  (Para prosseguir para proxima luta entre com [0])");
            Scanner input = new Scanner(System.in);
            if(input.nextInt() == 1){
                Informacoes.printCompraPoderes(player);
            }else{

            }

        }
    }

    public static void printCompraPoderes(Jogador player){
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            System.out.println("Total de Pontos: " + player.getPontos());
            System.out.println("Poderes disponiveis para uso:");
            player.printPoderes();
            System.out.println();
            System.out.println("[1] - Jiu-Jitsu, valor = 1000");
            System.out.println("[2] - Muay thai, gvalor = 2000");
            System.out.println("[3] - Wrestling, valor = 3000");
            System.out.println("[4] - Karatê, valor = 4000");
            System.out.println("Entre com o numero do poder a ser comprado:");
            System.out.println("(Para sair entre com [0])");
            int input = scanner.nextInt();
            if(input == 0){
                flag = false;
            }else {
                player.comprarPoder(input);
            }
        }
    }
}
