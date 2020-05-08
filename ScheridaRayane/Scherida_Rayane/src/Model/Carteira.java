package Model;

import java.sql.Date;

import DAO.PagamentoDAO;

public class Carteira extends FormaPagamento {
	private int id;
	private float saldo;
	private String email;
	public Carteira(int id, float saldo, String email) {
		super();
		this.id = id;
		this.saldo = saldo;
		this.email = email;
	}
	
	public boolean pagar(Date data, String moeda, float valor) {
		return registrarTransacao(getCPF(), data, "Carteira Digital", valor);
	}
	@Override
	public boolean registrarTransacao(String cpf, Date data, String formaPagamento, float valor) {
		
		PagamentoDAO pdao = new PagamentoDAO();
		return pdao.formaPagamento(valor, cpf, formaPagamento);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Carteira [id=" + id + ", saldo=" + saldo + ", email=" + email + "]";
	}
	
	
	
}
