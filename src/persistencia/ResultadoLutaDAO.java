package src.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultadoLutaDAO {

        public static boolean inserir(int anoLiga, int idLuta, String nome){

            int valor = 0;
            try{
                Connection conexao = new Conexao().getConexao();

                PreparedStatement result = conexao.prepareStatement("insert into Resultado_Luta(Luta_anoLiga,Luta_idLuta,Lutador_nomeVencedor) values (?,?,?);");

                result.setInt(1, anoLiga);
                result.setInt(2, idLuta);
                result.setString(3, nome);


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

        public static void deletar( int anoLiga, int idLuta, String nome) {
            try {
                Connection conexao = new Conexao().getConexao();
                PreparedStatement result =
                        conexao.prepareStatement("DELETE FROM Lutador WHERE nome = ?;");

                result.setString(1, nome);
                result.executeUpdate();
                conexao.close();
            } catch (Exception e) {

            }

        }
}
