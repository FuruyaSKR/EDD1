package lista_exercicios1.exercicio_6;

public class Main {

	public static void main(String[] args) {
		ListaCircular lista1 = new ListaCircular();
		lista1.inserirFinal(1);
		lista1.inserirFinal(3);
		lista1.inserirFinal(5);

		// Criar e preencher a segunda lista circular ordenada
		ListaCircular lista2 = new ListaCircular();
		lista2.inserirFinal(2);
		lista2.inserirFinal(4);
		lista2.inserirFinal(6);

		// Combinação das listas circulares
		ListaCircular listaResultante = new ListaCircular().combinarListas(lista1, lista2);

		// Exibir a lista resultante
		System.out.println("Lista Resultante:");
		listaResultante.mostrarLista();
	}
}
