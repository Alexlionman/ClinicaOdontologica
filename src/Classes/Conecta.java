
package Classes;
//editado
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author perei
 */
public class Conecta {
    public static Connection getConexao(){
        Connection con = null;
        try{
            String username = "root";
            String password = "1234";
            String driverName = "com.mysql.jdbc.Driver";                
            Class.forName(driverName); 
            String url = "jdbc:mysql://localhost:3306/projetov1?useTimezone=true&serverTimezone=UTC";     //esses são os dados da *minha* conexão
            con = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException e){
            System.out.println("Driver não foi encontrado "+ e.toString());
        }catch(SQLException e){
            System.out.println("Erro ao conectar com o BD "+e.toString());
        }
        return con;
        
    }
}
