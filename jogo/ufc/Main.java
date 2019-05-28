package jogo.ufc;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Jogo test = new Jogo();
		LeitorArquivo a = new LeitorArquivo();
		try {
			a.test();
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.start();
	}

}
