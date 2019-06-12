package src.apresentacao;

import java.io.IOException;
import javax.swing.*;

public class Main {

	public static void main(String[] args) throws IOException{




		JFrame frame = new JFrame("UFC");
		TelaPrincipalGUI lul = new TelaPrincipalGUI();
		frame.setContentPane(lul.telaPrincipalView);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);







		//test.start();
	}

}
