package lista_exercicios1.exercicio_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ListaCircular {
	private Nodo inicio;
	private Nodo fim;

	public ListaCircular() {
		inicio = null;
	}

	public Nodo getinicio() {
		return inicio;
	}

	public void inserirInicio(int dado) {
		Nodo novoNodo = new Nodo(dado);
		if (inicio == null) { // Caso a lista esteja vazia
			inicio = novoNodo;
			inicio.setProx(inicio);
			fim = inicio;
		} else {// Caso a lista não esteja vazia
			novoNodo.setProx(inicio);
			inicio = novoNodo;
			fim.setProx(inicio);
		}
	}

	public void mostrarLista() {
		if (inicio == null) {
			System.out.println("A lista está vazia.");
			return;
		}
		Nodo aux = inicio;
		do {
			System.out.print(aux.getDado() + " ");
			aux = aux.getProx();
		} while (aux != inicio);
		System.out.println();
	}

	public void deleteComValor(int dado) {
		if (inicio == null)
			return;
		if (inicio.getDado() == dado) {
			if (inicio == fim) { // se a lista tiver somente 1 elemento
				inicio = null;
				return;
			}
			// se elemento for o primeiro da lista mas lista contém mais elementos
			inicio = inicio.getProx();
			fim.setProx(inicio);
			return;
		}
		Nodo aux = inicio;
		do {
			if (aux.getProx().getDado() == dado) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		} while (aux != inicio);
	}

	public void preencherComAleatorios(int quantidade, int valor) {
		Random random = new Random();
		for (int i = 0; i < quantidade; i++) {
			this.inserirInicio(random.nextInt(valor)); // Gera número aleatório entre 0 e o valor
		}
	}

	public void inserirOrdenado(int dado) {
		Nodo novoNodo = new Nodo(dado);
		if (inicio == null || dado <= inicio.getDado()) {
			if (inicio == null) {
				inicio = fim = novoNodo;
				fim.setProx(inicio);
			} else {
				novoNodo.setProx(inicio);
				inicio = novoNodo;
				fim.setProx(inicio); // Garante a circularidade após a inserção
			}
		} else {
			Nodo atual = inicio;
			while (atual.getProx() != inicio && atual.getProx().getDado() < dado) {
				atual = atual.getProx();
			}
			novoNodo.setProx(atual.getProx());
			atual.setProx(novoNodo);
			if (atual == fim) {
				fim = novoNodo; // Atualiza o fim se o novo nodo for o último
			}
		}
	}

	private double calcularMedia() {
		if (inicio == null)
			return 0;
		double soma = 0;
		int contador = 0;
		Nodo atual = inicio;
		do {
			soma += atual.getDado();
			contador++;
			atual = atual.getProx();
		} while (atual != inicio);
		return soma / contador;
	}

	private int calcularModa() {
		// Esta implementação assumirá que a moda é o elemento com maior frequência
		// encontrada primeiro.
		if (inicio == null)
			return -1; // Retorna -1 se a lista estiver vazia.

		Nodo atual = inicio;
		int moda = inicio.getDado();
		int maxFreq = 1;
		while (atual.getProx() != inicio) {
			int count = 1;
			Nodo cursor = atual.getProx();
			while (cursor != inicio) {
				if (cursor.getDado() == atual.getDado()) {
					count++;
				}
				cursor = cursor.getProx();
			}
			if (count > maxFreq) {
				maxFreq = count;
				moda = atual.getDado();
			}
			atual = atual.getProx();
		}
		return moda;
	}

	private double calcularMediana() {
		if (inicio == null)
			return 0; // Lista vazia.

		int count = 0;
		Nodo atual = inicio;
		do {
			count++;
			atual = atual.getProx();
		} while (atual != inicio);

		int middle = count / 2;
		boolean isEven = (count % 2 == 0);
		atual = inicio;
		for (int i = 0; i < middle - 1; i++) {
			atual = atual.getProx();
		}

		if (isEven) {
			double midValue = atual.getDado();
			double nextMidValue = atual.getProx().getDado();
			return (midValue + nextMidValue) / 2;
		} else {
			return atual.getProx().getDado();
		}
	}

	public void calcularEstatisticas() {
		System.out.println("Média: " + calcularMedia());
		System.out.println("Moda: " + calcularModa());
		System.out.println("Mediana: " + calcularMediana());
	}
}
