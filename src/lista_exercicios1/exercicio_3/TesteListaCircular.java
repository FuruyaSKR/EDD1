package lista_exercicios1.exercicio_3;

public class TesteListaCircular {

	public static void main(String[] args) {
		ListaCircular lista = new ListaCircular();

		lista.inserirInicio(10);
		lista.inserirInicio(20);
		lista.inserirInicio(30);

		System.out.println(lista.mostrarLista());
		lista.calcularEstatisticas();
	}

}
