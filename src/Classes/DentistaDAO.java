package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DentistaDAO {

    public String gravarDentista(Dentista dentista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO dentista(nome, id, nascimento, consultorio, valorConsulta, convenio) ";
            sql += "VALUES ('" + dentista.getNome() + "', '" + dentista.getId() + "', '" + dentista.getNascimento() + "','" + dentista.getConsultorio() + "','" + dentista.getValorConsulta() + "','" + dentista.getConvenio() + "')";
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
            String sql = "UPDATE dentista SET nome='" + dentista.getNome() + "',"
                    + " id='" + dentista.getId() + "',"
                    + " nascimento='" + dentista.getNascimento() + "',"
                    + " consultorio='" + dentista.getConsultorio() + "',"
                    + " valorConsulta='" + dentista.getValorConsulta() + "',"
                    + " convenio='" + dentista.getConvenio() + "'WHERE id='" + dentista.getId() + "'";

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
                d.setConsultorio(rs.getInt("consultorio"));
                d.setConvenio(rs.getString("convenio"));
                d.setValorConsulta(rs.getFloat("valorConsulta"));
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
}
