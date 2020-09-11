
package Classes;

import java.util.Date;
/**
 *
 * @author perei
 */
public class Paciente {
    
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String nascimento;
    private String rua;
    private String numero;
    private String telefone;
    private String celular;
    private String complemento;
    private String cep;
    private String email;
    private String bairro;
    private String estado;
    private String cidade;

    public Paciente() {
    }
    public Paciente(int id) {
        this.id = id;
    }

    public Paciente( String nome, String cpf, String rg, String nascimento, String rua, String numero, String telefone, String celular, String complemento, String cep, String email, String bairro, String estado, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.nascimento = nascimento;
        this.rua = rua;
        this.numero = numero;
        this.telefone = telefone;
        this.celular = celular;
        this.complemento = complemento;
        this.cep = cep;
        this.email = email;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
