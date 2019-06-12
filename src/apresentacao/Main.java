package src.apresentacao;

import src.negocio.LeitorArquivo;
import src.negocio.Liga;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		//Jogo test = new Jogo();
		LeitorArquivo a = new LeitorArquivo();
		try {
			a.inserirLigaBanco("ligas/liga2011.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}
		//test.start();
	}

}
