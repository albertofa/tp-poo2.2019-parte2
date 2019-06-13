package src.apresentacao;

import src.negocio.LeitorArquivo;
import src.negocio.LinkBancoDados;
import src.persistencia.ViewNumVitoriaPaisDAO;
import src.persistencia.ViewResumoRoundsDAO;
import src.persistencia.ViewVencedoresLutasDAO;

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
    LinkBancoDados link = new LinkBancoDados();

    public TelaPrincipalGUI(){

        ArrayList<String> lista = TelaPrincipal.listarArquivos();
        for (int i = 0;i<lista.size();i++){
            arquivoListBox.addItem(lista.get(i));
        }
        relatoriosListBox.addItem("Lutadores vencedores de cada luta");
        relatoriosListBox.addItem("Pontos ganhos para cada jogador em cada luta");
        relatoriosListBox.addItem("Número de vitórias por país");


        enviarButton.addActionListener(new EnviarBancoButtonAction());
        EmitirButton.addActionListener(new EmitirButtonAction());
    }


    public class EnviarBancoButtonAction implements ActionListener{

        LeitorArquivo leitor = new LeitorArquivo();
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                leitor.inserirArquivoBanco(String.valueOf(arquivoListBox.getSelectedItem()));
                fieldLogs.setText("Arquivo "+String.valueOf(arquivoListBox.getSelectedItem())+" inserido no banco");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public class EmitirButtonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if("Lutadores vencedores de cada luta".equals(relatoriosListBox.getSelectedItem())){
                link.inserirResultadoLutaBanco();
                textPane1.setText(ViewVencedoresLutasDAO.selecionarView());

            }else if("Pontos ganhos para cada jogador em cada luta".equals(relatoriosListBox.getSelectedItem())){
                textPane1.setText(ViewResumoRoundsDAO.selecionarViewString());
            }else if("Número de vitórias por país".equals(relatoriosListBox.getSelectedItem())){
                textPane1.setText(ViewNumVitoriaPaisDAO.selecionarView());
            }
        }

    }

}
