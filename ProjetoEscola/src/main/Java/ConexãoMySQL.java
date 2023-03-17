import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexãoMySQL {
    /*public static Connection getConnection() throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://localhost//ProjetoEscola";
        String UserName = "root";
        String pass = "12345";

        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        
        Connection conexao = DriverManager.getConnection(url, UserName, pass);
        System.out.print("Conexão estabelecida com sucesso");
        return conexao;

        }*/

        public static Connection getConnection() throws SQLException, ClassNotFoundException{

            String servername = "localhost";
            String database = "ProjetoEscola";
            String url = "jdbc:mysql://" + servername + "/" + database;
            String username = "root";
            String password = "12345";
    
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
    
            return con;
    
            /* */
        }
}
