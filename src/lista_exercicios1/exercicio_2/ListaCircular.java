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
            System.out.println("A lista esta vazia.");
            return;
        }
        
        int contadorProdutosMais100 = 0;
        Nodo atual = inicio;
        
        System.out.println("\nRelatorio de Produtos com Desconto:");
        do {
            Produto produto = atual.getProduto();
            double novoPreco = produto.getPreco() * (1 - taxaDesconto / 100);
            produto.setPreco(novoPreco); 
            
            System.out.println("Codigo: " + produto.getCodigo() + ", Novo Preco: " + String.format("%.2f", novoPreco));
            
            if (produto.getQuantidadeEstocada() > 100) {
                contadorProdutosMais100++;
            }
            
            atual = atual.getProx();
        } while (atual != inicio);
        
        System.out.println("Quantidade de produtos com estoque maior que 100: " + contadorProdutosMais100);
    }
	
}
