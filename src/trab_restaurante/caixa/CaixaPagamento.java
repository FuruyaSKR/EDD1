package trab_restaurante.caixa;

import trab_restaurante.gestão_cliente.Cliente;

public class CaixaPagamento {
    private double totalRecebido;

    public CaixaPagamento() {
        this.totalRecebido = 0;
    }

    // a. Registro de pagamentos realizados pelos clientes
    public void registrarPagamento(Cliente cliente, double valorPago) {
        this.totalRecebido += valorPago;
        System.out.println("Pagamento registrado para " + cliente.getNome() + ": " + valorPago);
    }

    // b. Cálculo de troco, se necessário
    public double calcularTroco(double valorPago, double totalConta) {
        return valorPago - totalConta;
    }

    // c. Emissão de recibos ou comprovantes de pagamento
    public void emitirRecibo(Cliente cliente, double valorPago, double totalConta) {
        double troco = calcularTroco(valorPago, totalConta);
        System.out.println("Recibo de Pagamento");
        System.out.println("--------------------");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Total da Conta: " + totalConta);
        System.out.println("Valor Pago: " + valorPago);
        System.out.println("Troco: " + troco);
        System.out.println("--------------------");
    }

    // d. Consulta de histórico de pagamentos realizados
    public void consultarHistorico() {
        System.out.println("Total recebido no caixa: " + totalRecebido);
    }
}
