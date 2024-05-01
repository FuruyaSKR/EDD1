package trab_restaurante.gestão_pedidos;

public class Main {
    public static void main(String[] args) {
        Pedido filaDePedidos = new Pedido(5);
        filaDePedidos.inserirPedido(1, "Hambúrguer");
        filaDePedidos.inserirPedido(2, "Pizza");

        // Exibir pedidos realizados
        System.out.println("Pedidos realizados:");
        filaDePedidos.consultaPedidosRegistrados();

        // Atualizar pedido
        filaDePedidos.atualizarPedido(1, "Hambúrguer com batata frita");

        // Exibir pedidos realizados
        System.out.println("Lista de Pedidos atualizada:");
        filaDePedidos.consultaPedidosRegistrados();

        // Cancelar pedido
        filaDePedidos.cancelarPedido(2);

        // Exibir pedidos
        System.out.println("Lista de pedidos após o cancelamento:");
        filaDePedidos.consultaPedidosRegistrados();
    }
}
