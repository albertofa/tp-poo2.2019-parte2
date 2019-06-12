package src.persistencia;

import src.negocio.Modalidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModalidadeDAO {

    public boolean inserir(Modalidade modalidade, int idRound, String nome, int idLuta, int anoLiga){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result =
                    conexao.prepareStatement("insert into Modalidade(forca,Lutador_nome,Round_idRound,Round_idLuta,Round_anoLiga) values (?,?,?,?,?);");

            result.setInt(1, modalidade.getForca());
            result.setString(2, nome);
            result.setInt(3, idRound);
            result.setInt(4, idLuta);
            result.setInt(5, anoLiga);


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
                    conexao.prepareStatement("DELETE FROM Modalidade WHERE Lutador_idRound = ?;");

            result .setInt(1,idRound);
            result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

    }
}
