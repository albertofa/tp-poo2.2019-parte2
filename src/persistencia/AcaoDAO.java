package src.persistencia;

import src.negocio.Acao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcaoDAO {

    public boolean inserir(Acao acao, int idRound){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result = conexao.prepareStatement("insert into Acoes(Lutador_idRound,defesa,ataque,soco,chute,poder) values (?,?,?,?,?,?);");

            result.setInt(1, idRound);
            result.setInt(2, acao.getDefesa());
            result.setInt(3, acao.getAtaque());
            result.setInt(4, acao.getSoco());
            result.setInt(5, acao.getChute());
            result.setInt(6, acao.getPoder());


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

    public void deletar(int idRound){
        try{
            Connection conexao = new Conexao().getConexao();
            PreparedStatement result=
                    conexao.prepareStatement("DELETE FROM Acoes WHERE Lutador_idRound = ?;");

            result.setInt(1,idRound);
            result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

    }
}
