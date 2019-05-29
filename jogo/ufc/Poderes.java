package jogo.ufc;

import java.util.Random;
import java.util.Scanner;

public class Poderes {

    // atributos dos poderes, o inteiro representa quantas vezes o poder pode ser utilizado
    private Boxe boxe;
    private JiuJitsu jiuJitsu;
    private MuayThai muayThai;
    private Wrestling wrestling;
    private Karate karate;
    private int pontos;

    public Poderes() {
        this.boxe = new Boxe();
        this.jiuJitsu = new JiuJitsu();
        this.muayThai = new MuayThai();
        this.wrestling = new Wrestling();
        this.karate = new Karate();
        this.pontos = 0;
    }

    /* Este método recebe um inteiro representando qual poder será comprado,
     * faz a verificação se o quantidade de pontos é suficiente e retorna ‘true’ caso a compra foi bem sucedida. */
    public boolean comprarPoder(int input){

        if( input == 1 && pontos >= 1000){
            jiuJitsu.setUsos(jiuJitsu.getUsos()+1);
            pontos = pontos-1000;
            return true;
        }else if(input == 2 && pontos >= 2000){
            muayThai.setUsos(muayThai.getUsos()+1);
            pontos = pontos-2000;
            return true;
        }else if(input == 3 && pontos >= 3000){
            wrestling.setUsos(wrestling.getUsos()+1);
            pontos = pontos-3000;
            return true;
        }else if(input == 4 && pontos >= 4000){
            karate.setUsos(karate.getUsos()+1);
            pontos = pontos-4000;
            return true;
        }else {
            return false;
        }

    }


    /* Este método recebe um int representado qual poder será utilizado e retorna o dano do poder selecionado,
     * caso o inteiro representando o poder seja inválido ele irá retornar -1
     * 0 = boxe | 1 = jiuJitsu | 2 = muayThai | 3 = Wrestling | 4 = Karate */
    public double usarPoder(int i){
        if(i == 0){
            return boxe.getDano();
        }else if( i == 1 && jiuJitsu.getUsos() >= 1){
            jiuJitsu.setUsos(jiuJitsu.getUsos()-1);
            return jiuJitsu.getDano();
        }else if(i == 2 && muayThai.getUsos() >= 1){
            muayThai.setUsos(muayThai.getUsos()-1);
            return muayThai.getDano();
        }else if(i == 3 && wrestling.getUsos() >= 1){
            wrestling.setUsos(wrestling.getUsos()-1);
            return wrestling.getDano();
        }else if(i == 4 && karate.getUsos() >= 1) {
            karate.setUsos(karate.getUsos()-1);
            return karate.getDano();
        }else{
            return -1;
        }
    }

    /* Metodo que irá selecionar aleatoriamente qual poder será utilizado,
     * retorna o valor a ser usado no metodo usarPoder() */
    public int escolhePoderAletatoriamente(){
        if( jiuJitsu.getUsos() >= 1 || muayThai.getUsos() >= 1 || wrestling.getUsos() >= 1 || karate.getUsos() >= 1){
            Random sorteio = new Random();
            while(true){
                int rand = sorteio.nextInt(5);
                if (rand == 0) {
                    return rand;
                } else if (rand == 1 && jiuJitsu.getUsos() >= 1) {
                    return rand;
                } else if (rand == 2 && muayThai.getUsos() >= 1) {
                    return rand;
                } else if (rand == 3 && wrestling.getUsos() >= 1) {
                    return rand;
                } else if (rand == 4 && karate.getUsos() >= 1) {
                    return rand;
                }
            }
        } else {
            return 0;
        }
    }

    /* Este metodo retorna um inteiro representando a quantidade de poderes
     * unicos que possuem uso> maioe que 0 */
    public int contaQuantPoderesUnicos(){
        int contador = 0;
        if(jiuJitsu.getUsos() > 0){
            contador++;
        }else if(muayThai.getUsos() > 0){
            contador++;
        }else if(wrestling.getUsos() > 0){
            contador++;
        }else if(karate.getUsos() > 0){
            contador++;
        }

        return contador;
    }
    //Metodo para mostrar na tela a quantidade de poderes para uso
    public void printPoderes(){
        System.out.println("JiuJitsu: "+jiuJitsu.getUsos()+" usos");
        System.out.println("MuayThai: "+muayThai.getUsos()+" usos");
        System.out.println("Wrestling: "+wrestling.getUsos()+" usos");
        System.out.println("Karate: "+karate.getUsos()+" usos");
    }



    //Abaixo somente Setters e Getters
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPontos() {
        return pontos;
    }

    public int jiujitsuGetUsos(){
        return jiuJitsu.getUsos();
    }

    public void jiujitsuSetUsos(int usos){
        jiuJitsu.setUsos(usos);
    }

    public int muaythaiGetUsos(){
        return muayThai.getUsos();
    }

    public void muaythaiSetUsos(int usos){
        muayThai.setUsos(usos);
    }

    public int wrestlingGetUsos(){
        return wrestling.getUsos();
    }

    public void wrestlingSetUsos(int usos){
        wrestling.setUsos(usos);
    }

    public int karateGetUsos(){
        return karate.getUsos();
    }

    public void karateSetUsos(int usos){
        karate.setUsos(usos);
    }


}
