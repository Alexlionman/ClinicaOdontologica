
package Classes;

/**
 *
 * @author perei
 */
public class Produto {
    private int id;
    private String nome;
    private String fabricante;

    public Produto() {
    }
    
    public Produto(String nome, String fabricante) {
        this.nome = nome;
        this.fabricante = fabricante;
    }

    public Produto(int id, String nome, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
