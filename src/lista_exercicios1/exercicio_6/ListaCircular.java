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
	
	public boolean vazia() {
		return inicio == null;
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
		if (inicio == null)
			return;
		if (inicio.getDado() == dado) {
			if (inicio == fim) { //se a lista tiver somente 1 elemento
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
	
	public void inserirFinal(int dado) {
		Nodo novoNodo = new Nodo(dado);
		if (vazia()) {
			inicio = novoNodo;
			inicio.setProx(inicio); // Lista circular, o próximo do último nó aponta para o primeiro
		} else {
			Nodo aux = inicio;
			while (aux.getProx() != inicio) {
				aux = aux.getProx();
			}
			aux.setProx(novoNodo);
			novoNodo.setProx(inicio); // O próximo do novo nó aponta para o primeiro
		}
	}

	public ListaCircular combinarListas(ListaCircular lista1, ListaCircular lista2) {
        ListaCircular listaResultante = new ListaCircular();
        
        Nodo nodoLista1 = lista1.getinicio();
        Nodo nodoLista2 = lista2.getinicio();
        
        while (nodoLista1 != null || nodoLista2 != null) {
            if (nodoLista1 == null) {
                listaResultante.inserirFinal(nodoLista2.getDado());
                nodoLista2 = nodoLista2.getProx();
            } else if (nodoLista2 == null) {
                listaResultante.inserirFinal(nodoLista1.getDado());
                nodoLista1 = nodoLista1.getProx();
            } else {
                int dadoLista1 = nodoLista1.getDado();
                int dadoLista2 = nodoLista2.getDado();
                
                if (dadoLista1 < dadoLista2) {
                    listaResultante.inserirFinal(dadoLista1);
                    nodoLista1 = nodoLista1.getProx();
                } else {
                    listaResultante.inserirFinal(dadoLista2);
                    nodoLista2 = nodoLista2.getProx();
                }
            }
        }
        
        return listaResultante;
    }

}
