
package Classes;

import java.util.Date;
/**
 *
 * @author perei
 */
public class Paciente {
    private String nome;
    private int id;
    private String endereco;
    private String cpf;
    private String rg;
    private String nascimento;
    private  String prontuario;

    public Paciente() {
    }
    public Paciente(int id) {
        this.id = id;
    }
    public Paciente(String nome, int id, String endereco, String cpf, String rg, String nascimento, String prontuario) {
        this.nome = nome;
        this.id = id;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.nascimento = nascimento;
        this.prontuario = prontuario;
    }
    public Paciente(String nome, String endereco, String cpf, String rg, String nascimento, String prontuario) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.nascimento = nascimento;
        this.prontuario = prontuario;
    }
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }
    
}
