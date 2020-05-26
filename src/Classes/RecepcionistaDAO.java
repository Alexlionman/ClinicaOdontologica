package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecepcionistaDAO {

    public String gravarRecepcionista(Recepcionista recepcionista) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO recepcionista(nome, cpf, login, senha) "
                    + "VALUES ('" + recepcionista.getNome() + "', '" + recepcionista.getCpf() + "', '" + recepcionista.getLogin() + "','"
                    + recepcionista.getSenha() + "')";
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
                r.setCpf(rs.getString("cpf"));
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

}
