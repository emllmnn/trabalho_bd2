import br.com.bd.trab.persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            if (con != null) {
                System.out.println("Conexão bem-sucedida!");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        } finally{
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexão fechada.");
                } catch(SQLException e){
                    System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
    }
}
