package lista_exercicios1.exercicio_2;

public class ListaCircular {
    private Nodo inicio;
    private Nodo fim;

    public ListaCircular() {
        inicio = null;
    }

    public Nodo getinicio() {
        return inicio;
    }

    public void deleteComValor(int codigoProduto) {
        if (inicio == null)
            return;

        if (inicio.getProduto().getCodigo() == codigoProduto) {
            if (inicio == fim) {
                inicio = null;
                fim = null;
                return;
            }
            inicio = inicio.getProx();
            fim.setProx(inicio);
            return;
        }

        Nodo atual = inicio;
        Nodo anterior = null;
        do {
            if (atual.getProduto().getCodigo() == codigoProduto) {
                if (atual == fim) {
                    fim = anterior;
                }
                anterior.setProx(atual.getProx());
                return;
            }
            anterior = atual;
            atual = atual.getProx();
        } while (atual != inicio);
    }

    public void inserirInicio(Produto produto) {
        Nodo novoNodo = new Nodo(produto);
        if (inicio == null) {
            inicio = novoNodo;
            inicio.setProx(inicio);
            fim = inicio;
        } else {
            novoNodo.setProx(inicio);
            inicio = novoNodo;
            fim.setProx(inicio);
        }
    }

    public String mostrarLista() {
        String lista = "";
        if (inicio == null)
            return lista;
        Nodo aux = inicio;
        do {
            Produto produto = aux.getProduto();
            lista += "Codigo: " + produto.getCodigo() + ", Preco: " + produto.getPreco() + ", Quantidade: "
                    + produto.getQuantidadeEstocada() + "\n";
            aux = aux.getProx();
        } while (aux != inicio);
        return lista;
    }

    public void aplicarDesconto(double taxaDesconto) {
        if (inicio == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        int contadorProdutosMais100 = 0; // Inicializa contador para produtos com quantidade maior que 100
        Nodo atual = inicio;

        System.out.println("\nRelatório de Produtos com Desconto:"); // Imprime cabeçalho do relatório

        // Percorre todos os nodos da lista circular
        do {
            Produto produto = atual.getProduto();

            // Calcula o novo preço com o desconto aplicado
            double novoPreco = produto.getPreco() * (1 - taxaDesconto / 100);
            // Atualiza o preço do produto na lista
            produto.setPreco(novoPreco);

            // Imprime o código do produto e o novo preço formatado
            System.out.println("Código: " + produto.getCodigo() + ", Novo Preço: " + String.format("%.2f", novoPreco));

            // Verifica se o produto possui estoque maior que 100
            if (produto.getQuantidadeEstocada() > 100) {
                contadorProdutosMais100++;
            }
            atual = atual.getProx();
        } while (atual != inicio);

        // Imprime o total de produtos com estoque maior que 100
        System.out.println("Quantidade de produtos com estoque maior que 100: " + contadorProdutosMais100);
    }

}
