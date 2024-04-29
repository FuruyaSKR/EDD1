package trab_restaurante.gestão_cliente;

public class Cliente {
    private String nome;
    private int id;
    private Cliente prox;

    public Cliente(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.prox = null;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getProx() {
        return prox;
    }

    public void setProx(Cliente prox) {
        this.prox = prox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
