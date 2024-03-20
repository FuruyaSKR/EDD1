package listas_lineares;

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
		if(inicio == null) { //Caso a lista esteja vazia
			inicio = novoNodo;
			inicio.setProx(inicio);
			fim = inicio;
		}else {//Caso a lista não esteja vazia
			novoNodo.setProx(inicio);
			inicio = novoNodo;
			fim.setProx(inicio);
		}
	}
	
	public String mostrarLista() {
		String lista = "";
		if(inicio == null) return lista;
		Nodo aux = inicio;
		do {
			lista += aux.getDado()+"\n";
			aux = aux.getProx();	
		}while (aux != inicio);
		return lista;
	}

	public void deleteComValor(int dado) {
		if(inicio == null) return;
		if(inicio.getDado() == dado) {
			if(inicio == fim) { //se a lista tiver somente 1 elemento
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
			if(aux.getProx().getDado() == dado) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}while (aux != inicio);
	}

	
}
