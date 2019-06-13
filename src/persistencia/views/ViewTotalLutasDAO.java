package src.persistencia.views;

import src.persistencia.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTotalLutasDAO {

    public static String selecionarView(){
        String string = "";
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result = null;
            try {
                result = conexao.prepareStatement("select * from ViewTotalLutas;").executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            while (result.next()) {
                string = string + "\nTotal de lutas: "+result.getString("count(*)");
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }

        return string;
    }
}
