package lista_exercicios1.exercicio_10;

public class TesteListaCircular {

	public class Main {
		public static void main(String[] args) {
			ListaCircular L1 = new ListaCircular();
			ListaCircular L2 = new ListaCircular();

			// Preenche L1 com 100 números aleatórios entre 0 e 99
			L1.preencherComAleatorios(100, 100);

			// Exibe os elementos de L1
			System.out.println("Elementos em L1:");
			L1.mostrarLista();

			// Insere os elementos de L1 em L2 de forma ordenada
			Nodo atual = L1.getinicio();
			if (atual != null) {
				do {
					L2.inserirOrdenado(atual.getDado());
					atual = atual.getProx();
				} while (atual != L1.getinicio());
			}

			// Exibe os elementos de L2
			System.out.println("Elementos em L2 (Ordenados):");
			L2.mostrarLista();

			// Calcula e exibe as estatísticas de L2
			L2.calcularEstatisticas();
		}
	}

}
