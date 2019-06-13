package src.persistencia.views;

import src.persistencia.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewVencedorCategoriaDAO {

    public static String selecionarView(){
        String string = "";
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result = null;
            try {
                result = conexao.prepareStatement("select * from ViewVencedorCategoria;").executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            while (result.next()) {
                string = string + "\nNome: "+result.getString("Lutador_nomeVencedor");
                string = string + " | Categoria: "+result.getString("categoria");
                string = string + " | Numero vitorias: "+result.getInt("count(Lutador_nomeVencedor)");
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }

        return string;
    }
}
