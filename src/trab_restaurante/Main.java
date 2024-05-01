package trab_restaurante;

import trab_restaurante.caixa.CaixaPagamento;
import trab_restaurante.fluxo_atendimento.FluxoDeAtendimento;
import trab_restaurante.gestão_cliente.Cliente;
import trab_restaurante.gestão_funcionarios.Funcionario;
import trab_restaurante.gestão_mesas.Mesa;
import trab_restaurante.gestão_pedidos.Pedido;

public class Main {
    public static void main(String[] args) {
        FluxoDeAtendimento fluxoDeAtendimento = new FluxoDeAtendimento();
        CaixaPagamento caixaPagamento = new CaixaPagamento();

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

        caixaPagamento.registrarPagamento(cliente1, 120.0);
        caixaPagamento.emitirRecibo(cliente1, 150.0, 120.0);

        // Consulta do histórico
        caixaPagamento.consultarHistorico();

        // Exibindo estatísticas
        System.out.println("Pessoas na fila para almoçar: " + fluxoDeAtendimento.getNumPessoasFilaAlmoco());
        System.out.println("Pessoas na fila do caixa: " + fluxoDeAtendimento.getNumPessoasFilaCaixa());
        System.out.println("Pessoas no restaurante almoçando: " + fluxoDeAtendimento.getNumPessoasRestaurante());
        System.out.println("Pessoas atendidas no restaurante: " + fluxoDeAtendimento.getNumPessoasAtendidas());
        System.out.println("Mesas livres: " + fluxoDeAtendimento.getNumMesasLivres(mesas));
    }
}
