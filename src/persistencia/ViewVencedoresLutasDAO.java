package src.persistencia;

import src.negocio.relatorios.ResumoRound;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewVencedoresLutasDAO {

    public static String selecionarView(){
        String string = "";
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result = null;
            try {
                result = conexao.prepareStatement("select * from ViewVencedoresLutas;").executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            while (result.next()) {
                string = string + "\nVencedor: "+result.getString("Lutador_nomeVencedor");
                string = string + " | idLuta: "+result.getInt("Luta_idLuta");
                string = string + " | Ano Liga: "+result.getInt("Luta_anoLiga");
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }

        return string;
    }

}
