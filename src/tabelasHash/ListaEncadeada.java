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
}