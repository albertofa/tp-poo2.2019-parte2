package src.persistencia.views;

import src.negocio.relatorios.ResumoRound;
import src.persistencia.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewResumoRoundsDAO {



    public static ArrayList<ResumoRound> selecionarView(){
        ArrayList<ResumoRound> arrayResumoRounds = new ArrayList<ResumoRound>();
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result = null;
            try {
                result = conexao.prepareStatement("select * from ViewResumoRounds;").executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResumoRound resumoRound;
            while (result.next()) {
                resumoRound = new ResumoRound();
                resumoRound.setNome(result.getString("Lutador_nome"));
                resumoRound.setPontos(result.getInt("sum(pontos)"));
                resumoRound.setIdLuta(result.getInt("Round_idLuta"));
                resumoRound.setAnoLiga(result.getInt("Round_anoLiga"));
                arrayResumoRounds.add(resumoRound);
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }
        return arrayResumoRounds;
    }

    public static String selecionarViewString(){
        String string = "";
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result = null;
            try {
                result = conexao.prepareStatement("select * from ViewResumoRounds;").executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            while (result.next()) {
                string = string + "\nLutador: "+result.getString("Lutador_nome");
                string = string + " | Pontos: "+result.getInt("sum(pontos)");
                string = string + " | idLuta: "+result.getInt("Round_idLuta");
                string = string + " | Ano liga: "+result.getInt("Round_anoLiga");
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }

        return string;
    }


}
