package lista_exercicios1.exercicio_1;

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

    public void inserirInicio(int dado) {
        Nodo novoNodo = new Nodo(dado);
        novoNodo.setProx(inicio);
        inicio = novoNodo;
    }

    public void mostrarLista() {
        if (vazia()) {
            System.out.println("Lista Vazia");
            return;
        }
        Nodo aux = inicio;
        while (aux != null) {
            System.out.println(aux.getDado() + " ");
            aux = aux.getProx();
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

    public void inserirFinal(int dado) {
        if (vazia()) {
            inserirInicio(dado);
            return;
        }
        Nodo novoNodo = new Nodo(dado);
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

    public String analisaLista(int valor) {
        Nodo atual = inicio;
        int totalNodos = 0, nodosComValor = 0, nodosMaiorValor = 0;
        String posicoesComValor = "";

        int posicaoAtual = 0;
        while (atual != null) {
            totalNodos++; // Contagem do total de nodos
            if (atual.getDado() == valor) {
                nodosComValor++; // Contagem de nodos com o valor especificado
                if (!posicoesComValor.isEmpty()) {
                    posicoesComValor += ", ";
                }
                posicoesComValor += posicaoAtual; // Armazenando a posição do nodo com valor
            } else if (atual.getDado() > valor) {
                nodosMaiorValor++; // Contagem de nodos com valor superior ao especificado
            }
            atual = atual.getProx(); // Movendo para o próximo nodo
            posicaoAtual++;
        }

        // Construção da string de resultado
        String resultado = "Total de Nodos: " + totalNodos +
                "\nNodos com o valor " + valor + ": " + nodosComValor +
                (nodosComValor > 0 ? "\nPosições dos nodos com o valor: " + posicoesComValor : "") +
                "\nNodos com valor maior que " + valor + ": " + nodosMaiorValor;
        return resultado;
    }
}