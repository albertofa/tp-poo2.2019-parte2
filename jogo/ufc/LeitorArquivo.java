package jogo.ufc;

import java.io.*;

public class LeitorArquivo {

    private File file;


    public Liga getLigaByFile(String path) throws IOException {

        this.file = new File(path);
        Liga liga = new Liga();
        Luta luta = new Luta();
        Round round = new Round();
        Acao acoes;
        Lutador lutador;
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int controle = 0;
        String linha;
        while ((linha = reader.readLine()) != null) {

            String[] splitted = linha.split(";");

            acoes = new Acao(Integer.parseInt(splitted[8]), Integer.parseInt(splitted[9]),Integer.parseInt(splitted[10]),Integer.parseInt(splitted[11]),Integer.parseInt(splitted[7]));
            lutador = new Lutador(splitted[3],splitted[4],splitted[5],splitted[6],acoes,Integer.parseInt(splitted[12]));
            round.setLutador1(lutador);

            acoes = new Acao(Integer.parseInt(splitted[18]), Integer.parseInt(splitted[19]),Integer.parseInt(splitted[20]),Integer.parseInt(splitted[21]),Integer.parseInt(splitted[17]));
            lutador = new Lutador(splitted[13],splitted[14],splitted[15],splitted[16],acoes,Integer.parseInt(splitted[22]));
            round.setLutador2(lutador);
            controle++;
            luta.addRound(round);

            if(controle == 19){
                liga.addLuta(luta);
                luta = new Luta();
                controle = 0;
            }


        }

        return liga;
    }
}

