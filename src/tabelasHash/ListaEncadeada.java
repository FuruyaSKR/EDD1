package tabelasHash;

public class ListaEncadeada {
	private Nodo inicio;

	public ListaEncadeada(String chave, String valor) {
		inicio = new Nodo(chave, valor);
	}

	public void add(String chave, String valor) {
		Nodo novo = new Nodo(chave, valor);
		novo.setProx(inicio);
		inicio = novo;
	}

	public Nodo getInicio() {
		return inicio;
	}

	public boolean vazia() {
		return inicio == null;
	}

	public void deleteComValor(String valor) {
		if (vazia()) {
			return;
		}
		if (inicio.getChave() == valor) {
			inicio = inicio.getProx();
			return;
		}
		Nodo aux = inicio;
		while (aux.getProx() != null) {
			if (aux.getProx().getChave() == valor) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
	}
}