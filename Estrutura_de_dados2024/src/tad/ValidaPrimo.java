package tad;

public class ValidaPrimo {
	
	private int num;
	
	public ValidaPrimo (int n1) {
		this.num = n1;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public String ValidadorPrimo() {
		int divisores = 0;
		for(int i = 1; i <= num;i++) {
			if(num % i == 0) {
				divisores++;
			}
		}
	
		if(divisores == 2) {
			return "Primo";
		}else {
			return "Não é primo";
		}
	}

}
