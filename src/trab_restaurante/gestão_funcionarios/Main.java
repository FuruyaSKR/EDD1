package trab_restaurante.gestão_funcionarios;

public class Main {
    public static void main(String[] args) {
        ListaEncadeadaFuncionarios listaDeFuncionarios = new ListaEncadeadaFuncionarios();

        listaDeFuncionarios.cadastrarFuncionario(1, "João Silva", "Garçom", "Manhã");
        listaDeFuncionarios.cadastrarFuncionario(2, "Ana Souza", "Cozinheira", "Noite");

        System.out.println("\nFuncionários cadastrados:");
        listaDeFuncionarios.consultarFuncionario();

        System.out.println("\nEscala de funcionário atualizada:");
        listaDeFuncionarios.atualizarEscala(1, "Tarde");
        listaDeFuncionarios.consultarFuncionario();

        System.out.println("\nRemover de funcionário:");
        listaDeFuncionarios.removerFuncionario(2);
        listaDeFuncionarios.consultarFuncionario();

        System.out.println("\nFuncionários após atualizações:");
        listaDeFuncionarios.consultarFuncionario();
    }
}
