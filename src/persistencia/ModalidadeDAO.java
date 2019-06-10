package src.persistencia;

import src.negocio.Modalidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModalidadeDAO {

    public boolean inserir(Modalidade modalidade, int idRound){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result =
                    conexao.prepareStatement("insert into Modalidade(Lutador_idRound,forca) values (?,?);");

            result.setInt(1, idRound);
            result.setInt(2, modalidade.getForca());


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
