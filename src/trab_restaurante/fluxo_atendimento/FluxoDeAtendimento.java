package trab_restaurante.fluxo_atendimento;

import trab_restaurante.gestão_cliente.Cliente;
import trab_restaurante.gestão_funcionarios.Funcionario;
import trab_restaurante.gestão_mesas.Mesa;
import trab_restaurante.gestão_pedidos.Pedido;

public class FluxoDeAtendimento {
    private int numPessoasFilaAlmoco = 0;
    private int numPessoasFilaCaixa = 0;
    private int numPessoasRestaurante = 0;
    private int numPessoasAtendidas = 0;

    public int getNumPessoasFilaAlmoco() {
        return numPessoasFilaAlmoco;
    }

    public void setNumPessoasFilaAlmoco(int numPessoasFilaAlmoco) {
        this.numPessoasFilaAlmoco = numPessoasFilaAlmoco;
    }

    public int getNumPessoasFilaCaixa() {
        return numPessoasFilaCaixa;
    }

    public void setNumPessoasFilaCaixa(int numPessoasFilaCaixa) {
        this.numPessoasFilaCaixa = numPessoasFilaCaixa;
    }

    public int getNumPessoasRestaurante() {
        return numPessoasRestaurante;
    }

    public void setNumPessoasRestaurante(int numPessoasRestaurante) {
        this.numPessoasRestaurante = numPessoasRestaurante;
    }

    public int getNumPessoasAtendidas() {
        return numPessoasAtendidas;
    }

    public void setNumPessoasAtendidas(int numPessoasAtendidas) {
        this.numPessoasAtendidas = numPessoasAtendidas;
    }

    // Incrementa o número de pessoas na fila para almoçar
    public void incrementarFilaAlmoco(int numPessoas) {
        numPessoasFilaAlmoco += numPessoas;
    }

    // Incrementa o número de pessoas na fila do caixa
    public void incrementarFilaCaixa(int numPessoas) {
        numPessoasFilaCaixa += numPessoas;
    }

    // Incrementa o número de pessoas no restaurante almoçando
    public void incrementarPessoasRestaurante(int numPessoas) {
        numPessoasRestaurante += numPessoas;
    }

    // Incrementa o número de pessoas atendidas no restaurante
    public void incrementarPessoasAtendidas(int numPessoas) {
        numPessoasAtendidas += numPessoas;
    }

    // Informar quantas mesas estão livres
    public int getNumMesasLivres(Mesa[] mesas) {
        int numMesasLivres = 0;
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada()) {
                numMesasLivres++;
            }
        }
        return numMesasLivres;
    }

    // Encaminhamento de clientes para mesas disponíveis
    public void encaminharClienteParaMesa(Cliente cliente, Mesa[] mesas) {
        for (Mesa mesa : mesas) {
            if (!mesa.isOcupada() && mesa.getCapacidade() >= cliente.getTotalPessoas()) {
                mesa.setOcupada(true);
                mesa.setCliente(cliente);
                incrementarFilaAlmoco(-cliente.getTotalPessoas());
                incrementarPessoasRestaurante(cliente.getTotalPessoas());
                System.out.println("Cliente " + cliente.getNome() + " foi encaminhado para a mesa " + mesa.getNumero());
                return;
            }
        }
        System.out.println("Nenhuma mesa disponível para " + cliente.getTotalPessoas() + " pessoas.");
    }

    // Atendimento de pedidos pelos garçons
    public void atenderPedidoGarcom(Pedido pedido, Funcionario garcom) {
        if (garcom.getCargo().equals("Garçom")) {
            System.out.println("Pedido " + pedido.getDescricao() + " foi atendido pelo garçom " + garcom.getNome());
        } else {
            System.out.println(garcom.getNome() + " não é um garçom.");
        }
    }

    // Preparação de pedidos pelos cozinheiros
    public void prepararPedidoCozinheiro(Pedido pedido, Funcionario cozinheiro) {
        if (cozinheiro.getCargo().equals("Cozinheiro")) {
            System.out.println("Pedido " + pedido.getDescricao() + " está sendo preparado pelo cozinheiro "
                    + cozinheiro.getNome());
            pedido.setStatus("Em preparação");
        } else {
            System.out.println(cozinheiro.getNome() + " não é um cozinheiro.");
        }
    }

    // Entrega de pedidos aos clientes
    public void entregarPedido(Pedido pedido, Cliente cliente) {
        if (pedido.getStatus().equals("Em preparação")) {
            pedido.setStatus("Entregue");
            incrementarPessoasAtendidas(cliente.getTotalPessoas());
            System.out.println("Pedido " + pedido.getDescricao() + " foi entregue ao cliente " + cliente.getNome());
        } else {
            System.out.println("Pedido " + pedido.getDescricao() + " ainda não está pronto para entrega.");
        }
    }

    // Cobrança e fechamento de contas
    public void fecharConta(Cliente cliente, double valor) {
        System.out.println("Cliente " + cliente.getNome() + " fechou a conta no valor de " + valor);
    }

}
