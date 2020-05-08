package Model;

import java.sql.Date;

import DAO.PagamentoDAO;

public class Credito extends FormaPagamento {
	private String numCartao;
	private String CCV;
	private String nomeTitular;
	private String validadeCartao;
	
	public Credito(String cPF, float valor) {
		super(cPF, valor);
	}

	public Credito(String cPF, float valor, String numCartao, String cCV, String nomeTitular,
			String validadeCartao) {
		super(cPF, valor);
		this.numCartao = numCartao;
		CCV = cCV;
		this.nomeTitular = nomeTitular;
		this.validadeCartao = validadeCartao;
	}
	
	public boolean pagar(Date data, float valor) {
		
		return registrarTransacao(getCPF(), data, "Credito", valor);
		
	}
	
	@Override
	public boolean registrarTransacao(String cpf, Date data, String formaPagamento, float valor) {
		
		PagamentoDAO pdao = new PagamentoDAO();
		return pdao.formaPagamento(valor, cpf, formaPagamento);
	}

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}

	public String getCCV() {
		return CCV;
	}

	public void setCCV(String cCV) {
		CCV = cCV;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(String validadeCartao) {
		this.validadeCartao = validadeCartao;
	}
	
	

	@Override
	public String toString() {
		return "DebitoCredito [numCartao=" + numCartao + ", CCV=" + CCV + ", nomeTitular=" + nomeTitular
				+ ", validadeCartao=" + validadeCartao + "]";
	}

	
	

}
