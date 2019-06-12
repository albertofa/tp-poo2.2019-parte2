package src.persistencia;

import src.negocio.Round;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoundDAO {

    public boolean inserir(Round round, int idLuta, int anoLiga){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result =
                    conexao.prepareStatement("insert into Round(idRound,Luta_idLuta,Luta_anoLiga) values (?,?,?);");

            result.setInt(1, round.getIdRound());
            result.setInt(2, idLuta);
            result.setInt(3, anoLiga);

            valor = result.executeUpdate();
            conexao.close();

        }catch( SQLException e){
            e.printStackTrace();
        }
        if(valor==1)
            return true;
        else
            return false;

    }

    public void deletar(Round round){
        try{
            Connection conexao = new Conexao().getConexao();
            PreparedStatement result=
                    conexao.prepareStatement("DELETE FROM Round WHERE idRound = ?;");

            result .setInt(1,round.getIdRound());
            result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

    }
}
