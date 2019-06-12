package src.apresentacao;

import src.negocio.LeitorArquivo;
import src.negocio.Liga;

import java.io.IOException;
import javax.swing.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		
		//Jogo test = new Jogo();
		LeitorArquivo a = new LeitorArquivo();
		try {
			a.inserirLigaBanco("ligas/liga2011.txt");

		} catch (IOException e) {
			e.printStackTrace();
		}



		JFrame frame = new JFrame("UFC");
		frame.setContentPane(new TelaPrincipalGUI().telaPrincipalView);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);


		//test.start();
	}

}
