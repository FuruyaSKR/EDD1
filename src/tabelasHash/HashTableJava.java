package tabelasHash;

import java.util.HashMap;

public class HashTableJava {

    public static void main(String[] args) {
        HashMap<String, Integer> alunos = new HashMap<>();

        // Inserindo dados na HashMap
        alunos.put("João", 25);
        alunos.put("Maria", 21);
        alunos.put("Pedro", 20);

        System.out.println("Idade Maria " + alunos.get("Maria"));

        System.out.println();
        for (HashMap.Entry<String, Integer> input : alunos.entrySet()) {
            System.out.println("Nome: " + input.getKey());
            System.out.println("Idade: " + input.getValue());
            System.out.println();
        }

    }
}
