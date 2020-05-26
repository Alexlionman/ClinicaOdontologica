package Classes;

public class ProdutoEstoque {

    private int id;
    private int quantidade;
    private float peso;
    private String validade;
    private int produtoId;

    public ProdutoEstoque() {
    }
    public ProdutoEstoque(int quantidade, float peso, String validade, int produtoId) {
        this.quantidade = quantidade;
        this.peso = peso;
        this.validade = validade;
        this.produtoId = produtoId;
    }
    public ProdutoEstoque(int id, int quantidade, float peso, String validade, int produtoId) {
        this.id = id;
        this.quantidade = quantidade;
        this.peso = peso;
        this.validade = validade;
        this.produtoId = produtoId;
    }

    public int getId() {
        return id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public float getPeso() {
        return peso;
    }
    public String getValidade() {
        return validade;
    }
    public int getProdutoId() {
        return produtoId;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
}