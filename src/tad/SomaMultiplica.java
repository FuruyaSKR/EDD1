package tad;

public class SomaMultiplica {
	private int a = 0, b= 0;

	public SomaMultiplica (int n1, int n2) {
		this.a = n1;
		this.b = n2;
	}
	
	public int soma() {
		return a + b;
	}
	
	public int multiplica() {
		return a * b;
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
}
