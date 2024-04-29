package lista_exercicios1.exercicio_9;

public class ListaEncadeada {

    private Nodo inicio;

    // construtor
    public ListaEncadeada() {
        inicio = null;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void inserirInicio(int dado, String nome, double salario) {
        Nodo novoNodo = new Nodo(dado, nome, salario);
        novoNodo.setProx(inicio);
        inicio = novoNodo;
    }

    public void mostrarLista() {
        if (inicio == null) {
            System.out.println("Lista Vazia");
            return;
        }
        Nodo aux = inicio;
        while (aux != null) {
            System.out.println("ID: " + aux.dado + ", Nome: " + aux.nome + ", Salário: R$" + aux.salario);
            aux = aux.prox;
        }
        System.out.println("");
    }

    public void deleteComValor(int valor) {
        if (vazia()) {
            return;
        }
        if (inicio.getDado() == valor) {
            inicio = inicio.getProx();
            return;
        }
        Nodo aux = inicio;
        while (aux.getProx() != null) {
            if (aux.getProx().getDado() == valor) {
                aux.setProx(aux.getProx().getProx());
                return;
            }
            aux = aux.getProx();
        }
    }

    public void inserirFinal(int dado, String nome, double salario) {
        if (vazia()) {
            inserirInicio(dado, nome, salario);
            return;
        }
        Nodo novoNodo = new Nodo(dado, nome, salario);
        Nodo aux = inicio;
        while (aux.getProx() != null) {
            aux = aux.getProx();
        }
        aux.setProx(novoNodo);
    }

    public void removerInicio() {
        if (!vazia()) {
            inicio = inicio.getProx();
        }
    }

    public void removerFinal() {
        if (inicio != null) {
            if (inicio.getProx() == null) {
                inicio = null;
            } else {
                Nodo temp = inicio;
                while (temp.getProx().getProx() != null) {
                    temp = temp.getProx();
                }
                temp.setProx(null);
            }
        }
    }

    public String buscarValor(int valor) {
        Nodo temp = inicio;
        int posicao = 0;
        while (temp != null) {
            if (temp.getDado() == valor) {
                return "O valor está na posição: " + posicao;
            }
            temp = temp.getProx();
            posicao++;
        }
        return "Não contém na lista";
    }

    public void inserirOrdenado(int dado, String nome, double salario) {
        Nodo novo = new Nodo(dado, nome, salario); // Cria um novo nodo com as informações fornecidas
        // Verifica se a lista está vazia ou se o novo nodo deve ser inserido no início
        if (inicio == null || inicio.salario > salario) {
            novo.prox = inicio;
            inicio = novo;
        } else {
            Nodo atual = inicio;
            // Percorre a lista até encontrar a posição correta para inserção
            while (atual.prox != null && atual.prox.salario <= salario) {
                atual = atual.prox;
            }
            novo.prox = atual.prox; // Insere o novo nodo na posição encontrada
            atual.prox = novo;
        }
    }

    public void exibirMaiorSalario() {
        if (inicio == null) {
            System.out.println("Lista vazia."); // Verifica se a lista está vazia
            return;
        }
        double maiorSalario = Double.MIN_VALUE;
        // Primeira iteração para encontrar o maior salário
        for (Nodo f = inicio; f != null; f = f.prox) {
            if (f.salario > maiorSalario) {
                maiorSalario = f.salario;
            }
        }
        System.out.println("Funcionário(s) com o maior salário:");
        // Segunda iteração para exibir todos os funcionários com o maior salário
        // encontrado
        for (Nodo f = inicio; f != null; f = f.prox) {
            if (f.salario == maiorSalario) {
                System.out.println(f.nome + " - " + f.salario);
            }
        }
    }

    public double calcularMediaSalarial() {
        if (inicio == null) {
            System.out.println("Lista vazia."); // Verifica se a lista está vazia
            return 0;
        }
        double soma = 0;
        int contador = 0;
        // Percorre toda a lista somando os salários e contando os nodos
        for (Nodo f = inicio; f != null; f = f.prox) {
            soma += f.salario;
            contador++;
        }
        return soma / contador; // Calcula e retorna a média salarial
    }

    public void contarAcimaDe(double valor) {
        int contador = 0;
        // Percorre a lista com os funcionários com salário acima do valor especificado
        for (Nodo f = inicio; f != null; f = f.prox) {
            if (f.salario > valor) {
                contador++;
            }
        }
        // Exibe o resultado da contagem ou uma mensagem
        if (contador > 0) {
            System.out.println("Quantidade de funcionários com salário acima de " + valor + ": " + contador);
        } else {
            System.out.println("Nenhum funcionário com salário acima de " + valor);
        }
    }

}