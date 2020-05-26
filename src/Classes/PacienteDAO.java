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
            String sql = "INSERT INTO paciente(nome, endereco, cpf, rg, nascimento, prontuario) ";
            sql += "VALUES ('" + paciente.getNome() +"','" + paciente.getEndereco() + "','" + paciente.getCpf() + "', '" + paciente.getRg() + "', '" + paciente.getNascimento() + "','" + paciente.getProntuario() + "')";
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
                    + " endereco='" + paciente.getEndereco() + "',"
                    + " prontuario='" + paciente.getProntuario() + "',"
                    + " rg='" + paciente.getRg() + "',"
                    + " nascimento='" + paciente.getNascimento() + "',"
                    + " cpf='" + paciente.getCpf() + "'WHERE id=" + paciente.getId();

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
                p.setEndereco(rs.getString("endereco"));
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNascimento(rs.getString("nascimento"));
                p.setProntuario(rs.getString("prontuario"));
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