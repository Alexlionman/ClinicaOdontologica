package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DentistaDAO {

    
    private Connection con;

    public DentistaDAO() {
        this.con = new Conecta().getConexao();
    }
    public String gravarDentista(Dentista dentista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO dentista (nome, endereco, logradouro, numero, complemento, cep, bairro, estado, cidade, cro, email, telefone, nascimento, consultorio, valorConsulta, "
                    + "login, senha) ";
            sql += "VALUES ('" + dentista.getNome() +"','" + dentista.getEndereco()+ "','" + dentista.getLogradouro()+ "','" + dentista.getNumero()+ "', '" + dentista.getComplemento()+ "', '" + dentista.getCep()+ "','"
                    + dentista.getBairro()+"','" + dentista.getEstado()+"','" + dentista.getCidade()+"','" + dentista.getCro()+"','" + dentista.getEmail()+
                    "','" + dentista.getTelefone()+"','" + dentista.getNascimento()+"','" + dentista.getConsultorio()+"','" + dentista.getValorConsulta()+"','" + dentista.getLogin()+"','" + dentista.getSenha()+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public String editarDentista(Dentista dentista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "UPDATE dentista SET ='" + dentista.getNome() + "',"
                    + " endereco='" + dentista.getNascimento() + "',"
                    + " logradouro='" + dentista.getNascimento() + "',"
                    + " numero='" + dentista.getNascimento() + "',"
                    + " complemento='" + dentista.getNascimento() + "',"
                    + " cep='" + dentista.getNascimento() + "',"
                    + " bairro='" + dentista.getNascimento() + "',"
                    + " estado='" + dentista.getNascimento() + "',"
                    + " cidade='" + dentista.getNascimento() + "',"
                    + " cro='" + dentista.getNascimento() + "',"
                    + " email='" + dentista.getNascimento() + "',"
                    + " telefone='" + dentista.getNascimento() + "',"
                    + " nascimento='" + dentista.getNascimento() + "',"
                    + " consultorio='" + dentista.getNascimento() + "',"
                    + " valorConsulta='" + dentista.getConsultorio() + "',"
                    + " login='" + dentista.getValorConsulta() + "',"
                    + " senha='" + dentista.getSenha() + "'WHERE id='" + dentista.getId() + "'";

            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public String excluirDentista(Dentista dentista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "DELETE from dentista WHERE id =" + dentista.getId();

            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public Dentista pesquisarDentista(int id) {
        Dentista d = new Dentista();
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM dentista WHERE id=" + id;
            stmt.executeQuery(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setNome(rs.getString("nome"));
                d.setNascimento(rs.getString("nascimento"));
                d.setConsultorio(rs.getString("consultorio"));
                d.setValorConsulta(rs.getString("valorConsulta"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            d = null;
        }
        return d;
    }

    public String verificaNomeExistente(Dentista dentista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT nome FROM dentista WHERE nome='" + dentista.getNome() + "'";
            stmt.executeQuery(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                resp = rs.getString("nome");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    public List<Dentista> buscaDentistaPorNome(String nome) {
          //esse método é usado para buscar quando digitado uma letra no campo de texto de pesquisa
        try {

           
            List<Dentista> lista = new ArrayList<>();

            //pega tudo de clientes
            String sql = "select * from dentista where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Dentista obj = new Dentista();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setLogradouro(rs.getString("logradouro"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setCep(rs.getString("cep"));
                obj.setBairro(rs.getString("bairro"));
                obj.setEstado(rs.getString("estado"));
                obj.setCidade(rs.getString("cidade"));
                obj.setCro(rs.getString("cro"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setNascimento(rs.getString("nascimento"));
                obj.setConsultorio(rs.getString("consultorio"));
                obj.setValorConsulta(rs.getString("valorConsulta"));
                obj.setLogin(rs.getString("login"));
                obj.setSenha(rs.getString("senha"));

                lista.add(obj);  //adiciona o objeto criado na lista
            }
        
            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }   
}
