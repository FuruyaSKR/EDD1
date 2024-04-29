package lista_exercicios1.exercicio_8;

public class Fila {
    private Nodo inicio;
    private Nodo fim;
    private int limite;
    private int tamanho = 0;

    public Fila(int limite) {
        this.limite = limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean temEspaco() {
        return limite > tamanho;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public Integer getInicio() {
        if (!estaVazio()) {
            return inicio.getDado();

        } else {
            System.out.println("Fila está vazia!");
            return null;
        }

    }

    public void inserir(int dado) {
        if (temEspaco()) {
            Nodo novoItem = new Nodo(dado);
            if (estaVazio()) {
                inicio = novoItem;
                fim = novoItem;
            } else {
                fim.setProx(novoItem);
                fim = novoItem;
            }
            tamanho++;
        } else {
            System.out.println("Fila cheia!");
        }
    }

    public Integer remover() {
        if (estaVazio()) {
            return null;
        }
        int valor = inicio.getDado();
        inicio = inicio.getProx();
        tamanho--;
        if (estaVazio()) {
            fim = null;
        }
        return valor;
    }

    public static void separarValores(Fila F, Fila F_Impares, Fila F_Pares) {
        while (!F.estaVazio()) {
            int valor = F.remover(); // Remove o elemento do início de F
            if (valor % 2 == 0) { // Verifica se o valor é par
                F_Pares.inserir(valor); // Insere o valor na fila F_Pares
            } else { // Caso o valor seja ímpar
                F_Impares.inserir(valor); // Insere o valor na fila F_Impares
            }
        }
    }

    public void exibir() {
        if (estaVazio()) {
            System.out.println("Fila está vazia.");
            return;
        }
        Nodo atual = inicio;
        while (atual != null) {
            System.out.print(atual.getDado() + " ");
            atual = atual.getProx();
        }
        System.out.println(); // Quebra de linha no final
    }

}