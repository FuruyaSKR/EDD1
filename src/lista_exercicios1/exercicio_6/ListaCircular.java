package lista_exercicios1.exercicio_6;

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

	public void mostrarLista() {
		if (inicio == null) {
			System.out.println("A lista está vazia.");
			return;
		}
		Nodo atual = inicio;
		do {
			System.out.print(atual.getDado() + " ");
			atual = atual.getProx();
		} while (atual != inicio);
		System.out.println(); // Quebra de linha no final para separar as listas
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

	public void inserirOrdenado(int valor) {
		Nodo novoNodo = new Nodo(valor);
		if (inicio == null) {
			inicio = novoNodo;
			fim = novoNodo;
			fim.setProx(inicio);
		} else if (valor <= inicio.getDado()) { // Inserção antes do início
			novoNodo.setProx(inicio);
			fim.setProx(novoNodo);
			inicio = novoNodo;
		} else {
			Nodo atual = inicio;
			while (atual.getProx() != inicio && atual.getProx().getDado() < valor) {
				atual = atual.getProx();
			}
			novoNodo.setProx(atual.getProx());
			atual.setProx(novoNodo);
			if (atual == fim) {
				fim = novoNodo; // Atualização do fim se necessário
			}
		}
	}

	public static ListaCircular combinarListas(ListaCircular lista1, ListaCircular lista2) {
		ListaCircular listaCombinada = new ListaCircular();
		Nodo atual1 = lista1.inicio;
		Nodo atual2 = lista2.inicio;

		// Verifica se alguma das listas está vazia e retorna a outra como resultado
		if (atual1 == null) {
			return copiarLista(lista2);
		} else if (atual2 == null) {
			return copiarLista(lista1);
		}

		do {
			if (atual1.getDado() <= atual2.getDado()) {
				listaCombinada.inserirOrdenado(atual1.getDado());
				atual1 = (atual1.getProx() != lista1.inicio) ? atual1.getProx() : null;
			} else {
				listaCombinada.inserirOrdenado(atual2.getDado());
				atual2 = (atual2.getProx() != lista2.inicio) ? atual2.getProx() : null;
			}

			// Se um dos ponteiros alcançar o fim da lista, insere o restante da outra lista
			if (atual1 == null) {
				do {
					listaCombinada.inserirOrdenado(atual2.getDado());
					atual2 = (atual2.getProx() != lista2.inicio) ? atual2.getProx() : null;
				} while (atual2 != null);
				break; // Sai do loop principal após inserir todos os elementos restantes
			} else if (atual2 == null) {
				do {
					listaCombinada.inserirOrdenado(atual1.getDado());
					atual1 = (atual1.getProx() != lista1.inicio) ? atual1.getProx() : null;
				} while (atual1 != null);
				break; // Sai do loop principal após inserir todos os elementos restantes
			}
		} while (atual1 != null || atual2 != null);

		return listaCombinada;
	}

	// Método auxiliar para copiar os elementos de uma lista circular existente
	private static ListaCircular copiarLista(ListaCircular lista) {
		ListaCircular novaLista = new ListaCircular();
		if (lista.inicio == null) {
			return novaLista; // Retorna uma nova lista vazia se a lista original estiver vazia
		}
		Nodo atual = lista.inicio;
		do {
			novaLista.inserirOrdenado(atual.getDado());
			atual = atual.getProx();
		} while (atual != lista.inicio);

		return novaLista;
	}
}
