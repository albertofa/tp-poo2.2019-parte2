package src.persistencia;

import java.sql.*;

/**
 * Essa clase contem os atributos e metodos para realizar a conexão com o bando de dados MySql
 *
 * @author José Alberto Fernandes
 */
public class Conexao {
    private String host;
    private String usuario;
    private String senha;
    private String banco;

    /**
     * Construtor
     */
    public Conexao() {
        this.banco = "pooBD";
        this.host = "127.0.0.1";
        this.usuario = "root";
        this.senha = "admin";
    }

    /**
     * Metodo que retorna uma conexão estabelecida com o BD
     * @return Retorna objeto do tipo Connection
     */
    public Connection getConexao() {
        try {
            String url = "jdbc:mysql://"
                    + this.host + "/" + this.banco;

            return DriverManager.
                    getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
