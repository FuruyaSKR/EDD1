package lista_exercicios1.exercicio_2;

public class Nodo {
    private Produto produto; 
    private Nodo prox;

    // Construtor atualizado para receber um Produto
    public Nodo(Produto produto) {
        this.produto = produto;
        this.prox = null;
    }

    // Getters e setters atualizados
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }
}
