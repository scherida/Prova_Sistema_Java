package Model;

import Interface.IFormaPagamento;

//Tirar todas as inf. possíveis de pagamento
public abstract class FormaPagamento implements IFormaPagamento{
	private String CPF;
	private float valor;
	
	public FormaPagamento(String cPF, float valor) {
		super();
		CPF = cPF;
		this.valor = valor;
	}

	public FormaPagamento() {
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "FormaPagamento [CPF=" + CPF + ", valor=" + valor + "]";
	}

}
