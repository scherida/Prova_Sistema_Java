package Model;

import java.sql.Date;

public class Compra {
	private float valorTotal;
	private int numCompra;
	private String CPF;
	private Date dataVenda;
	private String formaPagamento;
	public Compra(float valorTotal, int numCompra, String cPF, Date dataVenda, String formaPagamento) {
		super();
		this.valorTotal = valorTotal;
		this.numCompra = numCompra;
		CPF = cPF;
		this.dataVenda = dataVenda;
		this.formaPagamento = formaPagamento;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getNumCompra() {
		return numCompra;
	}
	public void setNumCompra(int numCompra) {
		this.numCompra = numCompra;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	@Override
	public String toString() {
		return "Compra [valorTotal=" + valorTotal + ", numCompra=" + numCompra + ", CPF=" + CPF + ", dataVenda="
				+ dataVenda + ", formaPagamento=" + formaPagamento + "]";
	}
	
}
