package trab_restaurante.gestão_mesas;

import trab_restaurante.gestão_cliente.Cliente;

public class Main {
    public static void main(String[] args) {

        Mesa listaDeMesas = new Mesa();
        Cliente listaDeClientes = new Cliente();

        // Insere clientes
        Cliente cliente1 = listaDeClientes.inserirCliente("Alice Johnson", 1, 2);
        Cliente cliente2 = listaDeClientes.inserirCliente("Bob Smith", 2, 5);
        Cliente cliente3 = listaDeClientes.inserirCliente("Bryan Souza", 3, 6);

        // Cria as nesas do restaurante
        listaDeMesas.criarMesa(1, 4, 0);
        listaDeMesas.criarMesa(2, 6, 0);

        // Status das Mesas após criação
        listaDeMesas.consultarMesas();

        // Alocar (ocupar) a mesa de número 1
        listaDeMesas.alocarMesaParaClientes(cliente1);
        listaDeMesas.alocarMesaParaClientes(cliente2);
        listaDeMesas.alocarMesaParaClientes(cliente3);

        // Status das Mesas após ocupação da mesa 1
        listaDeMesas.consultarMesas();

        // Status das Mesas após desocupar a mesa 1
        listaDeMesas.liberarMesa(2);
        listaDeMesas.consultarMesas();
    }
}
