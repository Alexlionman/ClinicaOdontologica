
package Classes;

import java.sql.Connection;
import java.sql.Statement;

public class ProdutoDAO {
    public String gravarProduto(Produto produto){
        String resp = "";
        try{
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO produto(nome, fabricante) ";
            sql += "VALUES ('"+produto.getNome()+"', '"+produto.getFabricante()+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        }catch(Exception e){
            resp = e.toString();
        }
        return resp;
    }
    
   
}
