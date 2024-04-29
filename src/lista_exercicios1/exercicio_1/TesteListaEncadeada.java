package lista_exercicios1.exercicio_1;

public class TesteListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.inserirInicio(10);
        lista.inserirFinal(20);
        lista.inserirFinal(30);
        lista.inserirFinal(20);

        lista.mostrarLista();
        System.out.println(lista.analisaLista(20));
    }
}