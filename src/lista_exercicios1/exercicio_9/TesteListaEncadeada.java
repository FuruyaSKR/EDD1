package lista_exercicios1.exercicio_9;

public class TesteListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserirOrdenado(1, "Alice", 3000);
        lista.inserirOrdenado(2, "Bob", 4000);
        lista.inserirOrdenado(3, "Marina", 7000);
        lista.inserirOrdenado(5, "Thomas", 7000);
        lista.inserirOrdenado(4, "Arturo", 14000);

        lista.mostrarLista();

        lista.exibirMaiorSalario();
        System.out.println("Média salarial: " + lista.calcularMediaSalarial());

        lista.contarAcimaDe(3500);
    }
}