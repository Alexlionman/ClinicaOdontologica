/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author a.pereira
 */
public class Prontuario {
    
    int idProntuario;
    int idPaciente;
    String descricao;

    public Prontuario(int idProntuario, int idPaciente, String descricao) {
        this.idProntuario = idProntuario;
        this.idPaciente = idPaciente;
        this.descricao = descricao;
    }

    public Prontuario(int idPaciente, String descricao) {
        this.idPaciente = idPaciente;
        this.descricao = descricao;
    }
    
    

    Prontuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
