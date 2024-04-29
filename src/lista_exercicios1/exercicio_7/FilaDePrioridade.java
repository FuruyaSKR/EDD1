package lista_exercicios1.exercicio_7;

public class FilaDePrioridade {
    private Nodo inicio;

    public FilaDePrioridade() {
        this.inicio = null;
    }

    public void inserir(int dado, int prioridade) {
        Nodo novoNodo = new Nodo(dado, prioridade);
        if (inicio == null || inicio.getPrioridade() < prioridade) {
            novoNodo.setProx(inicio);
            inicio = novoNodo;
        } else {
            Nodo atual = inicio;
            while (atual.getProx() != null && atual.getProx().getPrioridade() >= prioridade) {
                atual = atual.getProx();
            }
            novoNodo.setProx(atual.getProx());
            atual.setProx(novoNodo);
        }
    }

    public Integer remover() {
        if (inicio == null) {
            System.out.println("Fila vazia.");
            return null;
        }
        int elementoRemovido = inicio.getDado();
        inicio = inicio.getProx();
        return elementoRemovido;
    }

    // Método para exibir a fila (opcional para testes)
    public void exibir() {
        Nodo atual = inicio;
        while (atual != null) {
            System.out.println("Dado: " + atual.getDado() + " | Prioridade: " + atual.getPrioridade());
            atual = atual.getProx();
        }
    }
}
