package tabelasHash;

public class HashTable3 {
	private int tamArray;
	private ListaEncadeada[] array;

	public HashTable3(int tamArray) {
		this.tamArray = tamArray;
		array = new ListaEncadeada[tamArray];
	}

	private int hash(String chave) {
		byte bytesChave[] = chave.getBytes();
		int hashCode = 0;
		for (int i : bytesChave) {
			hashCode += i;
		}
		return hashCode % tamArray;
	}

	public void inserir(String chave, String valor) {
		int indiceArray = hash(chave);
		if (array[indiceArray] == null) {
			array[indiceArray] = new ListaEncadeada(chave, valor);
			return;
		}
		Nodo aux = array[indiceArray].getInicio();
		while (aux != null) {
			if (aux.getChave() == chave) {
				aux.setValor(valor);
				return;
			}
			aux = aux.getProx();
		}
		array[indiceArray].add(chave, valor);
	}

	public String recuperar(String chave) {
		int indiceArray = hash(chave);
		if (array[indiceArray] == null) {
			return null;
		}
		Nodo aux = array[indiceArray].getInicio();
		while (aux != null) {
			if (aux.getChave() == chave) {
				return aux.getValor();
			}
			aux = aux.getProx();
		}
		return null;
	}

	// Exercicio
	public boolean chaveExiste(String chave) {
		int indiceArray = hash(chave);
		if (array[indiceArray] == null) {
			return false;
		}
		Nodo aux = array[indiceArray].getInicio();
		while (aux != null) {
			if (aux.getChave().equals(chave)) {
				return true;
			}
			aux = aux.getProx();
		}
		return false;
	}

	public void deletarChave(String chave) {
		int indiceArray = hash(chave);
		array[indiceArray].deleteComValor(chave);
	}
}
