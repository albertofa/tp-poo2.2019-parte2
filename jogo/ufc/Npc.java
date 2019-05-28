package jogo.ufc;

import java.util.Random;
/*
 * Classe reprensanto uma NPC (Non playable character), sendo a maquina do jogo
 */
public class Npc extends Lutador {

    /* Diferente do metodo ComprarPoder da Classe Poderes, essa metodo atribui determinada quantidadde de pontos dependendo da entrada
     * e aleatoriamente faz as compras dos poderes ate os pontos acabarem */
    @Override
    public boolean comprarPoder(int input) {
        Random sorteio = new Random();
        if(input == 0){
            return true;
        }else if(input == 1){
            setPontos(2000);

        }else if(input == 2){
            setPontos(3000);

        }else if(input == 3){
            setPontos(5000);

        }else{
            setPontos(10000);
        }

        while(getPontos() >= 1000){
            int rand = sorteio.nextInt(5);
            if(  rand == 1 && getPontos() >= 1000){
                jiujitsuSetUsos(jiujitsuGetUsos()+1);
                setPontos(getPontos()-1000);
            }else if(rand == 2 && getPontos() >= 2000){
                muaythaiSetUsos(muaythaiGetUsos()+1);
                setPontos(getPontos()-2000);
            }else if(rand == 3 && getPontos() >= 3000){
                wrestlingSetUsos(wrestlingGetUsos()+1);
                setPontos(getPontos()-3000);
            }else if(rand == 4 && getPontos() >= 4000){
                karateSetUsos(karateGetUsos()+1);
                setPontos(getPontos()-4000);
            }
        }

        return true;
    }
}
