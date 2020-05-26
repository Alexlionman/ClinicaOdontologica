package Classes;

public class Recepcionista {

    private String nome;
    private int id;
    private String cpf;
    private String login;
    private String senha;

    public Recepcionista() {
    }
    public Recepcionista(String nome, int id, String cpf, String login, String senha) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }
    public Recepcionista(String nome, String cpf, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }
    public Recepcionista(String login, String senha) {
        this.login = login;
        this.senha = senha;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
