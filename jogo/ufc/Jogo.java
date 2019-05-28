package jogo.ufc;

import java.util.Scanner;

/* Classe que irá conter a execução do jogo, com seus lutadores e as regras de interação entre eles */
public class Jogo {

    private Jogador player;
    private Liga oponentes;

    public Jogo(){
        oponentes = new Liga();
    }

    public void constructPlayer(String nome){

        player = new Jogador();
        player.action.criarAcoes();
        player.setNome(nome);
        player.setHp(1050.00);

    }


    //Metodo com as regras da luta, ele recebe 2 lutadores e compara suas listas de golpes, atribuindo pontos e danos!
    public void luta( Jogador player, Npc maquina ){

        for( int i = 0; i < player.action.acoes.size(); i++) {
            if(maquina.getHp() <= 0 || player.getHp() <= 0) {    //Verifica se a maquina ou o player ja chegou a 0 de vida
                break;
            } else {
                if (player.action.acoes.get(i).poder == 1 || maquina.action.acoes.get(i).poder == 1) {   // Verifica se a maquina ou player usaram algum poder
                    if (player.action.acoes.get(i).poder == 1 && maquina.action.acoes.get(i).poder == 1) {
                        player.recebeDano(maquina.usarPoder(maquina.escolhePoderAletatoriamente()));
                        maquina.recebeDano(player.usarPoder(player.escolhePoderAletatoriamente()));
                        player.setPontos(player.getPontos()+75);
                    } else if (player.action.acoes.get(i).poder == 1) {
                        maquina.recebeDano(player.usarPoder(player.escolhePoderAletatoriamente()));
                        player.setPontos(player.getPontos()+75);
                    } else {
                        player.recebeDano(maquina.usarPoder(maquina.escolhePoderAletatoriamente()));
                    }

                } else if (player.action.acoes.get(i).defesa == 1 || maquina.action.acoes.get(i).defesa == 1) {  // Verifica se a maquina ou player a defesa


                } else if (player.action.acoes.get(i).ataque == 1 || maquina.action.acoes.get(i).ataque == 1) {  // Verifica se a maquina ou player usaram algum ataque
                    if(maquina.action.acoes.get(i).chute == 1 && maquina.action.acoes.get(i).chute == 1){
                        if(player.contaQuantPoderesUnicos() > maquina.contaQuantPoderesUnicos()){  //Verifica qual dos lutadores possuem mais habilidade
                            maquina.recebeDano(player.action.acoes.get(i).dano);
                            player.setPontos(player.getPontos()+25);
                        }else if(maquina.contaQuantPoderesUnicos() > player.contaQuantPoderesUnicos()){
                            player.recebeDano(maquina.action.acoes.get(i).dano);
                        }else{
                            maquina.recebeDano(player.action.acoes.get(i).dano);
                            player.recebeDano(maquina.action.acoes.get(i).dano);
                            player.setPontos(player.getPontos()+25);
                        }
                    }else if(player.action.acoes.get(i).soco == 1 && maquina.action.acoes.get(i).soco == 1){
                        if(player.contaQuantPoderesUnicos() > maquina.contaQuantPoderesUnicos()){  //Verifica qual dos lutadores possuem mais habilidade
                            maquina.recebeDano(player.action.acoes.get(i).dano);
                            player.setPontos(player.getPontos()+25);
                        }else if(maquina.contaQuantPoderesUnicos() > player.contaQuantPoderesUnicos()){
                            player.recebeDano(maquina.action.acoes.get(i).dano);
                        }else{
                            maquina.recebeDano(player.action.acoes.get(i).dano);
                            player.recebeDano(maquina.action.acoes.get(i).dano);
                            player.setPontos(player.getPontos()+25);
                        }

                    }else if(maquina.action.acoes.get(i).chute == 1){
                        player.recebeDano(maquina.action.acoes.get(i).dano);
                    }else{
                        maquina.recebeDano(player.action.acoes.get(i).dano);
                        player.setPontos(player.getPontos()+25);

                    }
                }
            }
        }

    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do seu lutador:");
        String input = scanner.nextLine();
        constructPlayer(input);
        for(int i = 0; i < 5; i++){
            oponentes.getLutador(i).comprarPoder(i);
            luta(this.player,oponentes.getLutador(i));
            Informacoes.printResultadoLuta(player,oponentes.getLutador(i));
            if(player.getHp() < oponentes.getLutador(i).getHp()){
                break;
            }else{
                player.setHp(1000.00);
                player.setNumeroWins(player.getNumeroWins()+1);
            }

        }


    }




}
