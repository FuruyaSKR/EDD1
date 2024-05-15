package tad;

public class main {

	public static void Main(String[] args) {
		SomaMultiplica ex0 = new SomaMultiplica(3,5);
		System.out.println("Soma = "+ex0.soma());
		
		ValidaCPF ex1 = new ValidaCPF("212121212121");
		System.out.println(ex1.ValidadorDeCpf());
		
		ValidaPrimo ex2 = new ValidaPrimo(5);
		System.out.println(ex2.ValidadorPrimo());
	}

}
