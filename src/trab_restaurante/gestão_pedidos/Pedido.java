package trab_restaurante.gestão_pedidos;

public class Pedido {
    private int id;
    private String descricao;
    private String status;
    private Pedido prox;
    private Pedido inicio;
    private Pedido fim;
    private int limite;
    private int tamanho = 0;

    public Pedido(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.prox = null;
        this.inicio = null;
    }

    public Pedido(int limite) {
        this.limite = limite;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    public void inserirPedido(int id, String descricao, String status) {
        if (temEspaco()) {
            Pedido novoItem = new Pedido(id, descricao, status);
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
    public void atualizarPedido(int id, String novaDescricao, String novoStatus) {
        Pedido atual = inicio;
        while (atual != null) {
            if (atual.getId() == id) {
                atual.setDescricao(novaDescricao);
                atual.setStatus(novoStatus);
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
            System.out
                    .println("Pedido ID: " + aux.getId() + ", Descrição: " + aux.getDescricao() + ", Status do pedido: "
                            + aux.getStatus());
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
