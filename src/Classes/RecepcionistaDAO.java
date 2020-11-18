package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RecepcionistaDAO {
private Connection con;
    public String gravarRecepcionista(Recepcionista recepcionista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO recepcionista(nome, rg, cpf, dataDeNascimento, telefone, celular, email, rua, numero, complemento, cep, bairro, estado, cidade, login, senha) "
                    + "VALUES ('" + recepcionista.getNome() +"','" + recepcionista.getRg()+ "','" + recepcionista.getCpf()+ "','" + recepcionista.getDataDeNascimento()+ "', '" + recepcionista.getTelefone()+ "', '" + recepcionista.getCelular()+ "','"
                    + recepcionista.getEmail()+"','" + recepcionista.getRua()+"','" + recepcionista.getNumero()+"','" + recepcionista.getComplemento()+"','" + recepcionista.getCep()+
                    "','" + recepcionista.getBairro()+"','" + recepcionista.getEstado()+"', '" + recepcionista.getCidade()+"','" + recepcionista.getLogin()+"','" + recepcionista.getSenha()+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public Recepcionista pesquisarRecepcionista(int id) {
        Recepcionista r = new Recepcionista();

        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM recepcionista WHERE id=" + id;
            stmt.executeQuery(sql);
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                r.setId(rs.getInt("id"));
                r.setNome(rs.getString("nome"));
                r.setRg(rs.getString("rg"));
                r.setCpf(rs.getString("cpf"));
                r.setDataDeNascimento(rs.getString("dataDeNascimento"));
                r.setTelefone(rs.getString("telefone"));
                r.setCelular(rs.getString("celular"));
                r.setEmail(rs.getString("email"));
                r.setRua(rs.getString("rua"));
                r.setNumero(rs.getString("numero"));
                r.setComplemento(rs.getString("complemento"));
                r.setCep(rs.getString("cep"));
                r.setBairro(rs.getString("bairro"));
                r.setEstado(rs.getString("estado"));
                r.setCidade(rs.getString("cidade"));
                r.setLogin(rs.getString("login"));
                r.setSenha(rs.getString("senha"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            r = null;
        }
        return r;
    }

    public boolean loginRecepcionista(String login, String senha) {
        Connection con = Conecta.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM recepcionista WHERE login=? AND senha=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public String verificaCpfExistente(Recepcionista recepcionista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT cpf FROM recepcionista WHERE cpf='" + recepcionista.getCpf() + "'";
            stmt.executeQuery(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                resp = rs.getString("cpf");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public String verificaLoginExistente(Recepcionista recepcionista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT login FROM recepcionista WHERE login='" + recepcionista.getLogin() + "'";
            stmt.executeQuery(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                resp = rs.getString("login");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    public String excluirRecepcionista(Recepcionista p) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "DELETE from recepcionista WHERE id =" + p.getId();
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
     public List<Recepcionista> buscaRecepcionistaPorNome(String nome) {
          //esse método é usado para buscar quando digitado uma letra no campo de texto de pesquisa
        try {

           
            List<Recepcionista> lista = new ArrayList<>();

            //pega tudo de clientes
            String sql = "select * from recepcionista where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Recepcionista obj = new Recepcionista();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setRua(rs.getString("endereco"));
                obj.setDataDeNascimento(rs.getString("nascimento"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                obj.setNumero(rs.getString("numero"));

                lista.add(obj);  //adiciona o objeto criado na lista
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

}}
