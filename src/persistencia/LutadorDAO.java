package src.persistencia;


import src.negocio.Lutador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LutadorDAO {

    public boolean inserir(Lutador lutador, int idRound){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result = conexao.prepareStatement("insert into Lutador(nome,categoria,pais,sexo,Round_idRound) values (?,?,?,?,?);");

            result.setString(1, lutador.getNome());
            result.setString(2, lutador.getCategoria());
            result.setString(3, lutador.getPais());
            result.setString(4, lutador.getSexo());
            result.setInt(5, idRound);


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

    public void deletar(Lutador lutador){
        try{
            Connection conexao = new Conexao().getConexao();
            PreparedStatement result=
                    conexao.prepareStatement("DELETE FROM Round WHERE nome = ?;");

            result.setString(1,lutador.getNome());
            result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

    }
}
