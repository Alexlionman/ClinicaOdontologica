package Classes;
public class Dentista {
    private String nome;
    private int id;
    private String nascimento;
    private int consultorio;
    private float valorConsulta;
    private String convenio;

    public Dentista() {
    }
    public Dentista(int id) {
        this.id = id;
    } 
    public Dentista(String nome,  String nascimento, int consultorio, float valorConsulta, String convenio) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.consultorio = consultorio;
        this.valorConsulta = valorConsulta;
        this.convenio = convenio;
    }
    
    public Dentista(String nome, int id, String nascimento, int consultorio, float valorConsulta, String convenio) {
        this.nome = nome;
        this.id = id;
        this.nascimento = nascimento;
        this.consultorio = consultorio;
        this.valorConsulta = valorConsulta;
        this.convenio = convenio;
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
    public String getNascimento() {
        return nascimento;
    }
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    public int getConsultorio() {
        return consultorio;
    }
    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }
    public float getValorConsulta() {
        return valorConsulta;
    }
    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
    public String getConvenio() {
        return convenio;
    }
    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
}