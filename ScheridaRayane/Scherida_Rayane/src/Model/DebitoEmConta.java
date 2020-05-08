package Model;

import java.sql.Date;

import DAO.PagamentoDAO;

public class DebitoEmConta extends FormaPagamento {
	private String AgenciaSacada;
	private String ContaCorrenteSacada;
	private String AgenciaBeneficiario;
	private String ContaCorrenteBeneficiario;
	private float valorTranferido;
	
	public DebitoEmConta(String agenciaSacada, String contaCorrenteSacada, String agenciaBeneficiario,
			String contaCorrenteBeneficiario, float valorTranferido) {
		super();
		AgenciaSacada = agenciaSacada;
		ContaCorrenteSacada = contaCorrenteSacada;
		AgenciaBeneficiario = agenciaBeneficiario;
		ContaCorrenteBeneficiario = contaCorrenteBeneficiario;
		this.valorTranferido = valorTranferido;
	}
	
	public boolean pagar(DebitoEmConta sacada, DebitoEmConta beneficiada, float valor) {
		
		java.util.Date dateUtil = new java.util.Date(); 
        java.sql.Date dateSql = new java.sql.Date (dateUtil.getTime());
		
		return registrarTransacao(getCPF(), dateSql, "Debito em Conta", valor);
	}
 	
	@Override
	public boolean registrarTransacao(String cpf, Date data, String formaPagamento, float valor) {
		PagamentoDAO pdao = new PagamentoDAO();
		return pdao.formaPagamento(valor, cpf, formaPagamento);
	}
	
	public DebitoEmConta() {
		super();
	}
	public String getAgenciaSacada() {
		return AgenciaSacada;
	}
	public void setAgenciaSacada(String agenciaSacada) {
		AgenciaSacada = agenciaSacada;
	}
	public String getContaCorrenteSacada() {
		return ContaCorrenteSacada;
	}
	public void setContaCorrenteSacada(String contaCorrenteSacada) {
		ContaCorrenteSacada = contaCorrenteSacada;
	}
	public String getAgenciaBeneficiario() {
		return AgenciaBeneficiario;
	}
	public void setAgenciaBeneficiario(String agenciaBeneficiario) {
		AgenciaBeneficiario = agenciaBeneficiario;
	}
	public String getContaCorrenteBeneficiario() {
		return ContaCorrenteBeneficiario;
	}
	public void setContaCorrenteBeneficiario(String contaCorrenteBeneficiario) {
		ContaCorrenteBeneficiario = contaCorrenteBeneficiario;
	}
	public float getValorTranferido() {
		return valorTranferido;
	}
	public void setValorTranferido(float valorTranferido) {
		this.valorTranferido = valorTranferido;
	}
	@Override
	public String toString() {
		return "DebitoEmConta [AgenciaSacada=" + AgenciaSacada + ", ContaCorrenteSacada="
				+ ContaCorrenteSacada + ", AgenciaBeneficiario=" + AgenciaBeneficiario + ", ContaCorrenteBeneficiario="
				+ ContaCorrenteBeneficiario + ", valorTranferido=" + valorTranferido + "]";
	}
	
	
}
