package src.persistencia.tabelas;


import src.persistencia.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PontosRoundDAO {

    public static boolean inserir(int pontos, int idRound, int anoLiga, int idLuta, String nome){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result = conexao.prepareStatement("insert into Pontos_Round(pontos,Round_idRound,Round_anoLiga,Round_idLuta,Lutador_nome) values (?,?,?,?,?);");

            result.setInt(1, pontos);
            result.setInt(2, idRound);
            result.setInt(3, anoLiga);
            result.setInt(4, idLuta);
            result.setString(5, nome);


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

    public static void deletar(int idRound, int anoLiga, int idLuta, String nome){
        try{
            Connection conexao = new Conexao().getConexao();
            PreparedStatement result=
                    conexao.prepareStatement("DELETE FROM Lutador WHERE nome = ?;");

            result.setString(1, nome);
            result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

    }
}
