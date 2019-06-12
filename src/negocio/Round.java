package src.negocio;

/* Classe que representa um embate entre 2 lutadores, em relação ao
   arquivo .txt de ligas, cada instancia do objeto Round representa uma linha */
public class Round {

    private int idRound;
    private Lutador lutador1;
    private Lutador lutador2;

    private int pontosLutador1 = 0;
    private int pontosLutador2 = 0;

    //Retorna o Lutador que ficou com mais pontos no Round
    public Lutador getRoundResult(){
        if(lutador1.getAcoes().getPoder() == 1 || lutador2.getAcoes().getPoder() == 1){
            setPontosUsoPoder();
        }else if(lutador1.getAcoes().getDefesa() == 1 || lutador2.getAcoes().getDefesa() == 1){
            setPontosUsoDefesa();
        }else{
            setPontosUsoAtaque();
        }

        if(pontosLutador1 > pontosLutador2){
            return lutador1;
        }else{
            return lutador2;
        }
    }

    //Calcula qual dos jogadores ganhou o embate com o uso do Poder
    private void setPontosUsoPoder(){
        if(lutador2.getAcoes().getPoder() == 1 && lutador1.getAcoes().getPoder() == 1) {
            setPontosMaiorHabilidade();
        }else if(lutador1.getAcoes().getPoder() == 1){
            pontosLutador1++;
        }else{
            pontosLutador2++;
        }
    }

    //Calcula qual dos jogadores ganhou o embate com o uso do Ataque
    private void setPontosUsoAtaque(){
        if(lutador1.getAcoes().getChute() == 1 || lutador2.getAcoes().getChute() == 1){
            if(lutador1.getAcoes().getChute() == 1 && lutador2.getAcoes().getChute() == 1){
                setPontosMaiorHabilidade();
            }else if(lutador1.getAcoes().getChute() == 1){
                pontosLutador1++;
            }else{
                pontosLutador2++;
            }
        }else{
            if(lutador1.getAcoes().getSoco() == 1 && lutador2.getAcoes().getSoco() == 1){
                setPontosMaiorHabilidade();
            }else if(lutador1.getAcoes().getSoco() == 1){
                pontosLutador1++;
            }else{
                pontosLutador2++;
            }
        }
    }

    //Calcula qual dos jogadores ganhou o embate com o uso do Defesa
    private void setPontosUsoDefesa(){
        if(lutador2.getAcoes().getDefesa() == 1 && lutador1.getAcoes().getDefesa() == 1) {
            setPontosMaiorHabilidade();
        }
    }

    //Calcula quem ganhou o embate com base em qual lutador possui maior habilidade
    private void setPontosMaiorHabilidade(){
        if (lutador1.getModalidade().forca == lutador2.getModalidade().forca) {
            pontosLutador1++;
            pontosLutador2++;
        } else if (lutador1.getModalidade().forca > lutador2.getModalidade().forca) {
            pontosLutador1++;
        } else {
            pontosLutador2++;
        }
    }



    //Getters e Setters

    public int getIdRound() {
        return this.idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public void setLutador1(Lutador lutador){
        this.lutador1 = lutador;
    }

    public void setLutador2(Lutador lutador){
        this.lutador2 = lutador;
    }

    public Lutador getlutador1(){
        return this.lutador1;
    }

    public Lutador getlutador2(){
        return this.lutador2;
    }


    public int getPontosLutador1() {
        return pontosLutador1;
    }

    public void setPontosLutador1(int pontosLutador1) {
        this.pontosLutador1 = pontosLutador1;
    }

    public int getPontosLutador2() {
        return pontosLutador2;
    }

    public void setPontosLutador2(int pontosLutador2) {
        this.pontosLutador2 = pontosLutador2;
    }



}
