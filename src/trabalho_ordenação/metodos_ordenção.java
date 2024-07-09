package trabalho_ordenação;

public class metodos_ordenção {
    private int comparisons;
    private int swaps;
    private long executionTime;

    public metodos_ordenção(int limite) {
        this.limite = limite;
    }

    public int[] bubbleSort(int array[]) {
        comparisons = 0;
        swaps = 0;
        long startTime = System.currentTimeMillis();

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    // swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                }
            }
        }

        executionTime = System.currentTimeMillis() - startTime;
        return array;
    }

    public int[] selectionSort(int array[]) {
        int min, aux;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            aux = array[i];
            array[i] = array[min];
            array[min] = aux;
        }
        return array;
    }

    public int[] insertionSort(int array[]) {
        int pivo, j;
        for (int i = 1; i < array.length - 1; i++) {
            pivo = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > pivo) {
                array[j + 1] = array[j];
                j = j + 1;
            }
            array[j + 1] = pivo;
        }
        return array;
    }
}
