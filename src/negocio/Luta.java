package src.negocio;

import java.util.ArrayList;

/**
 * Reprenta uma luta, cada luta é composta por N rounds e um idLuta
 *
 * @author José Alberto Fernandes
 */
public class Luta {

    private int idLuta;
    private ArrayList<Round> rounds = new ArrayList<Round>();


    //Getters e Setters
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
