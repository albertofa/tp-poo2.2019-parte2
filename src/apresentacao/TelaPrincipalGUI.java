package src.apresentacao;

import src.negocio.bd.LeitorArquivo;
import src.negocio.bd.LinkBancoDados;
import src.persistencia.views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Possui todos os componententes da interface grafica
 * e metodos para interagis com esses componentes
 */
public class TelaPrincipalGUI {

    protected JPanel telaPrincipalView;
    protected JComboBox arquivoListBox;
    protected JButton enviarButton;
    protected JTextPane textPane1;
    private JLabel fieldLogs;
    private JComboBox relatoriosListBox;
    private JButton EmitirButton;
    LinkBancoDados link = new LinkBancoDados();

    /**
     * Construtor
     */
    public TelaPrincipalGUI(){

        ArrayList<String> lista = listarArquivos();
        for (int i = 0;i<lista.size();i++){
            arquivoListBox.addItem(lista.get(i));
        }
        relatoriosListBox.addItem("Lutadores vencedores de cada luta");
        relatoriosListBox.addItem("Pontos ganhos para cada jogador em cada luta");
        relatoriosListBox.addItem("Número de vitórias por país");
        relatoriosListBox.addItem("Número de vitórias por jogador");
        relatoriosListBox.addItem("Maior vencedor por categoria");
        relatoriosListBox.addItem("Número de lutas computadas no total");
        relatoriosListBox.addItem("Todos lutadores Vencedores por categoria");


        enviarButton.addActionListener(new EnviarBancoButtonAction());
        EmitirButton.addActionListener(new EmitirButtonAction());
    }


    /**
     * Metodo que é acionado quando o componente EnviarBancoButton possui uma interação
     */
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

    /**
     * Metodo que é acionado quando o componente EmitirButton possui uma interação
     */
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
            }else if("Número de vitórias por jogador".equals(relatoriosListBox.getSelectedItem())){
                textPane1.setText(ViewVitoriasJogadorDAO.selecionarView());
            }else if("Maior vencedor por categoria".equals(relatoriosListBox.getSelectedItem())){
                textPane1.setText(ViewVencedorCategoriaDAO.selecionarView());
            }else if("Número de lutas computadas no total".equals(relatoriosListBox.getSelectedItem())){
                textPane1.setText(ViewTotalLutasDAO.selecionarView());
            }else if("Todos lutadores Vencedores por categoria".equals(relatoriosListBox.getSelectedItem())){
                textPane1.setText(ViewLutadoresVencedoresAllDAO.selecionarView());
            }
        }

    }

    /**
     * Metodo retorna todos os arquivos dentro de um diretorio
     * @return Retorna uma ArrayList do tipo String
     */
    public ArrayList<String> listarArquivos(){

        File folder = new File("ligas/");
        File[] listaDeArquivos = folder.listFiles();
        ArrayList<String> lista = new ArrayList<String>();

        for (int i = 0; i < listaDeArquivos.length; i++) {
            if (listaDeArquivos[i].isFile()) {
                lista.add("ligas/"+listaDeArquivos[i].getName());
            }

        }

        return lista;

    }

}
