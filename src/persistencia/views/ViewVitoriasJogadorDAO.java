package src.persistencia.views;

import src.persistencia.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewVitoriasJogadorDAO {

    public static String selecionarView(){
        String string = "";
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result = null;
            try {
                result = conexao.prepareStatement("select * from ViewVitoriasJogador;").executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            while (result.next()) {
                string = string + "\nVencedor: "+result.getString("Lutador_nomeVencedor");
                string = string + " | Numero Vitorias: "+result.getInt("count(Lutador_nomeVencedor)");
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }

        return string;
    }
}
