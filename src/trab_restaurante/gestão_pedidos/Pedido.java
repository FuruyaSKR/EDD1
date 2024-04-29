package trab_restaurante.gestão_pedidos;

public class Pedido {
    private int id;
    private String descricao;
    private Pedido prox;

    public Pedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.prox = null;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido getProx() {
        return prox;
    }

    public void setProx(Pedido prox) {
        this.prox = prox;
    }

}
