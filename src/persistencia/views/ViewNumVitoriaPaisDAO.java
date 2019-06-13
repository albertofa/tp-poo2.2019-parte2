package src.persistencia.views;

import src.persistencia.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ViewNumVitoriaPaisDAO {

    public static String selecionarView(){
        String string = "";
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result = null;
            try {
                result = conexao.prepareStatement("select * from ViewNumVitoriaPais;").executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            while (result.next()) {
                string = string + "\nNumero Vitorias: "+result.getInt("count(nome)");
                string = string + " | idLuta: "+result.getString("pais");
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }

        return string;
    }
}
