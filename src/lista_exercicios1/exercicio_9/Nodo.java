package lista_exercicios1.exercicio_9;

public class Nodo {
    int dado;
    String nome;
    double salario;
    Nodo prox;

    // construtor
    public Nodo(int dado, String nome, double salario) {
        this.dado = dado;
        this.nome = nome;
        this.salario = salario;
        this.prox = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

}