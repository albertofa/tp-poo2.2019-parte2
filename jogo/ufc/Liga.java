package jogo.ufc;

import java.util.*;

/*Classe Liga, contem uma array com 10 nomes. Cada vez que um objeto é instanciado é
  selecionado 5 nomes aleatorios e atribuido a 10 lutadores*/
public class Liga {

    private ArrayList<Luta> lutas;


    public Liga() {
        lutas = new ArrayList<Luta>();

    }

    public Luta getLuta(int index){
        return this.lutas.get(index);
    }

    public void addLuta(Luta luta){
        this.lutas.add(luta);
    }




}
