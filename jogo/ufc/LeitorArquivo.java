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

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] splitted = linha.split(";");

            System.out.println("id luta:"+splitted[2]);
            System.out.println("nome:"+splitted[3]);
            System.out.println("categoria:"+splitted[4]);
            System.out.println("pais:"+splitted[5]);
        }
    }
}

