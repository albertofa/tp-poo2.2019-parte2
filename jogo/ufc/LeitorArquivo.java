package jogo.ufc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {

    FileReader fr;

    {
        try {
            fr = new FileReader("ligas/liga2010.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void test() throws IOException {
        int i;
        while ((i=fr.read()) != -1) {
            System.out.print((char) i);
        }
    }
}
