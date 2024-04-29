package trab_restaurante.gestão_pedidos;

public class Fila {
    private Pedido inicio;
    private Pedido fim;
    private int limite;
    private int tamanho = 0;

    public Fila(int limite) {
        this.limite = limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean temEspaco() {
        return limite > tamanho;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public Integer getInicio() {
        if (!estaVazio()) {
            return inicio.getId();

        } else {
            System.out.println("Fila está vazia!");
            return null;
        }

    }

    // Inserir pedido
    public void inserirPedido(int id, String descricao) {
        if (temEspaco()) {
            Pedido novoItem = new Pedido(id, descricao);
            if (estaVazio()) {
                inicio = novoItem;
                fim = novoItem;
            } else {
                fim.setProx(novoItem);
                fim = novoItem;
            }
            tamanho++;
        } else {
            System.out.println("Fila cheia!");
        }
    }

    // Atualização de pedidos
    public void atualizarPedido(int id, String novaDescricao) {
        Pedido atual = inicio;
        while (atual != null) {
            if (atual.getId() == id) {
                atual.setDescricao(novaDescricao);
                System.out.println("Pedido atualizado com sucesso.");
                return;
            }
            atual = atual.getProx();
        }

        System.out.println("Pedido não encontrado.");
    }

    // Consulta de pedidos cadastrados
    public void consultaPedidosRegistrados() {
        Pedido aux = inicio;
        while (aux != null) {
            System.out.println("Pedido ID: " + aux.getId() + ", Descrição: " + aux.getDescricao());
            aux = aux.getProx();
        }
        System.out.println("");
    }

    // Cancelamento de pedidos
    public void cancelarPedido(int id) {
        if (inicio == null) {
            System.out.println("Fila de pedidos vazia.");
            return;
        }

        if (inicio.getId() == id) {
            inicio = inicio.getProx();
            System.out.println("Pedido cancelado com sucesso.");
            return;
        }

        Pedido atual = inicio;
        while (atual.getProx() != null) {
            if (atual.getProx().getId() == id) {
                atual.setProx(atual.getProx().getProx());
                System.out.println("Pedido cancelado com sucesso.");
                return;
            }
            atual = atual.getProx();
        }

        System.out.println("Pedido não encontrado.");
    }
}