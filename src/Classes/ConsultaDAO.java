package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    
}
