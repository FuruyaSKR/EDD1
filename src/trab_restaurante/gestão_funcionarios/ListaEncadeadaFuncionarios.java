package trab_restaurante.gestão_funcionarios;

public class ListaEncadeadaFuncionarios {
    private Funcionario inicio;

    // construtor
    public ListaEncadeadaFuncionarios() {
        inicio = null;
    }

    public boolean vazia() {
        return inicio == null;
    }

    // Cadastro de novos funcionários
    public void cadastrarFuncionario(int id, String nome, String cargo, String escala) {
        Funcionario novoNodo = new Funcionario(id, nome, cargo, escala);
        if (inicio == null) {
            inicio = novoNodo;
        } else {
            Funcionario atual = inicio;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novoNodo);
        }
    }

    // Remoção de funcionários
    public void removerFuncionario(int id) {
        if (vazia()) {
            return;
        }
        if (inicio.getId() == id) {
            inicio = inicio.getProx();
            return;
        }
        Funcionario aux = inicio;
        while (aux.getProx() != null) {
            if (aux.getProx().getId() == id) {
                aux.setProx(aux.getProx().getProx());
                return;
            }
            aux = aux.getProx();
        }
    }

    // Escala de trabalho dos funcionários
    public void atualizarEscala(int id, String novaEscala) {
        Funcionario atual = inicio;
        while (atual != null) {
            if (atual.getId() == id) {
                atual.setEscala(novaEscala);
            }
            atual = atual.getProx();
        }
    }

    // Consulta de funcionários cadastrados
    public void consultarFuncionario() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        Funcionario aux = inicio;
        while (aux != null) {
            System.out.println("Funcionario ID: " + aux.getId() + ", Nome: " + aux.getNome()
                    + ", Cargo: " + aux.getCargo() + ", Escala: " + aux.getEscala());
            aux = aux.getProx();
        }
    }
}
