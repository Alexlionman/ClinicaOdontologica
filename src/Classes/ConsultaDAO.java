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

public class ConsultaDAO {

    public String gravarConsulta(Consulta consulta) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO consulta(dataConsulta, hora, valor, dentistaId, pacienteId) "
                    + "VALUES ('" + consulta.getDataConsulta() + "', '" + consulta.getHoraConsulta() + "', '"
                    + consulta.getValorConsulta() + "','" + consulta.getDentistaId() + "','" + consulta.getPacienteId() + "')";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    
    public String excluirConsulta(int  id) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "DELETE from consulta WHERE id =" + id;

            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    
     public Consulta pesquisarConsulta(int id) {
        Consulta d = new Consulta();
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM consulta WHERE id=" + id;
            stmt.executeQuery(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                d.setIdConsulta(rs.getInt("id"));
                d.setDentistaId(rs.getInt("dentistaId"));
                d.setHoraConsulta(rs.getString("hora"));
                d.setDataConsulta(rs.getString("dataConsulta"));
                d.setValorConsulta(rs.getFloat("valorConsulta"));
                d.setPacienteId(rs.getInt("pacienteID"));
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            d = null;
        }
        return d;
    }
     
     
     
        public String editarConsulta(Consulta consulta) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            pstm = con.prepareStatement("UPDATE consulta set dataConsulta = ?, hora = ?, valor = ? where id = ? ");
            pstm.setString(1,consulta.getDataConsulta());
            pstm.setString(2,consulta.getHoraConsulta());
            pstm.setString(3,String.valueOf(consulta.getValorConsulta()));
            pstm.setString(4,String.valueOf(consulta.getIdConsulta()));
            
            pstm.executeUpdate();
            pstm.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }

    public List horasIndisponiveis(String data, int dentista){
	List<String> lista = new ArrayList<String>();
	String query = "SELECT hora FROM consulta WHERE dentistaId="+dentista+" and dataConsulta='"+data+"'";
	try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
		lista.add(rs.getString("hora"));
            }
            stmt.close();
            rs.close();
            con.close();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	return lista;
    }
}
