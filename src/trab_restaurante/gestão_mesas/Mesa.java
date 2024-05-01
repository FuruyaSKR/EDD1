package trab_restaurante.gestão_mesas;

import trab_restaurante.gestão_cliente.Cliente;

public class Mesa {
    private int numero;
    private int capacidade;
    private int pessoas;
    private boolean ocupada;
    private Cliente cliente;
    private Mesa prox;

    public Mesa(int numero, int capacidade, int pessoas) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.ocupada = false;
        this.pessoas = pessoas;
        this.prox = null;
    }

    // Getters e setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Mesa getProx() {
        return prox;
    }

    public void setProx(Mesa prox) {
        this.prox = prox;
    }

    public int getPessoas() {
        return pessoas;
    }

    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
