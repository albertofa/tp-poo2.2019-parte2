package src.persistencia.tabelas;

import src.negocio.liga.Liga;
import src.persistencia.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LigaDAO {

    /*public ArrayList<Livro> selecionarTodos(){
        ArrayList<Livro> ArraYlivros = new ArrayList<Livro>();
        try{
            Connection conexao =
                    new Conexao().getConexao();

            ResultSet result =
                    conexao.
                            prepareStatement("select * from Livro;")
                            .executeQuery();

            Livro livro;
            while (result.next()) {
                livro= new Livro();
                livro.setId(result.getInt("id_livro"));
                livro.setNome( result.getString("nome"));
                livro.setValor(result.getString("valor"));
                ArraYlivros.add(livro);
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }
        return ArraYlivros;
    }*/

    /*public int selecionar(Livro lp){
        Livro livro=new Livro();
        try{
            Connection conexao =
                    new Conexao().getConexao();
            ResultSet result =
                    conexao.
                            prepareStatement("select * from Livro where id_livro="+lp.getId() )
                            .executeQuery();

            while(result.next()){
                livro.setId(result.getInt("id_livro"));
                livro.setNome( result.getString("nome"));
                livro.setValor(result.getString("valor"));
            }
            conexao.close();
        }catch( SQLException e){
            e.printStackTrace();
        }

        return livro;
    }*/

    public static boolean inserir(Liga liga){

        int valor = 0;
        try{
            Connection conexao = new Conexao().getConexao();

            PreparedStatement result =
                    conexao.prepareStatement("insert into Liga(anoLiga) values (?);");

            result.setInt(1, liga.getAnoLiga());

            valor =result.executeUpdate();
            conexao.close();

        }catch( SQLException e){
            e.printStackTrace();
        }
        if(valor==1 )
            return true;
        else
            return false;

    }

    public static void deletar(Liga liga){
        try{
            Connection conexao = new Conexao().getConexao();
            PreparedStatement result=
                    conexao.prepareStatement("DELETE FROM Liga WHERE anoLiga = ?;");

            result .setInt(1,liga.getAnoLiga());
            result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

    }
    /*public boolean update(Livro a){
        int valor =0;
        try{
            Connection conexao = new Conexao().getConexao();
            PreparedStatement result=
                    conexao.prepareStatement(
                            "UPDATE Livro SET nome = ?, valor =? WHERE id_livro = ?");

            result .setString(1, a.getNome());
            result.setString(2, a.getValor());
            result.setInt(3, a.getId());

            valor =result.executeUpdate();
            conexao.close();
        }catch(Exception e){

        }

        if(valor==1 )
            return true;
        else
            return false;

    }*/
}
