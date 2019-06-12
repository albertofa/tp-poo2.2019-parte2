package src.persistencia;

import src.negocio.Luta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LutaDAO {

    public static boolean inserir(Luta luta, int anoLiga){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result =
                    conexao.prepareStatement("insert into Luta(idLuta,Liga_anoLiga) values (?,?);");

            result.setInt(1, luta.getIdLuta());
            result.setInt(2, anoLiga);

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

    public static void deletar(Luta luta){
        try{
            Connection conexao = new Conexao().getConexao();
            PreparedStatement result=
                    conexao.prepareStatement("DELETE FROM Luta WHERE idLuta = ?;");

            result .setInt(1,luta.getIdLuta());
            result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

    }
}
