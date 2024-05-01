package trab_restaurante.gestão_funcionarios;

public class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private String escala;
    private Funcionario prox;

    public Funcionario(int id, String nome, String cargo, String escala) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.escala = escala;
        this.prox = null;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Funcionario getProx() {
        return prox;
    }

    public void setProx(Funcionario prox) {
        this.prox = prox;
    }
}
