package lista_exercicios1.exercicio_7;

public class TesteListaCircular {

	public static void main(String[] args) {
		FilaDePrioridade fila = new FilaDePrioridade();

		fila.inserir(5, 2); // Dado 5 com prioridade 2
		fila.inserir(6, 3); // Dado 6 com prioridade 3 (maior prioridade, deve sair primeiro)
		fila.inserir(7, 1); // Dado 7 com prioridade 1

		fila.exibir(); // Opção para visualizar a fila antes de remover elementos

		System.out.println("\nElemento removido: " + fila.remover()); // Deve remover o elemento 6
		System.out.println("Elemento removido: " + fila.remover()); // Segue com o elemento 5
	}

}
