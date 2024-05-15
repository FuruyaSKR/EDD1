package lista_exercicios1.exercicio_7;

public class Nodo {
    private int dado;
    private int prioridade;
    private Nodo prox;

    public Nodo(int dado, int prioridade) {
        this.dado = dado;
        this.prioridade = prioridade;
        this.prox = null;
    }

    // Getters e setters
    public int getDado() {
        return dado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }
}
