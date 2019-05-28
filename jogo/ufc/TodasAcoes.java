package jogo.ufc;

import java.util.ArrayList;



public class TodasAcoes {

	
	ArrayList<Acao> acoes= new ArrayList<Acao>();
	
	public void criarAcoes(){
		for (int i = 0; i < 1000; i++) {
			acoes.add(new Acao());
			
		}
		
	}
	

}
