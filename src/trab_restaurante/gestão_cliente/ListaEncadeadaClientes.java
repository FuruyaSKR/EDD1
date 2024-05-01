package trab_restaurante.gestão_cliente;

import trab_restaurante.gestão_mesas.Mesa;

public class ListaEncadeadaClientes {
    private Cliente inicio;

    public ListaEncadeadaClientes() {
        inicio = null;
    }

    public boolean vazia() {
        return inicio == null;
    }

    // Inserir cliente
    public Cliente inserirCliente(String nome, int id, int totalPessoas) {
        Cliente novoNodo = new Cliente(nome, id, totalPessoas);
        novoNodo.setProx(inicio);
        return inicio = novoNodo;
    }

    // Remoção de clientes
    public void removerClienteCadastrado(int id) {
        if (vazia()) {
            return;
        }
        if (inicio.getId() == id) {
            inicio = inicio.getProx();
            return;
        }
        Cliente aux = inicio;
        while (aux.getProx() != null) {
            if (aux.getProx().getId() == id) {
                aux.setProx(aux.getProx().getProx());
                return;
            }
            aux = aux.getProx();
        }
    }

    // Atualização de informações dos clientes
    public boolean atualizarNomeCliente(int id, String novoNome) {
        Cliente atual = inicio;
        while (atual != null) {
            if (atual.getProx().getId() == id) {
                atual.getProx().setNome(novoNome);
                return true;
            }
            atual = atual.getProx();
        }
        return false;
    }

    // Consulta de clientes cadastrados
    public void consultarClientes() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        Cliente aux = inicio;
        while (aux != null) {
            System.out.println("Cliente ID: " + aux.getId() + ", Nome: " + aux.getNome() + ", Total de pessoas: "
                    + aux.getTotalPessoas());
            aux = aux.getProx();
        }
        System.out.println("");
    }

    // Método para obter a primeira mesa
    public Cliente getInicio() {
        return inicio;
    }
}
