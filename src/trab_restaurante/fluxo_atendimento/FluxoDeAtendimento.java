package trab_restaurante.fluxo_atendimento;

import trab_restaurante.gestão_cliente.Cliente;
import trab_restaurante.gestão_funcionarios.Funcionario;
import trab_restaurante.gestão_mesas.Mesa;
import trab_restaurante.gestão_pedidos.Pedido;

public class FluxoDeAtendimento {

    // a. Encaminhamento de clientes para mesas disponíveis
    public void encaminharClienteParaMesa(Cliente cliente, Mesa[] mesas) {
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada() && mesa.getCapacidade() >= cliente.getTotalPessoas()) {
                mesa.setOcupada(true);
                mesa.setCliente(cliente);
                System.out.println("Cliente " + cliente.getNome() + " foi encaminhado para a mesa " + mesa.getNumero());
                return;
            }
        }
        System.out.println("Nenhuma mesa disponível para " + cliente.getTotalPessoas() + " pessoas.");
    }

    // b. Atendimento de pedidos pelos garçons
    public void atenderPedidoGarcom(Pedido pedido, Funcionario garcom) {
        if (garcom.getCargo().equals("Garçom")) {
            System.out.println("Pedido " + pedido.getDescricao() + " foi atendido pelo garçom " + garcom.getNome());
        } else {
            System.out.println(garcom.getNome() + " não é um garçom.");
        }
    }

    // c. Preparação de pedidos pelos cozinheiros
    public void prepararPedidoCozinheiro(Pedido pedido, Funcionario cozinheiro) {
        if (cozinheiro.getCargo().equals("Cozinheiro")) {
            System.out.println("Pedido " + pedido.getDescricao() + " está sendo preparado pelo cozinheiro "
                    + cozinheiro.getNome());
            pedido.setStatus("Em preparação");
        } else {
            System.out.println(cozinheiro.getNome() + " não é um cozinheiro.");
        }
    }

    // d. Entrega de pedidos aos clientes
    public void entregarPedido(Pedido pedido, Cliente cliente) {
        if (pedido.getStatus().equals("Em preparação")) {
            pedido.setStatus("Entregue");
            System.out.println("Pedido " + pedido.getDescricao() + " foi entregue ao cliente " + cliente.getNome());
        } else {
            System.out.println("Pedido " + pedido.getDescricao() + " ainda não está pronto para entrega.");
        }
    }

    // e. Cobrança e fechamento de contas
    public void fecharConta(Cliente cliente, double valor) {
        System.out.println("Cliente " + cliente.getNome() + " fechou a conta no valor de " + valor);
    }

}
