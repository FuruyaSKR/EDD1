package lista_exercicios1.exercicio_8;

public class Main {

	public static void main(String[] args) {
		Fila F = new Fila(5);
		Fila F_Impares = new Fila(5);
		Fila F_Pares = new Fila(5);

		// Adicionando elementos à fila F
		F.inserir(1);
		F.inserir(2);
		F.inserir(3);
		F.inserir(4);
		F.inserir(5);

		System.out.println("Fila original:");
		F.exibir();
		// Chamada do método para separar os valores
		Fila.separarValores(F, F_Impares, F_Pares);

		// Supondo a existência de um método exibir para visualizar os elementos da fila
		System.out.println("Fila de Ímpares:");
		F_Impares.exibir();
		System.out.println("Fila de Pares:");
		F_Pares.exibir();
	}

}
