package jogo.ufc;

import java.util.*;

/*Classe Liga, contem uma array com 10 nomes. Cada vez que um objeto é instanciado é
  selecionado 5 nomes aleatorios e atribuido a 10 lutadores*/
public class Liga {

    private ArrayList<Npc> lutadores;
    private List<String> nomes;

    public Liga() {
        nomes = new ArrayList<>(Arrays.asList("Yoel Romero", "Luke Rockhold", "Jacare Souza", "Kelvin Gastelum","Cesar Arzamendia","Kelly Faszholz","Tiago Trator","Paulo Henrique Costa","Dmitriy Sosnovskiy","Andrei Arlovski"));
        lutadores = new ArrayList<Npc>();
        Collections.shuffle(nomes);

        for (int i = 0; i < 5; i++){
            lutadores.add(new Npc());
            lutadores.get(i).action.criarAcoes();
            lutadores.get(i).setNome(nomes.get(i));
        }

    }

    public Npc getLutador(int i) {
        return lutadores.get(i);
    }



}
