package src.persistencia;

import java.sql.*;

public class Conexao {
    private String host;
    private String usuario;
    private String senha;
    private String banco;

    //construtor
    public Conexao() {
        this.banco = "pooteste";
        this.host = "127.0.0.1";
        this.usuario = "root";
        this.senha = "";
    }

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
