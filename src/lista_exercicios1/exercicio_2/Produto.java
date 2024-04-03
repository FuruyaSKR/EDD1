package lista_exercicios1.exercicio_2;

public class Produto {
    private int codigo;
    private double preco;
    private int quantidadeEstocada;

    // Construtor
    public Produto(int codigo, double preco, int quantidadeEstocada) {
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstocada = quantidadeEstocada;
    }

    // Getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstocada() {
        return quantidadeEstocada;
    }

    public void setQuantidadeEstocada(int quantidadeEstocada) {
        this.quantidadeEstocada = quantidadeEstocada;
    }
}

