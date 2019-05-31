package jogo.ufc;

import java.io.*;

public class LeitorArquivo {

    private File file;

    public Liga getLigaFromFile(String filePath){

        Liga liga = new Liga();
        return liga;
    }

    public void test() throws IOException {

        this.file = new File("ligas/liga2010.txt");
        Round round = new Round();
        Acao acoes;
        Lutador lutador;
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] splitted = linha.split(";");


            System.out.println("id luta:"+splitted[2]);

            acoes = new Acao(Integer.parseInt(splitted[8]), Integer.parseInt(splitted[9]),Integer.parseInt(splitted[10]),Integer.parseInt(splitted[11]),Integer.parseInt(splitted[7]));
            lutador = new Lutador(splitted[3],splitted[4],splitted[5],splitted[6],acoes,Integer.parseInt(splitted[12]));
            round.setLutador1(lutador);

            acoes = new Acao(Integer.parseInt(splitted[18]), Integer.parseInt(splitted[19]),Integer.parseInt(splitted[20]),Integer.parseInt(splitted[21]),Integer.parseInt(splitted[17]));
            lutador = new Lutador(splitted[13],splitted[14],splitted[15],splitted[16],acoes,Integer.parseInt(splitted[22]));
            round.setLutador2(lutador);



        }
    }
}

