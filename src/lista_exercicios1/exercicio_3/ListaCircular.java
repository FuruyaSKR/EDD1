package lista_exercicios1.exercicio_3;

public class ListaCircular {
	private Nodo inicio;
	private Nodo fim;

	public ListaCircular() {
		inicio = null;
	}

	public Nodo getinicio() {
		return inicio;
	}

	public void inserirInicio(int dado) {
		Nodo novoNodo = new Nodo(dado);
		if (inicio == null) { // Caso a lista esteja vazia
			inicio = novoNodo;
			inicio.setProx(inicio);
			fim = inicio;
		} else {// Caso a lista não esteja vazia
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
			lista += aux.getDado() + "\n";
			aux = aux.getProx();
		} while (aux != inicio);
		return lista;
	}

	public void deleteComValor(int dado) {
		if (inicio == null)
			return;
		if (inicio.getDado() == dado) {
			if (inicio == fim) { // se a lista tiver somente 1 elemento
				inicio = null;
				return;
			}
			// se elemento for o primeiro da lista mas lista contém mais elementos
			inicio = inicio.getProx();
			fim.setProx(inicio);
			return;
		}
		Nodo aux = inicio;
		do {
			if (aux.getProx().getDado() == dado) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		} while (aux != inicio);
	}

	public void calcularEstatisticas() {
		if (inicio == null) {
			System.out.println("A lista está vazia.");
			return;
		}

		int maior = inicio.getDado();
		int menor = inicio.getDado();
		double soma = 0;
		int contador = 0;

		Nodo atual = inicio;
		do {
			int valorAtual = atual.getDado();
			soma += valorAtual; // Acumula a soma para cálculo da média
			contador++; // Incrementa o contador de elementos

			if (valorAtual > maior)
				maior = valorAtual; // Atualiza o maior valor, se necessário
			if (valorAtual < menor)
				menor = valorAtual; // Atualiza o menor valor, se necessário

			atual = atual.getProx(); // Avança para o próximo nodo
		} while (atual != inicio);

		double media = soma / contador; // Calcula a média aritmética

		// Exibe os resultados
		System.out.println("Maior elemento: " + maior);
		System.out.println("Menor elemento: " + menor);
		System.out.println("Média aritmética: " + media);
	}

}
