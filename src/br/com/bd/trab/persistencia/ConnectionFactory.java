package br.com.bd.trab.persistencia;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConnection(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "user";
        String senha = "@br@c@d@br@766!!!AN";
        String url = "jdbc:mysql://localhost:3306/meu_projeto";

        Connection con = null;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        }catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return con;
    }
    public static void close (Connection con){
        try {
            con.close();
        }catch (SQLException e){
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        };
    }
}
