package tabelasHash;

public class TesteHash {

	public static void main(String[] args) {
		HashTable tabelaHash = new HashTable(3);

		tabelaHash.inserir("111", "Pedro");
		tabelaHash.inserir("222", "João");
		tabelaHash.inserir("333", "Maria");

		System.out.println("Versão 1");
		System.out.println(tabelaHash.recuperar("222"));
		System.out.println(tabelaHash.recuperar("111"));
		System.out.println(tabelaHash.recuperar("333"));

		HashTable2 tabelaHash2 = new HashTable2(3);

		tabelaHash2.inserir("111", "Pedro");
		tabelaHash2.inserir("222", "João");
		tabelaHash2.inserir("333", "Maria");

		System.out.println("");
		System.out.println("Versão 2");
		System.out.println(tabelaHash2.recuperar("222"));
		System.out.println(tabelaHash2.recuperar("111"));
		System.out.println(tabelaHash2.recuperar("333"));

		HashTable3 tabelaHash3 = new HashTable3(3);

		tabelaHash3.inserir("111", "Pedro");
		tabelaHash3.inserir("222", "João");
		tabelaHash3.inserir("333", "Maria");

		System.out.println("");
		System.out.println("Versão 3");
		System.out.println(tabelaHash3.recuperar("222"));
		System.out.println(tabelaHash3.recuperar("111"));
		System.out.println(tabelaHash3.recuperar("333"));

	}

}
