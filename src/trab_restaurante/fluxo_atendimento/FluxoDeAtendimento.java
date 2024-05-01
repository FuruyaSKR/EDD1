package trab_restaurante.fluxo_atendimento;

import trab_restaurante.gestão_cliente.Cliente;
import trab_restaurante.gestão_cliente.ListaEncadeadaClientes;
import trab_restaurante.gestão_mesas.ListaEncadeadaMesas;

public class FluxoDeAtendimento {

    // Método para encaminhar todos os clientes para mesas disponíveis
    public void encaminharClientesParaMesas(ListaEncadeadaMesas listaMesas, ListaEncadeadaClientes listaClientes) {
        Cliente nodoCliente = listaClientes.getInicio(); // Supomos que existe um método getInicio()
        while (nodoCliente != null) {
            Cliente cliente = nodoCliente.getProx();
            boolean alocado = listaMesas.alocarMesaParaClientes(cliente); // Usando o método da lista de mesas

            if (!alocado) {
                System.out.println("Nenhuma mesa disponível para " + cliente.getTotalPessoas() + " pessoas.");
            }

            nodoCliente = nodoCliente.getProx(); // Avança para o próximo cliente
        }
    }

}
