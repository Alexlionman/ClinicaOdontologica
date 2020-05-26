
package Classes;

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
            String driverName = "com.mysql.jdbc.Driver";    //conectei dessa forma ocm o meu banco(usei o Xampp e Workbench) - baixei outro driver para usar            
            Class.forName(driverName); 
            String url = "jdbc:mysql://localhost:3306/projeto";     //esses são os dados da minha conexão
            con = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException e){
            System.out.println("Driver não foi encontrado "+ e.toString());
        }catch(SQLException e){
            System.out.println("Erro ao conectar com o BD "+e.toString());
        }
        return con;
    }
}
