package src.negocio;

import src.persistencia.*;

import java.io.*;

public class LeitorArquivo {

    int controle = 0;
    private File file;

    private int getAnobyPath(String path){

        return Integer.parseInt(path.substring(10,14));
    }


    public Liga getLigaByFile(String path) throws IOException {

        LutaDAO lutaDAO = new LutaDAO();
        RoundDAO roundDAO = new RoundDAO();
        LutadorDAO lutadorDAO = new LutadorDAO();
        AcaoDAO acaoDAO =  new AcaoDAO();
        ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
        this.file = new File(path);
        Liga liga = new Liga();
        LigaDAO ligaDAO = new LigaDAO();
        Luta luta = new Luta();
        Round round = new Round();
        Acao acoes;
        Lutador lutador;
        BufferedReader reader = new BufferedReader(new FileReader(file));


        liga.setAnoLiga(getAnobyPath(path));
        ligaDAO.inserir(liga);

        String linha;

        while ((linha = reader.readLine()) != null) {

            System.out.println("Linha arquivo puro: "+linha);
            String[] splitted = linha.split(";");

            if(Integer.parseInt(splitted[2]) != controle){

                luta.setIdLuta(Integer.parseInt(splitted[2]));
                lutaDAO.inserir(luta,liga.getAnoLiga());

                controle = Integer.parseInt(splitted[2]);

            }

            round.setIdRound(Integer.parseInt(splitted[1]));
            roundDAO.inserir(round,luta.getIdLuta(),liga.getAnoLiga());

            acoes = new Acao(Integer.parseInt(splitted[8]), Integer.parseInt(splitted[9]),Integer.parseInt(splitted[10]),Integer.parseInt(splitted[11]),Integer.parseInt(splitted[7]));
            lutador = new Lutador(splitted[3],splitted[4],splitted[5],splitted[6],acoes,Integer.parseInt(splitted[12]));

            lutadorDAO.inserir(lutador);
            acaoDAO.inserir(acoes,round.getIdRound(),liga.getAnoLiga(),luta.getIdLuta(),lutador.getNome());
            modalidadeDAO.inserir(lutador.getModalidade(),round.getIdRound(),lutador.getNome(),luta.getIdLuta(),liga.getAnoLiga());

            acoes = new Acao(Integer.parseInt(splitted[18]), Integer.parseInt(splitted[19]),Integer.parseInt(splitted[20]),Integer.parseInt(splitted[21]),Integer.parseInt(splitted[17]));
            lutador = new Lutador(splitted[13],splitted[14],splitted[15],splitted[16],acoes,Integer.parseInt(splitted[22]));

            lutadorDAO.inserir(lutador);
            acaoDAO.inserir(acoes,round.getIdRound(),liga.getAnoLiga(),luta.getIdLuta(),lutador.getNome());
            modalidadeDAO.inserir(lutador.getModalidade(),round.getIdRound(),lutador.getNome(),luta.getIdLuta(),liga.getAnoLiga());


        }

        return liga;
    }
}

