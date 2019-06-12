package src.negocio;

import src.persistencia.*;

import java.io.*;

public class LeitorArquivo {


    private File file;

    private int getAnobyPath(String path){

        return Integer.parseInt(path.substring(10,14));
    }


    //Esse metodo recebe um objeto do tipo Round, calcula seus resultados e o insere no banco
    /*public void inserirResultadosBanco(Luta luta){


    }*/

    //Esse metodo recebe uma String com o caminho do  arquivo contendo a liga e insere seu conteudo no banco
    public void inserirLigaBanco(String path) throws IOException {

        this.file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int controle = 0;
        Liga liga = new Liga();
        Luta luta = new Luta();
        Round round = new Round();
        Acao acoes;
        Lutador lutador;

        liga.setAnoLiga(getAnobyPath(path));
        LigaDAO.inserir(liga);

        String linha;
        while ((linha = reader.readLine()) != null) {

            System.out.println("Linha arquivo puro: "+linha);
            String[] splitted = linha.split(";");

            if(Integer.parseInt(splitted[2]) != controle){

                luta.setIdLuta(Integer.parseInt(splitted[2]));
                LutaDAO.inserir(luta,liga.getAnoLiga());

                controle = Integer.parseInt(splitted[2]);

            }

            round.setIdRound(Integer.parseInt(splitted[1]));
            RoundDAO.inserir(round,luta.getIdLuta(),liga.getAnoLiga());

            acoes = new Acao(Integer.parseInt(splitted[8]), Integer.parseInt(splitted[9]),Integer.parseInt(splitted[10]),Integer.parseInt(splitted[11]),Integer.parseInt(splitted[7]));
            lutador = new Lutador(splitted[3],splitted[4],splitted[5],splitted[6],acoes,Integer.parseInt(splitted[12]));


            LutadorDAO.inserir(lutador);
            AcaoDAO.inserir(acoes,round.getIdRound(),liga.getAnoLiga(),luta.getIdLuta(),lutador.getNome());
            ModalidadeDAO.inserir(lutador.getModalidade(),round.getIdRound(),lutador.getNome(),luta.getIdLuta(),liga.getAnoLiga());

            acoes = new Acao(Integer.parseInt(splitted[18]), Integer.parseInt(splitted[19]),Integer.parseInt(splitted[20]),Integer.parseInt(splitted[21]),Integer.parseInt(splitted[17]));
            lutador = new Lutador(splitted[13],splitted[14],splitted[15],splitted[16],acoes,Integer.parseInt(splitted[22]));


            LutadorDAO.inserir(lutador);
            AcaoDAO.inserir(acoes,round.getIdRound(),liga.getAnoLiga(),luta.getIdLuta(),lutador.getNome());
            ModalidadeDAO.inserir(lutador.getModalidade(),round.getIdRound(),lutador.getNome(),luta.getIdLuta(),liga.getAnoLiga());


        }

    }
}

