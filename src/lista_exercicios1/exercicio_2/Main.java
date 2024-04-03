package lista_exercicios1.exercicio_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Criação da lista circular
        ListaCircular listaDeProdutos = new ListaCircular();
    
        // Criação de produtos
        Produto produto1 = new Produto(1, 29.99, 101);
        Produto produto2 = new Produto(2, 59.99, 50);
        Produto produto3 = new Produto(3, 125.99, 20);

        // Inserção de produtos na lista
        listaDeProdutos.inserirInicio(produto1);
        listaDeProdutos.inserirInicio(produto2);
        listaDeProdutos.inserirInicio(produto3);

        // Mostrar todos os produtos
        System.out.println("Produtos cadastrados na lista:");
        System.out.println(listaDeProdutos.mostrarLista());

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a taxa de desconto (ex: 10 para 10%): ");
        double taxaDesconto = scanner.nextDouble();
        
        // Aplicar desconto e mostrar relatório
        listaDeProdutos.aplicarDesconto(taxaDesconto);
        
        scanner.close();
    }
}
