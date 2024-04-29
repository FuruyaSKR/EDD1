package lista_exercicios1.exercicio_6;

public class TesteListaCircular {

	public static void main(String[] args) {
		ListaCircular lista1 = new ListaCircular();
		ListaCircular lista2 = new ListaCircular();

		// Supondo métodos de inserção ordenada e de exibição já implementados...
		lista1.inserirOrdenado(2);
		lista1.inserirOrdenado(7);
		lista1.inserirOrdenado(5);
		lista1.mostrarLista();

		lista2.inserirOrdenado(6);
		lista2.inserirOrdenado(1);
		lista2.inserirOrdenado(4);
		lista2.mostrarLista();

		ListaCircular listaCombinada = ListaCircular.combinarListas(lista1, lista2);
		listaCombinada.mostrarLista();
	}

}
