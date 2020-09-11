package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PacienteDAO {

    public String gravarPaciente(Paciente paciente) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO paciente(nome, endereco, logradouro, numero, complemento, cep, bairro, email, celular, telefone, estado, cidade, cpf, rg, nascimento) ";
            sql += "VALUES ('" + paciente.getNome() +"','" + paciente.getRua()+ "','" + paciente.getRua()+ "','" + paciente.getNumero()+ "', '" + paciente.getComplemento()+ "', '" + paciente.getCep()+ "','"
                    + paciente.getBairro()+"','" + paciente.getEmail()+"','" + paciente.getCelular()+"','" + paciente.getTelefone()+"','" + paciente.getEstado()+
                    "','" + paciente.getCidade()+"','" + paciente.getCpf()+"','" + paciente.getRg()+"','" + paciente.getNascimento()+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public String editarPaciente(Paciente paciente) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "UPDATE paciente SET nome='" + paciente.getNome() + "',"
                    + " endereco='" + paciente.getRua()+ "',"
                     + " logradouro='" + paciente.getRua()+ "',"
                     + " numero='" + paciente.getNumero()+ "',"
                     + " complemento='" + paciente.getComplemento()+ "',"
                     + " cep='" + paciente.getCep()+ "',"
                    + " bairro='" + paciente.getBairro()+ "',"
                    + " email='" + paciente.getEmail()+ "',"
                    + " celular='" + paciente.getCelular()+ "',"
                    + " telefone='" + paciente.getTelefone()+ "',"
                    + " estado='" + paciente.getEstado()+ "',"
                    + " cidade='" + paciente.getCidade()+ "',"
                    + " cpf='" + paciente.getCpf()+ "',"
                    + " rg='" + paciente.getRg() + "',"
                    + " nascimento='" + paciente.getNascimento()+ "'WHERE id=" + paciente.getId();

            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public String excluirPaciente(Paciente p) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "DELETE from paciente WHERE id =" +p.getId();
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public Paciente pesquisarPaciente(int id){
        Paciente p=new Paciente();
        try{
            Connection con=Conecta.getConexao();
            Statement stmt=con.createStatement();
            String sql="SELECT * FROM paciente WHERE id="+id;
            stmt.execute(sql);
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setRua(rs.getString("endereco"));
                p.setNumero(rs.getString("numero"));
                p.setComplemento(rs.getString("complemento"));
                p.setCep(rs.getString("cep"));
                p.setBairro(rs.getString("bairro"));
                p.setEmail(rs.getString("email"));
                p.setCelular(rs.getString("celular"));
                p.setTelefone(rs.getString("telefone"));
                p.setEstado(rs.getString("estado"));
                p.setCidade(rs.getString("cidade"));
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNascimento(rs.getString("nascimento"));
         
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
        }
        return p;
    }
    
    public String verificaCpfExistente(Paciente paciente){
        String resp="";
        try{
            Connection con=Conecta.getConexao();
            Statement stmt=con.createStatement();
            String sql="SELECT cpf FROM paciente WHERE cpf='"+paciente.getCpf()+"'";
            stmt.executeQuery(sql);
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                resp=rs.getString("cpf");
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
            resp=e.toString();
        }
        return resp;
    }
}