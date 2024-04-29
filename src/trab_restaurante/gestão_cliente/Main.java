package trab_restaurante.gestão_cliente;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada listaDeClientes = new ListaEncadeada();

        // Insere clientes
        listaDeClientes.inserirCliente("Alice Johnson", 1);
        listaDeClientes.inserirCliente("Bob Smith", 2);

        System.out.println("\nLista de clientes atual:");
        listaDeClientes.consultarClientes();

        // Atualizar cliente
        System.out.println("Cliente atualizado com sucesso:");
        listaDeClientes.atualizarNomeCliente(1, "Alice B. Johnson");
        listaDeClientes.consultarClientes();

        // Remover cliente
        System.out.println("Cliente removido com sucesso:");
        listaDeClientes.removerClienteCadastrado(2);
        listaDeClientes.consultarClientes();

        // Exibir clientes
        System.out.println("Clientes cadastrados após atualizações:");
        listaDeClientes.consultarClientes();

    }
}
