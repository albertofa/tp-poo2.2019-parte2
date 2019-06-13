package src.persistencia.tabelas;

import src.negocio.lutador.Acao;
import src.persistencia.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcaoDAO {

    public static boolean inserir(Acao acao, int idRound, int anoLiga, int idLuta, String nome){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result = conexao.prepareStatement("insert into Acoes(defesa,ataque,soco,chute,poder,Round_idRound,Round_anoLiga,Round_idLuta,Lutador_nome) values (?,?,?,?,?,?,?,?,?);");

            result.setInt(1, acao.getDefesa());
            result.setInt(2, acao.getAtaque());
            result.setInt(3, acao.getSoco());
            result.setInt(4, acao.getChute());
            result.setInt(5, acao.getPoder());
            result.setInt(6, idRound);
            result.setInt(7, anoLiga);
            result.setInt(8, idLuta);
            result.setString(9, nome);


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

    public static void deletar(int idRound){
        try{
            Connection conexao = new Conexao().getConexao();
            PreparedStatement result=
                    conexao.prepareStatement("DELETE FROM Acoes WHERE Round_idRound = ?;");

            result.setInt(1,idRound);
            result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

    }
}
