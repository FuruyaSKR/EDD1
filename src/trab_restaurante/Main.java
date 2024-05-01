package trab_restaurante;

import trab_restaurante.gestão_cliente.Cliente;
import trab_restaurante.gestão_mesas.Mesa;

public class Main {
    public static void main(String[] args) {
        Cliente listaDeClientes = new Cliente();
        Mesa listaDeMesas = new Mesa();

        // Cria mesas no restaurante
        Mesa[] mesas = new Mesa[6];
        mesas[0] = listaDeMesas.criarMesa(1, 2, 0);
        mesas[1] = listaDeMesas.criarMesa(2, 2, 0);
        mesas[2] = listaDeMesas.criarMesa(3, 4, 0);
        mesas[3] = listaDeMesas.criarMesa(4, 4, 0);
        mesas[4] = listaDeMesas.criarMesa(5, 6, 0);
        mesas[5] = listaDeMesas.criarMesa(6, 6, 0);

        // Insere clientes
        Cliente[] clientes = new Cliente[6];
        clientes[0] = listaDeClientes.inserirCliente("Alice Johnson", 1, 4);
        clientes[1] = listaDeClientes.inserirCliente("Bob Smith", 2, 4);
        clientes[2] = listaDeClientes.inserirCliente("Bryan Souza", 3, 5);
        clientes[3] = listaDeClientes.inserirCliente("Arcideval Carvalho", 4, 5);
        clientes[4] = listaDeClientes.inserirCliente("Rodinei Alfredo", 5, 2);
        clientes[5] = listaDeClientes.inserirCliente("Valdecir Cardoso", 6, 3);

    }
}
