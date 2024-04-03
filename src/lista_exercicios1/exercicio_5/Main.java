package lista_exercicios1.exercicio_5;


public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserirInicio(4);
        lista.inserirFinal(10);
        lista.inserirFinal(5);
        lista.inserirInicio(7);

        System.out.println("Lista em ordem normal:");
        lista.mostrarLista();

        System.out.println("Lista em ordem inversa:");
        lista.mostrarListaInversa();
        
    }
}