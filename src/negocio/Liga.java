package src.negocio;

import java.util.*;

/**
 * Representa uma liga, cada liga é composta por N lutas e um anoLiga
 *
 * @author José Alberto Fernandes
 */
public class Liga {

    private int anoLiga;
    private ArrayList<Luta> lutas;


    /**
     * Construtor
     */
    public Liga() {
        lutas = new ArrayList<Luta>();

    }


    //Getters and Setters
    public int size(){
        return lutas.size();
    }

    public int getAnoLiga() {
        return anoLiga;
    }

    public void setAnoLiga(int anoLiga) {
        this.anoLiga = anoLiga;
    }

    public Luta getLuta(int index){
        return this.lutas.get(index);
    }

    public void addLuta(Luta luta){
        this.lutas.add(luta);
    }


}
