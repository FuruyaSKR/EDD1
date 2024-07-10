package metodos_ordenação;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BubbleSort {

    private long comparacoes;
    private long trocas;
    private double tempoExecucao;

    private List<BubbleSort> metricsList1 = new ArrayList<>();
    private List<BubbleSort> metricsList2 = new ArrayList<>();

    public int[] bubbleSort(int array[]) {
        comparacoes = 0;
        trocas = 0;

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    trocas++;
                }
            }
        }
        return array;
    }

    public BubbleSort(long comparacoes, long trocas, double tempoExecucao) {
        this.comparacoes = comparacoes;
        this.trocas = trocas;
        this.tempoExecucao = tempoExecucao;
    }

    public BubbleSort calcularTempoExecucao(int[] array) {
        long inicio = System.nanoTime();
        bubbleSort(array);
        long fim = System.nanoTime();
        double tempoExecucao = (fim - inicio) / 1_000_000_000.0; // Convertendo para segundos
        return new BubbleSort(comparacoes, trocas, tempoExecucao);
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getTrocas() {
        return trocas;
    }

    public double getTempoExecucao() {
        return tempoExecucao;
    }

    public static int[] gerarArrayAleatorio(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = (int) (Math.random() * tamanho);
        }
        return array;
    }

    public static int[] gerarArrayOrdenado(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] gerarArrayInvertido(int tamanho) {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = tamanho - i;
        }
        return array;
    }

    public void executarTestes(int tamanho) {
        System.out.println("\nTestando arrays de tamanho: " + tamanho + "\n");
        testarTipoArray("Aleatório", gerarArrayAleatorio(tamanho));
        testarTipoArray("Ordenado", gerarArrayOrdenado(tamanho));
        testarTipoArray("Invertido", gerarArrayInvertido(tamanho));
        System.out.println("\n-----------------------\n");
    }

    private void testarTipoArray(String tipo, int[] array) {
        BubbleSort metrics = calcularTempoExecucao(array);
        NumberFormat formatador = NumberFormat.getInstance(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println("\nTipo de Array: " + tipo);
        System.out.println("Tempo de Execução: " + df.format(metrics.getTempoExecucao()) + " s");
        System.out.println("Comparações: " + formatador.format(metrics.getComparacoes()));
        System.out.println("Trocas: " + formatador.format(metrics.getTrocas()));
        System.out.println();
    }

    // public void criarGrafico() {
    // // Criação do gráfico
    // ChartBuilder chart = new CategoryChartBuilder().width(800).height(600)
    // .title("Comparação de Tempos de Execução").xAxisTitle("Tipo de Array")
    // .yAxisTitle("Tempo de Execução (s)").build();

    // chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
    // chart.getStyler().setHasAnnotations(true);

    // List<String> types = List.of("Aleatório", "Ordenado", "Invertido");

    // List<Double> temposExecucao1 = new ArrayList<>();
    // List<Double> temposExecucao2 = new ArrayList<>();

    // for (BubbleSort metrics : metricsList1) {
    // temposExecucao1.add(metrics.getTempoExecucao());
    // }

    // for (BubbleSort metrics : metricsList2) {
    // temposExecucao2.add(metrics.getTempoExecucao());
    // }

    // chart.addSeries("Array 100000", types, temposExecucao1);
    // chart.addSeries("Array 1000000", types, temposExecucao2);

    // try {
    // BitmapEncoder.saveBitmap(chart, "./BubbleSortComparison",
    // BitmapEncoder.BitmapFormat.PNG);
    // System.out.println("Gráfico salvo como BubbleSortComparison.png");
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
}
