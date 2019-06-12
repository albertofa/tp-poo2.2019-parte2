package src.persistencia;

import src.negocio.relatorios.ResumoLuta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewResumoRoundsDAO {


    public static ArrayList<ResumoLuta> selecionarView(){
        ArrayList<ResumoLuta> ArrayResumoLutas = new ArrayList<ResumoLuta>();
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result = null;
            try {
                result = conexao.prepareStatement("select * from ViewResumoRounds;").executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResumoLuta resumoLuta;
            while (result.next()) {
                resumoLuta = new ResumoLuta();
                resumoLuta.setNome(result.getString("Lutador_nome"));
                resumoLuta.setPontos(result.getInt("sum(pontos)"));
                resumoLuta.setIdLuta(result.getInt("Round_idLuta"));
                resumoLuta.setAnoLiga(result.getInt("Round_anoLiga"));
                ArrayResumoLutas.add(resumoLuta);
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }
        return ArrayResumoLutas;
    }


}
