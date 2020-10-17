/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author a.pereira
 */
public class ProntuarioDAO {
    private Connection con;

    public ProntuarioDAO() {
        this.con = new Conecta().getConexao();
    }
    
    
    
    public Prontuario pesquisarProntuario(int id){
        Prontuario p = new Prontuario();
        try{
            Connection con=Conecta.getConexao();
            Statement stmt=con.createStatement();
            String sql="SELECT * FROM prontuario WHERE idPaciente="+id;
            stmt.execute(sql);
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                p.setIdPaciente(rs.getInt("idProntuario"));
                p.setIdPaciente(rs.getInt("idPaciente"));
                p.setDescricao(rs.getString("descricao"));
                
   
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){
        }
        return p;
    }
    
    public String gravarProntuario(Prontuario prontuario) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO prontuario(idPaciente, descricao) ";
            sql += "VALUES ('" + prontuario.getIdPaciente()+"','" + prontuario.getDescricao()+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    
    public String editarProntuario(Prontuario prontuario) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "UPDATE prontuario SET descricao='" + prontuario.getDescricao()+ "'WHERE id=" + prontuario.getIdPaciente();

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
