package trab_restaurante;

import trab_restaurante.fluxo_atendimento.FluxoDeAtendimento;
import trab_restaurante.gestão_cliente.Cliente;
import trab_restaurante.gestão_funcionarios.Funcionario;
import trab_restaurante.gestão_mesas.Mesa;
import trab_restaurante.gestão_pedidos.Pedido;

public class Main {
    public static void main(String[] args) {
        FluxoDeAtendimento fluxoDeAtendimento = new FluxoDeAtendimento();

        // Mesas do restaurante
        Mesa[] mesas = {
                new Mesa(1, 2, 0),
                new Mesa(2, 4, 0),
                new Mesa(3, 6, 0),
        };

        // Clientes
        Cliente cliente1 = new Cliente("Alice", 1, 2);
        Cliente cliente2 = new Cliente("Bob", 2, 4);

        // Funcionários
        Funcionario garcom = new Funcionario(1, "Carlos", "Garçom", "Tarde");
        Funcionario cozinheiro = new Funcionario(2, "Paula", "Cozinheiro", "Noite");

        // Pedidos
        Pedido pedido1 = new Pedido(1, "Pizza", "Recebido");
        Pedido pedido2 = new Pedido(2, "Macarrão", "Recebido");

        // Simulação do fluxo
        fluxoDeAtendimento.encaminharClienteParaMesa(cliente1, mesas);
        fluxoDeAtendimento.encaminharClienteParaMesa(cliente2, mesas);

        fluxoDeAtendimento.atenderPedidoGarcom(pedido1, garcom);
        fluxoDeAtendimento.atenderPedidoGarcom(pedido2, garcom);

        fluxoDeAtendimento.prepararPedidoCozinheiro(pedido1, cozinheiro);
        fluxoDeAtendimento.prepararPedidoCozinheiro(pedido2, cozinheiro);

        fluxoDeAtendimento.entregarPedido(pedido1, cliente1);
        fluxoDeAtendimento.fecharConta(cliente1, 100.0);
    }
}
