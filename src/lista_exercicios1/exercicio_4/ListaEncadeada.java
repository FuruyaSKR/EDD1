package lista_exercicios1.exercicio_4;

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

    /**
     * Realiza a união de dois conjuntos.
     */
    public ListaEncadeada uniao(ListaEncadeada outroConjunto) {
        ListaEncadeada resultado = new ListaEncadeada();
        Nodo atual = this.inicio;
        while (atual != null) {
            resultado.inserirFinal(atual.getDado()); // Insere elementos do primeiro conjunto
            atual = atual.getProx();
        }
        atual = outroConjunto.inicio;
        while (atual != null) {
            if (!resultado.contem(atual.getDado())) {
                resultado.inserirFinal(atual.getDado()); // Insere elementos do segundo conjunto se não presentes
            }
            atual = atual.getProx();
        }
        return resultado;
    }

    /**
     * Realiza a intersecção de dois conjuntos.
     */
    public ListaEncadeada interseccao(ListaEncadeada outroConjunto) {
        ListaEncadeada resultado = new ListaEncadeada();
        Nodo atual = this.inicio;
        while (atual != null) {
            if (outroConjunto.contem(atual.getDado())) {
                resultado.inserirFinal(atual.getDado()); // Insere elementos comuns a ambos os conjuntos
            }
            atual = atual.getProx();
        }
        return resultado;
    }

    /**
     * Realiza a diferença entre dois conjuntos.
     */
    public ListaEncadeada diferenca(ListaEncadeada outroConjunto) {
        ListaEncadeada resultado = new ListaEncadeada();
        Nodo atual = this.inicio;
        while (atual != null) {
            if (!outroConjunto.contem(atual.getDado())) {
                resultado.inserirFinal(atual.getDado()); // Insere elementos do primeiro conjunto não presentes no
                                                         // segundo
            }
            atual = atual.getProx();
        }
        return resultado;
    }

    // Método para verificar se um elemento está contido na lista
    private boolean contem(int valor) {
        Nodo atual = this.inicio;
        while (atual != null) {
            if (atual.getDado() == valor) {
                return true;
            }
            atual = atual.getProx();
        }
        return false;
    }
}