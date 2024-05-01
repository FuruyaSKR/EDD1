package trab_restaurante.gestão_mesas;

import trab_restaurante.gestão_cliente.Cliente;

public class ListaEncadeadaMesas {
    private Mesa inicio;

    // construtor
    public ListaEncadeadaMesas() {
        inicio = null;
    }

    // Ocupar ou Desocupar uma mesa
    public void acoesParaMesa(Mesa mesa, boolean ocupar, int pessoas) {
        mesa.setOcupada(ocupar);
        mesa.setPessoas(pessoas);
    }

    // Método para criar uma mesa para o restaurante
    public Mesa criarMesa(int numero, int capacidade, int pessoas) {
        Mesa novaMesa = new Mesa(numero, capacidade, pessoas);
        if (inicio == null) {
            inicio = novaMesa;
        } else {
            Mesa atual = inicio;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novaMesa);
        }
        return novaMesa;
    }

    // Método para verificar a capacidade da mesa
    public Boolean verificaCapacidade(Mesa mesa, int totalPessoas) {
        return mesa.getCapacidade() >= totalPessoas;
    }

    // Método para alocar uma mesa pela capacidade dela
    public boolean alocarMesaParaClientes(Cliente cliente) {
        Mesa atual = inicio;
        System.out.println("\n");
        while (atual != null) {
            if (!atual.isOcupada() && verificaCapacidade(atual, cliente.getTotalPessoas())) {
                atual.setCliente(cliente);
                acoesParaMesa(atual, true, cliente.getTotalPessoas());
                System.out.println(
                        "Mesa " + atual.getNumero() + " foi ocupada para " + cliente.getTotalPessoas() + " pessoas.");
                return true;
            }
            atual = atual.getProx();
        }
        System.out.println(
                "Não há mesas disponíveis com capacidade suficiente para " + cliente.getTotalPessoas() + " pessoas.");
        return false;
    }

    // Método para liberar uma mesa após a saída dos clientes
    public void liberarMesa(int numeroMesa) {
        Mesa atual = inicio;
        System.out.println("\n");
        while (atual != null) {
            if (atual.getNumero() == numeroMesa) {
                atual.setCliente(null);
                acoesParaMesa(atual, false, 0); // Desocupar a mesa
                System.out.println("Mesa " + numeroMesa + " foi liberada.");
                return;
            }
            atual = atual.getProx(); // Continuar procurando na lista
        }
        System.out.println("Mesa " + numeroMesa + " não encontrada.");
    }

    // Método para consultar mesas ocupadas e disponíveis
    public void consultarMesas() {
        Mesa atual = inicio;
        System.out.println("\nStatus das Mesas: \n");
        while (atual != null) {
            String status = atual.isOcupada() ? "Ocupada" : "Disponível";
            System.out.println("Mesa " + atual.getNumero() + ": " + status + ", Capacidade: " + atual.getCapacidade()
                    + ", Pessoas: " + atual.getPessoas()
                    + ", Cliente: " + (atual.getCliente() != null ? atual.getCliente().getNome() : "Nenhum"));

            atual = atual.getProx();
        }
    }

    // Método para obter a primeira mesa
    public Mesa getInicio() {
        return inicio;
    }
}
