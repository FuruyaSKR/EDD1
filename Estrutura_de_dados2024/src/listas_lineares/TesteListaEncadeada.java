package listas_lineares;

public class TesteListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        // Testando o método inserir, ele sempre incrementa no inicio da lista
        lista.inserirInicio(4);
        lista.inserirFinal(10);
        lista.inserirFinal(5);
        lista.inserirInicio(7);

        lista.mostrarLista();
        
        //Testando a remoção do primeiro nodo da lista
        lista.removerInicio();
        lista.mostrarLista();
        
        //Testando remover o ultimo nodo da lista
        lista.removerFinal();
        lista.mostrarLista();
        
        //Procura um valor na lista
        System.out.println(lista.buscarValor(4));
        
    }
}