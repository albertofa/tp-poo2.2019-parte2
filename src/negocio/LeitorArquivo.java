package src.negocio;

import src.persistencia.*;

import java.io.*;

public class LeitorArquivo {


    private File file;

    private int getAnobyPath(String path){

        return Integer.parseInt(path.substring(10,14));
    }

    //Esse metodo recebe uma String com o caminho do  arquivo contendo a liga e insere seu conteudo no banco
    public void inserirArquivoBanco(String path) throws IOException {

        LinkBancoDados link = new LinkBancoDados();
        file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int controle = 0;

        Liga liga = new Liga();
        liga.setAnoLiga(getAnobyPath(path));
        Luta luta = new Luta();
        Round round;
        Acao acoes;
        Lutador lutador;

        link.inserirLigaBanco(liga);
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] splitted = linha.split(";");

            if(Integer.parseInt(splitted[2]) != controle){

                luta.setIdLuta(Integer.parseInt(splitted[2]));
                LutaDAO.inserir(luta,liga.getAnoLiga());
                controle = Integer.parseInt(splitted[2]);
            }

            round = new Round();
            round.setIdRound(Integer.parseInt(splitted[1]));

            acoes = new Acao(Integer.parseInt(splitted[8]), Integer.parseInt(splitted[9]),Integer.parseInt(splitted[10]),Integer.parseInt(splitted[11]),Integer.parseInt(splitted[7]));
            lutador = new Lutador(splitted[3],splitted[4],splitted[5],splitted[6],acoes,Integer.parseInt(splitted[12]));
            round.setLutador1(lutador);

            acoes = new Acao(Integer.parseInt(splitted[18]), Integer.parseInt(splitted[19]),Integer.parseInt(splitted[20]),Integer.parseInt(splitted[21]),Integer.parseInt(splitted[17]));
            lutador = new Lutador(splitted[13],splitted[14],splitted[15],splitted[16],acoes,Integer.parseInt(splitted[22]));
            round.setLutador2(lutador);

            link.inserirRoundBanco(round,liga.getAnoLiga(),luta.getIdLuta());
            link.inserirResultadosBanco(round,liga.getAnoLiga(),luta.getIdLuta());
        }



    }
}

