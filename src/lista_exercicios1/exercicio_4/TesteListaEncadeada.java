package lista_exercicios1.exercicio_4;

public class TesteListaEncadeada {
    public static void main(String[] args) {
        ListaEncadeada conjuntoA = new ListaEncadeada();
        ListaEncadeada conjuntoB = new ListaEncadeada();

        // Adicionando elementos aos conjuntos
        conjuntoA.inserirFinal(1);
        conjuntoA.inserirFinal(2);
        conjuntoA.inserirFinal(3);
        conjuntoB.inserirFinal(3);
        conjuntoB.inserirFinal(4);
        conjuntoB.inserirFinal(5);

        ListaEncadeada uniao = conjuntoA.uniao(conjuntoB);
        ListaEncadeada interseccao = conjuntoA.interseccao(conjuntoB);
        ListaEncadeada diferenca = conjuntoA.diferenca(conjuntoB);

        System.out.println("União: ");
        uniao.mostrarLista();
        System.out.println("Intersecção: ");
        interseccao.mostrarLista();
        System.out.println("Diferença: ");
        diferenca.mostrarLista();
    }

}