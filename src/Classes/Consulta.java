package Classes;
public class Consulta {
    //ATRIBUTOS
    private int idConsulta;
    private String dataConsulta;
    private String horaConsulta;
    private int pacienteId;
    private int dentistaId;
    private float valorConsulta;
    //CONSTRUTORES
    public Consulta() {
    }
    public Consulta(String dataConsulta, String horaConsulta, int pacienteId, int dentistaId, float valorConsulta) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.pacienteId = pacienteId;
        this.dentistaId = dentistaId;
        this.valorConsulta = valorConsulta;
    }
    
    
    public Consulta(int idConsulta, String dataConsulta, String horaConsulta, int pacienteId, int dentistaId, float valorConsulta) {
        this.idConsulta = idConsulta;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.pacienteId = pacienteId;
        this.dentistaId = dentistaId;
        this.valorConsulta = valorConsulta;
    }

    public Consulta(String dataConsulta, String horaConsulta, float valorConsulta) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.valorConsulta = valorConsulta;
    }
    
    
    
    
    
    
    //MÉTODOS DE ACESSO
    public int getIdConsulta() {
        return idConsulta;
    }
    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    public String getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public String getHoraConsulta() {
        return horaConsulta;
    }
    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
    public int getPacienteId() {
        return pacienteId;
    }
    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
    public int getDentistaId() {
        return dentistaId;
    }
    public void setDentistaId(int dentistaId) {
        this.dentistaId = dentistaId;
    }
    public float getValorConsulta() {
        return valorConsulta;
    }
    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }
}