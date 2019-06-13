package src.apresentacao;

import java.io.File;
import java.util.ArrayList;

public class TelaPrincipal{

    public static ArrayList<String> listarArquivos(){

        File folder = new File("ligas/");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> lista = new ArrayList<String>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                lista.add("ligas/"+listOfFiles[i].getName());
            }

        }

         return lista;

    }
}
