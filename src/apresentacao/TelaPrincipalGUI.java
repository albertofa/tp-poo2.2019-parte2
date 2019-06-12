package src.apresentacao;

import src.negocio.LeitorArquivo;
import src.negocio.relatorios.ResultadoLuta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TelaPrincipalGUI {

    protected JPanel telaPrincipalView;
    protected JComboBox arquivoListBox;
    protected JButton enviarButton;
    protected JTextPane textPane1;
    private JLabel fieldLogs;
    private JComboBox relatoriosListBox;
    private JButton EmitirButton;

    public TelaPrincipalGUI(){

        ArrayList<String> lista = TelaPrincipal.listarArquivos();
        for (int i = 0;i<lista.size();i++){
            arquivoListBox.addItem(lista.get(i));
        }
        relatoriosListBox.addItem("Lutadores vencedores de cada luta");
        enviarButton.addActionListener(new EnviarBancoButton());
    }

    public class EnviarBancoButton implements ActionListener{

        LeitorArquivo leitor = new LeitorArquivo();
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                leitor.inserirLigaBanco(String.valueOf(arquivoListBox.getSelectedItem()));
                ResultadoLuta r = new ResultadoLuta();
                r.inserirVencedoresLutasBanco();
                fieldLogs.setText("Arquivo "+String.valueOf(arquivoListBox.getSelectedItem())+"inserido no banco");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
