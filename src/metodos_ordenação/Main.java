package metodos_ordenação;

public class Main {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort(0, 0, 0);
		int tamanho1 = 100000;
		int tamanho2 = 1000000;

		bubbleSort.executarTestes(tamanho1);
		bubbleSort.executarTestes(tamanho2);

	}

}