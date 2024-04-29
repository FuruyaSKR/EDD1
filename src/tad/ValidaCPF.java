package tad;

public class ValidaCPF {

	private String cpf = "";
	
	public ValidaCPF (String n1) {
		this.cpf = n1;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String ValidadorDeCpf () {
		if (cpf.length() >= 11 && cpf.length() <= 14) {
			return "CPF Válido!";
		}
		return "CPF Inválido!";
	}
	
}
