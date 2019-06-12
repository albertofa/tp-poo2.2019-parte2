package src.negocio;

import java.util.ArrayList;

public class Luta {

    private int idLuta;
    public ArrayList<Round> rounds = new ArrayList<Round>();

    public Lutador getLutador1(){
        return rounds.get(0).getlutador1();
    }
    public Round getRound(int index){
        return rounds.get(index);
    }
    public void addRound(Round round){
        rounds.add(round);
    }

    public int getIdLuta() {
        return idLuta;
    }

    public void setIdLuta(int idLuta) {
        this.idLuta = idLuta;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public int size(){
        return rounds.size();
    }


}
