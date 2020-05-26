package Classes;

import java.sql.Connection;
import java.sql.Statement;

public class ProdutoEstoqueDAO {
    public String gravarEstoque(ProdutoEstoque produtoestoque){
        String resp = "";
        try{
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO produtoEstoque(quantidade, peso, validade, produtoId) "
                       + "VALUES ("+produtoestoque.getQuantidade()+", "+produtoestoque.getPeso()+",'"
                       + produtoestoque.getValidade() +"',"+produtoestoque.getProdutoId()+")";
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
